package com.example.krnfallex.krnfall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class page7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page7);
    }
    public void clickreternpmapeng(View view) {
        startActivity(new Intent(page7Activity.this, page3Activity.class));
    }
    public void clickerawaneng(View view) {
        startActivity(new Intent(page7Activity.this, page6Activity.class));
    }
}
