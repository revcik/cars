package com.example.root.supercars;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AllNewCarsActivity extends Activity implements View.OnClickListener {
    private static String[] Years;
    private static String[] Brands;
    private static String[] Models;
    private static int[] Images;
    private static ListView list;
    private static TextView attrText;
    private static Cursor cursor;
    private static Cursor cursor2;
    public static SQLiteDatabase db;
    private static SQLiteOpenHelper carsdb;
    public static boolean isSortAttrSelected;
    public static String sortAttr;
    private static String sortText;
    private static Cursor cursorUP;
    private static Cursor cursorDOWN;
    private boolean sortAttrClicked;
    private static AllNewCarsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_new_cars);
        attrText = (TextView)findViewById(R.id.textattr);
        ImageButton upButton = (ImageButton)findViewById(R.id.ASC);
        upButton.setOnClickListener(this);
        ImageButton downButton = (ImageButton)findViewById(R.id.DESC);
        downButton.setOnClickListener(this);
        try {
            list = (ListView) findViewById(R.id.all_cars_list);
            carsdb = new CarsDatabaseHelper(this);
            db = carsdb.getReadableDatabase();
            sortAttr = "BRAND";
            cursor = db.query("NEWCARS", new String[]{"_id", "BRAND", "MODEL"}, null, null, null, null, sortAttr + " ASC");
            adapter = new AllNewCarsListAdapter(this, cursor);
            list.setAdapter(adapter);

//            int[] ids = new int[list.getCount()];
//            for(int i=0; i<ids.length; i++){
//                ids[i] = list[i];
//            }
            AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> listView, View v, int position, long id){
                    NewCarsDetailActivity.a = 1;
                    TextView model = (TextView)v.findViewById(R.id.model);
                    String mdl = model.getText().toString();
                    Intent intent = new Intent(AllNewCarsActivity.this, NewCarsDetailActivity.class);
                    intent.putExtra(NewCarsDetailActivity.CAR_MODEL, mdl);
                    startActivity(intent);



                }
            };
            list.setOnItemClickListener(itemClickListener);
        } catch (SQLiteException e) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        isSortAttrSelected = false;
        cursor.close();
        db.close();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sortmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.bhpsortM:
                isSortAttrSelected = true;
                sortAttr = "BHP";
                sortText = "Л.С.";
                carsdb = new CarsDatabaseHelper(this);
                db = carsdb.getReadableDatabase();
                cursor = db.query("NEWCARS", new String[]{"_id", "BRAND", "MODEL", sortAttr}, null, null, null, null, sortAttr + " DESC");
                adapter.swapCursor(cursor);
                attrText.setText(sortText);
                list.setAdapter(adapter);
                return true;
            case R.id.speedsortM:
                isSortAttrSelected = true;
                sortAttr = "SPEED";
                sortText = "КМ/Ч";
                carsdb = new CarsDatabaseHelper(this);
                db = carsdb.getReadableDatabase();
                cursor = db.query("NEWCARS", new String[]{"_id", "BRAND", "MODEL", sortAttr}, null, null, null, null, sortAttr + " DESC");
                adapter.swapCursor(cursor);
                attrText.setText(sortText);
                list.setAdapter(adapter);
                return true;
            case R.id.enginesortM:
                isSortAttrSelected = true;
                sortAttr = "ENGINE";
                sortText = "ЛИТР";
                carsdb = new CarsDatabaseHelper(this);
                db = carsdb.getReadableDatabase();
                cursor = db.query("NEWCARS", new String[]{"_id", "BRAND", "MODEL", sortAttr}, null, null, null, null, sortAttr + " DESC");
                adapter.swapCursor(cursor);
                attrText.setText(sortText);
                list.setAdapter(adapter);
                return true;
            case R.id.pricesortM:
                isSortAttrSelected = true;
                sortAttr = "PRICE";
                sortText = "USD";
                carsdb = new CarsDatabaseHelper(this);
                db = carsdb.getReadableDatabase();
                cursor = db.query("NEWCARS", new String[]{"_id", "BRAND", "MODEL", "PRICE"}, null, null, null, null, sortAttr + " DESC");
                adapter.swapCursor(cursor);
                attrText.setText(sortText);
                list.setAdapter(adapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void up(View view){
        cursor = db.query("NEWCARS",new String[]{"_id", "YEAR", "BRAND", "MODEL", "ENGINE", "WEIGHT", "BHP", "ACCEL", "SPEED", "PRICE"}, null, null, null, null, sortAttr +" DESC");
        adapter.swapCursor(cursor);
        attrText.setText(sortText);
        list.setAdapter(adapter);
    }

    public void down(View view) {
        cursor = db.query("NEWCARS", new String[]{"_id", "YEAR", "BRAND", "MODEL", "ENGINE", "WEIGHT", "BHP", "ACCEL", "SPEED", "PRICE"}, null, null, null, null, sortAttr + " ASC");
        adapter.swapCursor(cursor);
        attrText.setText(sortText);
        list.setAdapter(adapter);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.ASC:
                up(v);
                break;
            case R.id.DESC:
                down(v);
                break;
        }
    }

}


