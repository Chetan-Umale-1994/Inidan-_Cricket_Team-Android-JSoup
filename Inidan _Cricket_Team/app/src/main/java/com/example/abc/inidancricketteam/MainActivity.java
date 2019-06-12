package com.example.abc.inidancricketteam;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity  extends ListActivity {


    private XMLPeopleData peopleData = null;
    Intent intent = null;
    Bundle b = null;
    Integer[] imageResId = null;
    String[] imageName=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        peopleData = new XMLPeopleData(getApplicationContext());

        imageResId = new Integer[peopleData.getLength()];
        imageName = new String[peopleData.getLength()];


        imageName = peopleData.getImages();



        for(int i=0;i<peopleData.getLength();i++)
        {

            imageName[i] = imageName[i].substring(0, imageName[i].indexOf("."));

            imageResId[i] = getResources().getIdentifier(
                    imageName[i],
                    "drawable",
                    getPackageName());
        }




        CustomIconLabelAdapter adapter = new CustomIconLabelAdapter(
                this,
                R.layout.player_item,
                peopleData.getNames(),
                peopleData.getRoles(),
                imageResId);


        setListAdapter(adapter);

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        intent = new Intent(getApplicationContext(), SecondActivity.class);
        b = new Bundle();

        Log.d("DEBUG", " Bundle made \n");

        b.putSerializable("data", peopleData.getPersonData(position));
        Log.d("DEBUG", " string put in bundle \n");

        // Toast.makeText(getApplicationContext(), ((Person)b.getSerializable("data")).getName(), Toast.LENGTH_LONG).show();

        intent.putExtras(b);



        startActivity(intent);


    }
}
