package com.example.abc.inidancricketteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private ImageView personImageView = null;
    private Button moreInfoButton = null;
    private Intent intent = null;

    private Person data = null;
    Bundle bundle = null;

    TextView name = null;
    TextView dob = null;
    TextView place = null;
    TextView role = null;
    TextView batting_style = null;
    TextView bowling_style = null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Log.d("DEBUG", "intent made " );
        bundle = intent.getExtras();
        data = (Person)bundle.getSerializable("data");
        // wire
        personImageView = findViewById(R.id.imageView);
        moreInfoButton  = findViewById(R.id.button1);

        name = findViewById(R.id.name);
        role = findViewById(R.id.role);
        dob = findViewById(R.id.dob);
        place = findViewById(R.id.place);
        batting_style = findViewById(R.id.batting_style);
        bowling_style = findViewById(R.id.bowling_style);





        // set the image from data.image
        String imageName = data.getImage();
        imageName = imageName.substring(0, imageName.indexOf("."));

        int imageResId = getResources().getIdentifier(
                imageName,
                "drawable",
                getPackageName());

        personImageView.setImageResource(imageResId);
        name.setText(data.getName());
        dob.setText(data.getDob());
        place.setText(data.getPlace());
        role.setText(data.getRole());
        batting_style.setText(data.getBatting_style());
        bowling_style.setText(data.getBowling_style());


        moreInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });



    }
}
