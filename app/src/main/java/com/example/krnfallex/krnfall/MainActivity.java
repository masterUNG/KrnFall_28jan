package com.example.krnfallex.krnfall;

import android.app.*;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"supermarket.ttf");
        TextView myTextview = (TextView)findViewById(R.id.textView);
        myTextview.setTypeface(myTypeface);
    }
    public void clickThai(View view) {
        startActivity(new Intent(MainActivity.this, ListthActivity.class));
    }

    public void clickEng(View view) {
        startActivity(new Intent(MainActivity.this, page3Activity.class));
    }

    public void clicklist(View view) {
       // startActivity(new Intent(MainActivity.this, page2Activity.class));
    }

}