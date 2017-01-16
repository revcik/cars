package com.example.root.supercars;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CaptionedImagesAdapter1column extends RecyclerView.Adapter<CaptionedImagesAdapter1column.ViewHolder>{

private String[] captions;
private int[] imageIds;
private Listener listener;



public static interface Listener {
    public void onClick(int position);
}

    public CaptionedImagesAdapter1column(String[] captions, int[] imageIds){
        this.captions=captions;
        this.imageIds=imageIds;
    }

public static class ViewHolder extends RecyclerView.ViewHolder{
    private CardView cardView;
    public ViewHolder(CardView v){
        super(v);
        cardView = v;
    }

}

    public CaptionedImagesAdapter1column.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_2,parent, false);
        return new CaptionedImagesAdapter1column.ViewHolder(cv);

    }

    public void onBindViewHolder(CaptionedImagesAdapter1column.ViewHolder holder, final int position){
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        Drawable drawable = cardView.getResources().getDrawable(imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);
        cardView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(listener !=null){
                    listener.onClick(position);
                }
            }
        });
    }

    public int getItemCount(){
        return imageIds.length;
    }

    public void setListener (CaptionedImagesAdapter1column.Listener listener){
        this.listener = listener;
    }
}
