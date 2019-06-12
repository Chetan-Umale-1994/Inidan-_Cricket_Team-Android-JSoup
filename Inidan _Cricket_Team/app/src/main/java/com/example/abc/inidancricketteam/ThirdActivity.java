package com.example.abc.inidancricketteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    WebView web1 = null;
    Button b1 = null;
    private Intent intent = null;
    Bundle bundle = null;
    private Person data = null;
    private Button AnalysisButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        Intent intent = getIntent();
        Log.d("DEBUG", "intent made " );
        bundle = intent.getExtras();
        data = (Person)bundle.getSerializable("data");

         web1 = findViewById(R.id.web1);
       web1.setWebViewClient(new WebViewClient());
       web1.loadUrl(data.getUrl());

        AnalysisButton = findViewById(R.id.button_analysis);

        AnalysisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });



    }
}
