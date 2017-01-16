package com.example.root.supercars;


import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Best extends Fragment {
    private static String[] Titles;
    private static int[] Images;
    private Cursor cursor;


    public Best() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView bestRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_best, container, false);

        try {
            SQLiteOpenHelper carsdb = new CarsDatabaseHelper(getActivity());
            SQLiteDatabase db = carsdb.getReadableDatabase();
            cursor = db.rawQuery("SELECT * FROM CARS", null);

            Titles = new String[cursor.getCount()];
            Images = new int[cursor.getCount()];
            cursor.moveToFirst();
            for (int i = 0; i < Titles.length; i++) {
                Titles[i] = cursor.getString(cursor.getColumnIndex("NAME"));
                cursor.moveToNext();
            }
            cursor.moveToFirst();
            for (int i = 0; i < Images.length; i++) {
                Images[i] = cursor.getInt(cursor.getColumnIndex("ANIMAL_IMAGE"));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();

        } catch (SQLiteException e) {
            Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT).show();
        }



        CaptionedImagesAdapter1column adapter = new CaptionedImagesAdapter1column(Titles, Images);
        bestRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        bestRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter1column.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), BestDetailActivity.class);
                intent.putExtra(BestDetailActivity.EXTRA_CARNO, position);
                getActivity().startActivity(intent);
            }
        });

        return bestRecycler;

    }
}

