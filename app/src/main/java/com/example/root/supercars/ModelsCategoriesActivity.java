package com.example.root.supercars;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import static com.example.root.supercars.NewCarsDetailActivity.CAR_MODEL;

public class ModelsCategoriesActivity extends Activity {
    private static String[] Year;
    private static String[] Brand;
    private static String[] Model;
    private static int[] Images;
    private Cursor cursor;
    public static final String EXTRA_BRANDNO = "brandNo";
    private static int brandno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_models_categories);
        RecyclerView modelsRecycler = (RecyclerView)findViewById(R.id.newcars_model_recycler);
        brandno = (Integer)getIntent().getExtras().get(CAR_MODEL);

        try {
            SQLiteOpenHelper carsdb = new CarsDatabaseHelper(this);
            SQLiteDatabase db = carsdb.getReadableDatabase();
            switch (brandno){
                case 0: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Alfa Romeo"}, null, null, null);
                    break;
                case 1: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Aston Martin"}, null, null, null);
                    break;
                case 2: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Audi"}, null, null, null);
                    break;
                case 3: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Bentley"}, null, null, null);
                    break;
                case 4: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"BMW"}, null, null, null);
                    break;
                case 5: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Bugatti"}, null, null, null);
                    break;
                case 6: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Cadillac"}, null, null, null);
                    break;
                case 7: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Chevrolet"}, null, null, null);
                    break;
                case 8: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Dodge"}, null, null, null);
                    break;
                case 9: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Ferrari"}, null, null, null);
                    break;
                case 10: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Ford"}, null, null, null);
                    break;
                case 11: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Honda"}, null, null, null);
                    break;
                case 12: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Jaguar"}, null, null, null);
                    break;
                case 13: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Koenigsegg"}, null, null, null);
                    break;
                case 14: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Lamborghini"}, null, null, null);
                    break;
                case 15: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Maserati"}, null, null, null);
                    break;
                case 16: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Mercedes - Maybach"}, null, null, null);
                    break;
                case 17: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"McLaren"}, null, null, null);
                    break;
                case 18: cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "SIDE_IMAGE"},"BRAND = ?", new String[]{"Mercedes - Benz"}, null, null, null);
            }


            Year = new String[cursor.getCount()];
            Model = new String[cursor.getCount()];
            Brand = new String[cursor.getCount()];
            Images = new int[cursor.getCount()];
            cursor.moveToFirst();
            for (int i = 0; i < Year.length; i++) {
                Year[i] = cursor.getString(cursor.getColumnIndex("YEAR"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < Brand.length; i++) {
                Brand[i] = cursor.getString(cursor.getColumnIndex("BRAND"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < Model.length; i++) {
                Model[i] = cursor.getString(cursor.getColumnIndex("MODEL"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < Images.length; i++) {
                Images[i] = cursor.getInt(cursor.getColumnIndex("SIDE_IMAGE"));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();

        } catch (SQLiteException e) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }

        CaptionedImagesAdapter1column adapter2 = new CaptionedImagesAdapter1column(Year, Brand,  Model, Images);
        modelsRecycler.setAdapter(adapter2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        modelsRecycler.setLayoutManager(layoutManager);

        adapter2.setListener(new CaptionedImagesAdapter1column.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(ModelsCategoriesActivity.this, NewCarsDetailActivity.class);
                intent.putExtra(NewCarsDetailActivity.MODEL, brandno);
                startActivity(intent);
            }
        });
    }
}
