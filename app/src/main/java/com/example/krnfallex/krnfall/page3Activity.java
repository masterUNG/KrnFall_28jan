package com.example.krnfallex.krnfall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class page3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
    }
    public void clickmapeng(View view) {
        startActivity(new Intent(page3Activity.this, page7Activity.class));
    }
    public void arawaneng(View view) {
        startActivity(new Intent(page3Activity.this, page6Activity.class));
    }
    public void clickvoiceeng(View view) {
        startActivity(new Intent(page3Activity.this, PagevoiceActivity.class));
    }
    public void clickreturnpageeng(View view) {
        startActivity(new Intent(page3Activity.this, MainActivity.class));
    }
}
