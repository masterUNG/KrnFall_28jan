package com.example.krnfallex.krnfall;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class page6Activity extends AppCompatActivity {
    ViewPager viewPager;
    int images[] = {R.drawable.pig1, R.drawable.pig2, R.drawable.pig3};
    MyCustomPagerAdapter myCustomPagerAdapter;

    public void titleview(View v) {
        TextView text = (TextView) findViewById(R.id.textView5);

        text.setText(R.string.txth1);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(page6Activity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);

        TextView text2 = (TextView) findViewById(R.id.textView4);
        text2.setText(R.string.txt_null);

       // ImageView kuysah = (ImageView) findViewById(R.id.viewPager);
       // kuysah.setVisibility(View.VISIBLE);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setVisibility(View.GONE);
    }



    ImageButton b;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);

        b=(ImageButton) findViewById(R.id.imageButtoncall);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0955908383"));
                startActivity(callIntent);

            }
        });
       viewPager = (ViewPager)findViewById(R.id.viewPager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(page6Activity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);

    }
    public void clickreternerawaneng(View view) {
        startActivity(new Intent(page6Activity.this, page3Activity.class));

    }
    public void clickmapapi(View view) {
        startActivity(new Intent(page6Activity.this, MapsActivity.class));

    }
    public void clicyoutube1(View view) {
        startActivity(new Intent(page6Activity.this, youtube.class));
    }
    public void infomation(View v) {

        TextView text = (TextView) findViewById(R.id.textView5);

        text.setText(R.string.txeng2);

        TextView text2 = (TextView) findViewById(R.id.textView4);
        text2.setText(R.string.txth3);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setVisibility(View.VISIBLE);


    }
}
