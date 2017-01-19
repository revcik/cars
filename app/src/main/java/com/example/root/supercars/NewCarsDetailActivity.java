package com.example.root.supercars;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NewCarsDetailActivity extends Activity {
    public static final String CAR_MODEL = "carModel";
    public static final String MODEL = "Model";
    private static String Year;
    private static String Brand;
    private static String Model;
    private static int CarImage;
    private static String Engine;
    private static String EngineAds;
    private static String Weight;
    private static String Bhp;
    private static String Accel;
    private static String Speed;
    private static String Price;
    private static String Description;
    public static int a;
    public static int b;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cars_detail);

        try {
            if(a == 1){
                String mdl = (String)getIntent().getExtras().get(CAR_MODEL);
                alreadyslctdcar(mdl);
            }
            if(b == 1) {
                int brandmodel = (Integer) getIntent().getExtras().get(MODEL);
                switch (brandmodel) {
                    case 0:
                        selectcar("Alfa Romeo");
                        break;
                    case 1:
                        selectcar("Aston Martin");
                        break;
                    case 2:
                        selectcar("Audi");
                        break;
                    case 3:
                        selectcar("Bentley");
                        break;
                    case 4:
                        selectcar("BMW");
                        break;
                    case 5:
                        selectcar("Bugatti");
                        break;
                    case 6:
                        selectcar("Cadillac");
                        break;
                    case 7:
                        selectcar("Chevrolet");
                        break;
                    case 8:
                        selectcar("Dodge");
                        break;
                    case 9:
                        selectcar("Ferrari");
                        break;
                    case 10:
                        selectcar("Ford");
                        break;
                    case 11:
                        selectcar("Honda");
                        break;
                    case 12:
                        selectcar("Jaguar");
                        break;
                    case 13:
                        selectcar("Koenigsegg");
                        break;
                    case 14:
                        selectcar("Lamborghini");
                        break;
                    case 15:
                        selectcar("Maserati");
                        break;
                    case 16:
                        selectcar("Porsche");
                        break;
                    case 17:
                        selectcar("McLaren");
                        break;
                    case 18:
                        selectcar("Mercedes - Benz");
                        break;
                }
            }
            TextView year = (TextView) findViewById(R.id.year);
            year.setText(Year);
            TextView brand = (TextView)findViewById(R.id.car_brand);
            brand.setText(Brand);
            TextView model = (TextView)findViewById(R.id.car_model);
            model.setText(Model);
            ImageView carimage = (ImageView)findViewById(R.id.car_image);
            carimage.setImageDrawable(getResources().getDrawable(CarImage));
            TextView engine = (TextView)findViewById(R.id.engine2);
            TextView engineAds = (TextView)findViewById(R.id.engine2ads);
            TextView weight = (TextView)findViewById(R.id.weight2);
            TextView bhp = (TextView)findViewById(R.id.bhp2);
            TextView accel = (TextView)findViewById(R.id.accel2);
            TextView speed = (TextView)findViewById(R.id.speed2);
            TextView price = (TextView)findViewById(R.id.price2);
            engine.setText(Engine);
            engineAds.setText(EngineAds);
            weight.setText(Weight + " кг");
            bhp.setText(Bhp + " л.с.");
            accel.setText(Accel + " сек.");
            speed.setText(Speed + " км/ч");
            price.setText(Price + " $");
            TextView descr = (TextView)findViewById(R.id.description);
            descr.setText(Description);


        } catch (SQLiteException e) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }

    }

    public void selectcar(String brand){
        SQLiteOpenHelper carsdb = new CarsDatabaseHelper(this);
        SQLiteDatabase db = carsdb.getReadableDatabase();
        Cursor cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "CAR_IMAGE", "ENGINE", "ENGINE_ADS", "WEIGHT", "BHP", "ACCEL", "SPEED", "PRICE", "DESCRIPTION"},"BRAND = ?", new String[]{brand}, null, null, null);
        cursor.moveToFirst();
        Year = cursor.getString(cursor.getColumnIndex("YEAR"));
        Brand = cursor.getString(cursor.getColumnIndex("BRAND"));
        Model = cursor.getString(cursor.getColumnIndex("MODEL"));
        CarImage = cursor.getInt(cursor.getColumnIndex("CAR_IMAGE"));
        Engine = cursor.getString(cursor.getColumnIndex("ENGINE"));
        EngineAds = cursor.getString(cursor.getColumnIndex("ENGINE_ADS"));
        Weight = cursor.getString(cursor.getColumnIndex("WEIGHT"));
        Bhp = cursor.getString(cursor.getColumnIndex("BHP"));
        Accel = cursor.getString(cursor.getColumnIndex("ACCEL"));
        Speed = cursor.getString(cursor.getColumnIndex("SPEED"));
        Price = cursor.getString(cursor.getColumnIndex("PRICE"));
        Description = cursor.getString(cursor.getColumnIndex("DESCRIPTION"));
        cursor.close();
        db.close();

    }

    public void alreadyslctdcar(String model){
        SQLiteOpenHelper carsdb = new CarsDatabaseHelper(this);
        SQLiteDatabase db = carsdb.getReadableDatabase();
        Cursor cursor = db.query("NEWCARS", new String[]{"YEAR", "BRAND", "MODEL", "CAR_IMAGE", "ENGINE", "ENGINE_ADS", "WEIGHT", "BHP", "ACCEL", "SPEED", "PRICE", "DESCRIPTION"},"MODEL = ?", new String[]{model}, null, null, null);
        cursor.moveToFirst();
        Year = cursor.getString(cursor.getColumnIndex("YEAR"));
        Brand = cursor.getString(cursor.getColumnIndex("BRAND"));
        Model = cursor.getString(cursor.getColumnIndex("MODEL"));
        CarImage = cursor.getInt(cursor.getColumnIndex("CAR_IMAGE"));
        Engine = cursor.getString(cursor.getColumnIndex("ENGINE"));
        EngineAds = cursor.getString(cursor.getColumnIndex("ENGINE_ADS"));
        Weight = cursor.getString(cursor.getColumnIndex("WEIGHT"));
        Bhp = cursor.getString(cursor.getColumnIndex("BHP"));
        Accel = cursor.getString(cursor.getColumnIndex("ACCEL"));
        Speed = cursor.getString(cursor.getColumnIndex("SPEED"));
        Price = cursor.getString(cursor.getColumnIndex("PRICE"));
        Description = cursor.getString(cursor.getColumnIndex("DESCRIPTION"));
        cursor.close();
        db.close();

    }

    public void onDestroy(){
        super.onDestroy();
        a = 0;
        b =0;
    }
}
