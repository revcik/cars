package com.example.root.supercars;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class AllNewCarsListAdapter extends CursorAdapter {
    public AllNewCarsListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_view_fragment, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView blankBrand = (TextView) view.findViewById(R.id.brand);
        TextView blankModel = (TextView) view.findViewById(R.id.model);

        // Extract properties from cursor
        String brand = cursor.getString(cursor.getColumnIndexOrThrow("BRAND"));
        String model = cursor.getString(cursor.getColumnIndexOrThrow("MODEL"));
        AllNewCarsActivity ac = new AllNewCarsActivity();

        if(ac.isSortAttrSelected){
            TextView mattr = (TextView)view.findViewById(R.id.attr);
            String attr = cursor.getString(cursor.getColumnIndex(ac.sortAttr));
            mattr.setText(attr);

        }

        // Populate fields with extracted properties
        blankBrand.setText(brand);
        blankModel.setText(model);


    }


}
