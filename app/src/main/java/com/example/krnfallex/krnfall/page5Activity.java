package com.example.krnfallex.krnfall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class page5Activity extends AppCompatActivity {
  //*  DatabaseHelper myDb;
  //*  @Override
    //* protected void onCreate(Bundle savedInstanceState){
  //*    super.onCreate(savedInstanceState);
    //*  setContentView(R.layout.activity_page5);
    //*   myDb = new DatabaseHelper(this);
    //*  }


    public void infomationth(View v) {
        TextView text = (TextView) findViewById(R.id.textView6);

        text.setText(R.string.txth2);
    }
    public void titleviewth(View v) {
        TextView text = (TextView) findViewById(R.id.textView6);

        text.setText(R.string.txth3);
    }

    ImageButton b;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);

        b=(ImageButton) findViewById(R.id.imageButtoncallth);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0955908383"));
                startActivity(callIntent);

            }
        });

        myDb = new DatabaseHelper(this);
    }
    public void clickreternerawanth(View view) {
        //startActivity(new Intent(page5Activity.this, page2Activity.class));
    }

    public void clicyoutube(View view) {
        startActivity(new Intent(page5Activity.this, youtube.class));
    }


}
