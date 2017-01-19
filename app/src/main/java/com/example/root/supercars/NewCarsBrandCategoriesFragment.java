package com.example.root.supercars;


import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewCarsBrandCategoriesFragment extends Fragment {
    private static String[] Brands;
    private static int[] Logos;
    private static Cursor cursor;
    private static SQLiteDatabase db;
    private static RecyclerView newcars_recycler;
    private static CaptionedImagesAdapter adapter;



    public NewCarsBrandCategoriesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        newcars_recycler = (RecyclerView) inflater.inflate(R.layout.fragment_new_cars, container, false);


        try {
            SQLiteOpenHelper carsdb = new CarsDatabaseHelper(getActivity());
            db = carsdb.getReadableDatabase();
            cursor = db.query("NEWCARS", new String[]{"LOGO", "BRAND"},"LEXIST = ?", new String[]{"l"}, null, null, null);

            Brands = new String[cursor.getCount()];
            Logos = new int[cursor.getCount()];
            cursor.moveToFirst();
            for (int i = 0; i < Brands.length; i++) {
                Brands[i] = cursor.getString(cursor.getColumnIndex("BRAND"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < Logos.length; i++) {
                Logos[i] = cursor.getInt(cursor.getColumnIndex("LOGO"));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();

        } catch (SQLiteException e) {
            Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT).show();
        }
        adapter = new CaptionedImagesAdapter(Brands, Logos);
        newcars_recycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        newcars_recycler.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), ModelsCategoriesActivity.class);
                intent.putExtra(NewCarsDetailActivity.CAR_MODEL, position);
                getActivity().startActivity(intent);
            }
        });

        return newcars_recycler;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_new_cars, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.cars:
                Intent intent = new Intent(getActivity(), AllNewCarsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    private class UpdateBrandsTask extends AsyncTask<Void, Void, Void> {
//
//        protected void onPreExecute(){
//            ProgressDialog progDailog = new ProgressDialog(getActivity());
//            progDailog.setMessage("Loading...");
//            progDailog.setIndeterminate(false);
//            progDailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            progDailog.setCancelable(true);
//            progDailog.show();
//
//        }
//        protected Void doInBackground (Void... params){
//            getData();
//            return null;
//
//
//        }
//
//        protected void onPostExecute(Boolean succes){
//            if(!succes){
//                Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT).show();
//            }
//        }

//    }
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }

//    public void getData(){
//        try {
//
//            SQLiteOpenHelper carsdb = new CarsDatabaseHelper(getActivity().getApplicationContext());
//            db = carsdb.getReadableDatabase();
//            cursor = db.query("NEWCARS", new String[]{"LOGO", "BRAND"},"LEXIST = ?", new String[]{"l"}, null, null, null);
//            Brands = new String[cursor.getCount()];
//            Logos = new int[cursor.getCount()];
//            cursor.moveToFirst();
//            for (int i = 0; i < Brands.length; i++) {
//                Brands[i] = cursor.getString(cursor.getColumnIndex("BRAND"));
//                cursor.moveToNext();
//            }
//            cursor.moveToFirst();
//            for (int i = 0; i < Logos.length; i++) {
//                Logos[i] = cursor.getInt(cursor.getColumnIndex("LOGO"));
//                cursor.moveToNext();
//
//            }
//            adapter = new CaptionedImagesAdapter(Brands, Logos);
//            newcars_recycler.setAdapter(adapter);
//        } catch (SQLiteException e) {
//            Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT).show();
////        }finally {
////            if (cursor != null){
////                cursor.close();
////                db.close();
////            }
//
//        }
//
//    }
}

