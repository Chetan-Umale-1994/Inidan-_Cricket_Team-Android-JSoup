package com.example.abc.inidancricketteam;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FourthActivity extends AppCompatActivity {



    private Intent intent = null;
    private Bundle bundle = null;
    private Person data = null;
    private String[] runs_scored;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;
    BarChart barChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);



        Intent intent = getIntent();
        Log.d("DEBUG", "intent made " );
        bundle = intent.getExtras();
        data = (Person)bundle.getSerializable("data");

        barChart = (BarChart) findViewById(R.id.barchart);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        getWebsite();

    }

    private void getWebsite() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();
                final StringBuilder builder1 = new StringBuilder();
                final StringBuilder builder2 = new StringBuilder();

                try {
                    Document doc = Jsoup.connect(data.getUrl()).get();


                    int flag=0,count=0;
                    Element body = doc.body();
                    Elements paragraphs = body.getAllElements();
                    for (Element paragraph : paragraphs) {

                        if(paragraph.text().equalsIgnoreCase("Last 5 Matches in ODIs"))
                        {
                            flag=1;


                        }

                        if(flag==1)
                        {

                            builder.append(paragraph.text());
                            count++;
                            if(count>1)
                            {
                                break;
                            }

                        }


                    }

                    String[] a = builder.toString().split(" ");
                    int l=0;
                    for(String b:a)
                    {
                        if(b.contains("(") || b.contains("DNB"))
                        {

                            builder1.append(b).append(" ");
                        }

                        }

                        String[] c = builder1.toString().split(" ");


                    for(String d:c)
                    {
                        if(d.contains("*"))
                        {
                            l=d.indexOf("*");
                        }
                        else if(d.contains("("))
                        {
                            l=d.indexOf("(");
                        }

                        if(d.contains("DNB"))
                        {
                            builder2.append("0").append(" ");
                        }
                        else
                        {
                            builder2.append(d.substring(0,l)).append(" ");

                        }

                    }

                    runs_scored = builder2.toString().split(" ");

                    BARENTRY.add(new BarEntry(Integer.parseInt(runs_scored[0]), 0));
                    BARENTRY.add(new BarEntry(Integer.parseInt(runs_scored[1]), 1));
                    BARENTRY.add(new BarEntry(Integer.parseInt(runs_scored[2]), 2));
                    BARENTRY.add(new BarEntry(Integer.parseInt(runs_scored[3]), 3));
                    BARENTRY.add(new BarEntry(Integer.parseInt(runs_scored[4]), 4));

                    BarEntryLabels.add("First");
                    BarEntryLabels.add("Second");
                    BarEntryLabels.add("Third");
                    BarEntryLabels.add("Fourth");
                    BarEntryLabels.add("Fifth");

                    Bardataset = new BarDataSet(BARENTRY, "Runs scored in last 5 matches");

                    BARDATA = new BarData(BarEntryLabels, Bardataset);

                    Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);



                } catch (IOException e) {
                    builder.append("Error : ").append(e.getMessage()).append("\n");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        barChart.setData(BARDATA);

                        barChart.animateY(3000);





                    }
                });
            }
        }).start();
    }

}
