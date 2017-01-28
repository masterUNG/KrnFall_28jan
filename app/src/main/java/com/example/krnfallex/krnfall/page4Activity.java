package com.example.krnfallex.krnfall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class page4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
    }
    public void clickarawan(View view) {
        startActivity(new Intent(page4Activity.this, page5Activity.class));
    }
    public void clickreternpmapth(View view) {
        //startActivity(new Intent(page4Activity.this, page2Activity.class));
    }
}
