package com.example.krnfallex.krnfall;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListthActivity extends AppCompatActivity {

    ListView listView;
    ListAdapter listAdapter;
    WaterfallInfoTable waterfallnfoTable;
    ArrayList<HashMap<String, Object>> ListthActivity;
    String name_th ;
    int waterfall_id;
    SQLiteDatabase db;
    ImageView listmg;
    private MyDatabase myDatabase;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        setContentView(R.layout.activity_listth);
        listView = (ListView) findViewById(R.id.listView);
        waterfallnfoTable = new WaterfallInfoTable(this);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                waterfall_id = Integer.parseInt(ListthActivity.get(i).get(waterfallnfoTable.waterfall_id).toString());
                name_th = ListthActivity.get(i).get(waterfallnfoTable.name_th).toString();
                Intent intent;
                intent = new Intent(ListthActivity.this, PageInfoActivity.class);
                intent.putExtra("waterfall_id", waterfall_id);
                startActivity(intent);

            };

        });
        ListthActivity = waterfallnfoTable.getImage();

        listAdapter = new SimpleAdapter(ListthActivity.this, ListthActivity, R.layout.falllist, new String[]{waterfallnfoTable.listmg,waterfallnfoTable.name_th}, new int[]{R.id.listmg,});

        listView.setAdapter(listAdapter);

        editText1 = (EditText)findViewById(R.id.editText);
        editText1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable arg0) {
                //ArrayList<String, String> src_list = new ArrayList<String, string>();
                ArrayList<HashMap<String, Object>> src_list = new ArrayList<HashMap<String, Object>>();
                //ArrayList<HashMap<String, Objects>> src_list = new ArrayList<HashMap<String, Objects>>();
                int textlength = editText1.getText().length();
                if (textlength > 0) {
                    for (int i = 0; i < ListthActivity.size(); i++) {
                        try {
                            HashMap<String, Object> hm = new HashMap<String, Object>();
                            if (containsIgnoreCase(ListthActivity.get(i).get(waterfallnfoTable.name_th).toString(), editText1.getText().toString())) {
                                hm.put("listmg", Integer.toString(waterfallnfoTable.imgsList[i]));
                                src_list.add(hm);
                            }
                        } catch (Exception e) {
                        }
                    }

                    listAdapter = new SimpleAdapter(ListthActivity.this, src_list, R.layout.falllist, new String[]{waterfallnfoTable.listmg, waterfallnfoTable.name_th}, new int[]{R.id.listmg,});
                    listView.setAdapter(listAdapter);
                }
                else
                {
                    listAdapter = new SimpleAdapter(ListthActivity.this, ListthActivity, R.layout.falllist, new String[]{waterfallnfoTable.listmg,waterfallnfoTable.name_th}, new int[]{R.id.listmg,});
                    listView.setAdapter(listAdapter);
                }

            }
            public void beforeTextChanged(CharSequence s, int start
                    , int count, int after) { }
            public void onTextChanged(CharSequence s, int start
                    , int before, int count) { }

        });


        }

    public boolean containsIgnoreCase( String nameth, String search_nameth ) {
        if(search_nameth.equals(""))
            return true;
        if(nameth == null || search_nameth == null || nameth .equals(""))
            return false;

        Pattern p = Pattern.compile(search_nameth,Pattern.CASE_INSENSITIVE+Pattern.LITERAL);
        Matcher m = p.matcher(nameth);
        return m.find();
    }

    public Bitmap getImage(int i){

        String qu = "select listmg waterfall table where feedid=" + i ;
        Cursor cur = db.rawQuery(qu, null);

        if (cur.moveToFirst()){
            byte[] imgByte = cur.getBlob(0);
            cur.close();
            return BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
        }
        if (cur != null && !cur.isClosed()) {
            cur.close();
        }

        return null ;
    }
}
