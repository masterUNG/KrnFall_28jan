package com.example.krnfallex.krnfall;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class PageInfoActivity extends AppCompatActivity {


    WaterfallInfoTable waterfallInfoTable;
    HashMap<String, String> infodetail;
    TextView in_nameth, in_genaralth, in_historyth, in_feeth, in_travelth, in_url360, in_video_path, in_tellophone;
    Double tatal;
    EditText editCal_Total;
    SimpleDateFormat df_show;
    ImageButton mDialogSimple;
    String numberPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_info);


        waterfallInfoTable = new WaterfallInfoTable(this);

        //รับค่าแต่ละหน้า Show id
        Intent intent2 = getIntent();
        final int waterfall_id = intent2.getIntExtra("waterfall_id", 0);

        infodetail = waterfallInfoTable.WalterfallInfo(waterfall_id);

        in_nameth = (TextView) findViewById(R.id.namefallth);
        in_genaralth = (TextView) findViewById(R.id.txtgeneralth);
        in_feeth = (TextView) findViewById(R.id.txtfeeth);

        in_nameth.setText(infodetail.get("name_th"));
        in_genaralth.setText(infodetail.get("genaral_th"));

        Log.d("28janV1", "ทดสอบการ Get ชื่อน้ำตก ==> " + infodetail.get("name_th"));
        Log.d("28janV1", "ทดสอบการ Get Lat ==> " + infodetail.get("latitude"));
        Log.d("28janV1", "ทดสอบการ Get Lng ==> " + infodetail.get("longitude"));


        RelativeLayout d = (RelativeLayout) findViewById(R.id.imgbg);

        if (waterfall_id == 1) {
            d.setBackgroundResource(R.drawable.pagelsth1);
        }

        if (waterfall_id == 2) {
            d.setBackgroundResource(R.drawable.pagelsth2);
        }
        if (waterfall_id == 2) {
            d.setBackgroundResource(R.drawable.pagelsth2);
        }
        if (waterfall_id == 3) {
            d.setBackgroundResource(R.drawable.pagelsth3);
        }
        if (waterfall_id == 4) {
            d.setBackgroundResource(R.drawable.pagelsth4);
        }
        if (waterfall_id == 5) {
            d.setBackgroundResource(R.drawable.pagelsth5);
        }
        if (waterfall_id == 6) {
            d.setBackgroundResource(R.drawable.pagelsth6);
        }
        if (waterfall_id == 7) {
            d.setBackgroundResource(R.drawable.pagelsth7);
        }
        if (waterfall_id == 8) {
            d.setBackgroundResource(R.drawable.pagelsth8);
        }
        if (waterfall_id == 9) {
            d.setBackgroundResource(R.drawable.pagelsth9);
        }
        if (waterfall_id == 10) {
            d.setBackgroundResource(R.drawable.pagelsth10);
        }
        if (waterfall_id == 11) {
            d.setBackgroundResource(R.drawable.pagelsth11);
        }
        if (waterfall_id == 12) {
            d.setBackgroundResource(R.drawable.pagelsth12);
        }
        if (waterfall_id == 13) {
            d.setBackgroundResource(R.drawable.pagelsth13);
        }
        if (waterfall_id == 14) {
            d.setBackgroundResource(R.drawable.pagelsth14);
        }
        if (waterfall_id == 15) {
            d.setBackgroundResource(R.drawable.pagelsth15);
        }
        if (waterfall_id == 16) {
            d.setBackgroundResource(R.drawable.pagelsth16);
        }
        if (waterfall_id == 17) {
            d.setBackgroundResource(R.drawable.pagelsth17);
        }
        if (waterfall_id == 18) {
            d.setBackgroundResource(R.drawable.pagelsth18);
        }
        if (waterfall_id == 19) {
            d.setBackgroundResource(R.drawable.pagelsth19);
        }
        if (waterfall_id == 20) {
            d.setBackgroundResource(R.drawable.pagelsth20);
        }
        if (waterfall_id == 21) {
            d.setBackgroundResource(R.drawable.pagelsth21);
        }


        mDialogSimple = (ImageButton) findViewById(R.id.imageButtoncallth);
        mDialogSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberPhone = infodetail.get("tellophone");

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(PageInfoActivity.this);
                builder.setMessage(numberPhone);
                builder.setPositiveButton("โทร", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + numberPhone));
                        startActivity(callIntent);
                    }
                });
                builder.setNegativeButton("ยกเลิก", null);
                builder.create();

                // สุดท้ายอย่าลืม show() ด้วย
                builder.show();
            }
        });

    }   // Main Class

    public void clickGpsFall(View view) {

        Intent intent = new Intent(PageInfoActivity.this, GpsFall.class);
        intent.putExtra("NameFall", infodetail.get("name_th"));
        intent.putExtra("Lat", infodetail.get("latitude"));
        intent.putExtra("Lng", infodetail.get("longitude"));
        startActivity(intent);

    }   // click


    public void titleview(View v) {
        TextView text = (TextView) findViewById(R.id.txtgeneralth);
        in_genaralth.setText(infodetail.get("genaral_th"));
        TextView text2 = (TextView) findViewById(R.id.textView7);
        text2.setText(R.string.txt_null);
        TextView text3 = (TextView) findViewById(R.id.txtfeeth);
        text3.setText(R.string.txt_null);
        TextView text4 = (TextView) findViewById(R.id.textView7);
        text4.setText(R.string.txt_null);
        TextView text5 = (TextView) findViewById(R.id.texttravelth);
        text5.setText(R.string.txt_null);
    }

    public void historyth(View v) {
        in_historyth = (TextView) findViewById(R.id.txtgeneralth);
        in_historyth.setText(infodetail.get("history_th"));
        TextView text2 = (TextView) findViewById(R.id.textView7);
        text2.setText(R.string.txt_feeth);
        in_feeth = (TextView) findViewById(R.id.txtfeeth);
        in_feeth.setText(infodetail.get("fee_th"));
        TextView text3 = (TextView) findViewById(R.id.textView8);
        text3.setText(R.string.txt_travelth);
        in_travelth = (TextView) findViewById(R.id.texttravelth);
        in_travelth.setText(infodetail.get("travel_th"));
    }

    public void btrtif(View view) {
        startActivity(new Intent(PageInfoActivity.this, ListthActivity.class));

    }


}




