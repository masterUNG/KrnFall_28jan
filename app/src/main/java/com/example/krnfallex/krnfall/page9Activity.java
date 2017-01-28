package com.example.krnfallex.krnfall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class page9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page9);
    }

    public void clickvoiceeng2(View view) {
        startActivity(new Intent(page9Activity.this, page3Activity.class));
    }
}
