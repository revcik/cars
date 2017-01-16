package com.example.root.supercars;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

public class BestDetailActivity extends Activity {

    private ShareActionProvider shareActionPRovider;
    public static final String EXTRA_CARNO = "carNo";
    private static String Titles[];
    private static int CarImages[];
    private static String Description[];
    private static String Engine[];
    private static String Weight[];
    private static String Bhp[];
    private static String Accel[];
    private static String Speed[];
    private static String Price[];
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_detail);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        try {
            SQLiteOpenHelper carsdb = new CarsDatabaseHelper(this);
            SQLiteDatabase db = carsdb.getReadableDatabase();
            cursor = db.rawQuery("SELECT * FROM CARS", null);

            Titles = new String[cursor.getCount()];
            CarImages = new int[cursor.getCount()];
            Engine = new String[cursor.getCount()];
            Weight = new String[cursor.getCount()];
            Bhp = new String[cursor.getCount()];
            Accel = new String[cursor.getCount()];
            Speed = new String[cursor.getCount()];
            Price = new String[cursor.getCount()];
            Description = new String[cursor.getCount()];

            cursor.moveToFirst();
            for (int i = 0; i < Titles.length; i++) {
                Titles[i] = cursor.getString(cursor.getColumnIndex("MODEL"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < CarImages.length; i++) {
                CarImages[i] = cursor.getInt(cursor.getColumnIndex("CAR_IMAGE"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < Engine.length; i++) {
                Engine[i] = cursor.getString(cursor.getColumnIndex("ENGINE"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < Weight.length; i++) {
                Weight[i] = cursor.getString(cursor.getColumnIndex("WEIGHT"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < Bhp.length; i++) {
                Bhp[i] = cursor.getString(cursor.getColumnIndex("BHP"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < Accel.length; i++) {
                Accel[i] = cursor.getString(cursor.getColumnIndex("ACCEL"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < Speed.length; i++) {
                Speed[i] = cursor.getString(cursor.getColumnIndex("SPEED"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < Price.length; i++) {
                Price[i] = cursor.getString(cursor.getColumnIndex("PRICE"));
                cursor.moveToNext();
            }

            cursor.moveToFirst();
            for (int i = 0; i < Description.length; i++) {
                Description[i] = cursor.getString(cursor.getColumnIndex("DESCRIPTION"));
                cursor.moveToNext();
            }

            cursor.close();
            db.close();

        } catch (SQLiteException e) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }

        int carno = (Integer)getIntent().getExtras().get(EXTRA_CARNO);
        String carTitle = Titles[carno];
        TextView textView = (TextView)findViewById(R.id.car_title);
        textView.setText(carTitle);
        int carImage = CarImages[carno];
        ImageView imageView = (ImageView)findViewById(R.id.car_image);
        imageView.setImageDrawable(getResources().getDrawable(carImage));
        imageView.setContentDescription(carTitle);
        String description = Description[carno];
        TextView textView2 = (TextView)findViewById(R.id.description);
        textView2.setText(description);

        TextView engine = (TextView)findViewById(R.id.engine2);
        TextView weight = (TextView)findViewById(R.id.weight2);
        TextView bhp = (TextView)findViewById(R.id.bhp2);
        TextView accel = (TextView)findViewById(R.id.accel2);
        TextView speed = (TextView)findViewById(R.id.speed2);
        TextView price = (TextView)findViewById(R.id.price2);
        String carengine = Engine[carno];
        String carweight = Weight[carno];
        String carbhp = Bhp[carno];
        String caraccel = Accel[carno];
        String carspeed = Speed[carno];
        String carprice = Price[carno];
        engine.setText(carengine);
        weight.setText(carweight);
        bhp.setText(carbhp);
        accel.setText(caraccel);
        speed.setText(carspeed);
        price.setText(carprice);
    }

    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        TextView textView = (TextView)findViewById(R.id.car_title);
        CharSequence pizzaName = textView.getText();
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionPRovider = (ShareActionProvider)menuItem.getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, pizzaName);
        shareActionPRovider.setShareIntent(intent);
        return true;
    }


}
