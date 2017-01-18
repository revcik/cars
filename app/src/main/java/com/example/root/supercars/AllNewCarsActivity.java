package com.example.root.supercars;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AllNewCarsActivity extends Activity {
    private static String[] Years;
    private static String[] Brands;
    private static String[] Models;
    private static int[] Images;
    private static ListView list;
    private static TextView attrText;
    private  Cursor cursor;
    private  Cursor cursor2;
    public static SQLiteDatabase db;
    private static SQLiteOpenHelper carsdb;
    public static int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_new_cars);
        attrText = (TextView)findViewById(R.id.textattr);

        try {
            list = (ListView) findViewById(R.id.all_cars_list);
            carsdb = new CarsDatabaseHelper(this);
            db = carsdb.getReadableDatabase();
            cursor = db.query("NEWCARS", new String[]{"_id", "BRAND", "MODEL"}, null, null, null, null, null);
            TodoCursorAdapter todo = new TodoCursorAdapter(this, cursor);
            list.setAdapter(todo);

//            Years = new String[cursor.getCount()];
//            Brands = new String[cursor.getCount()];
//            Models = new String[cursor.getCount()];
//            Images = new int[cursor.getCount()];
//            cursor.moveToFirst();
//            for (int i = 0; i < Years.length; i++) {
//                Years[i] = cursor.getString(cursor.getColumnIndex("YEAR"));
//                cursor.moveToNext();
//            }
//            cursor.moveToFirst();
//            for (int i = 0; i < Brands.length; i++) {
//                Brands[i] = cursor.getString(cursor.getColumnIndex("BRAND"));
//                cursor.moveToNext();
//            }
//            cursor.moveToFirst();
//            for (int i = 0; i < Models.length; i++) {
//                Models[i] = cursor.getString(cursor.getColumnIndex("MODEL"));
//                cursor.moveToNext();
//            }



        } catch (SQLiteException e) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }


    }

    protected void onDestroy() {
        super.onDestroy();
        cursor2.close();
        if(!cursor.isClosed()){
            cursor.close();
        }
        a = 0;
        db.close();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sortmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.weight:
                cursor.close();
                a = 1;
                carsdb = new CarsDatabaseHelper(this);
                db = carsdb.getReadableDatabase();
                cursor2 = db.query("NEWCARS", new String[]{"_id", "BRAND", "MODEL", "WEIGHT"}, null, null, null, null, "WEIGHT DESC");
                TodoCursorAdapter todo = new TodoCursorAdapter(this, cursor2);
                attrText.setText("ВЕС КГ");
                list.setAdapter(todo);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

}
