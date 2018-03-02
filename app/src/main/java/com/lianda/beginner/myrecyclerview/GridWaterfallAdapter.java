package com.lianda.beginner.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 19/10/2017.
 */

public class GridWaterfallAdapter extends RecyclerView.Adapter<GridWaterfallAdapter.GridViewHolder> {

    private Context context;
    private ArrayList<Waterfall>listWaterfall;

    public ArrayList<Waterfall>getListWaterfall(){
        return listWaterfall;
    }

    public void setListWaterfall(ArrayList<Waterfall> listWaterfall){
        this.listWaterfall = listWaterfall;
    }

    public GridWaterfallAdapter(Context context){
        this.context = context;
    }

    @Override
    public GridWaterfallAdapter.GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_waterfall, parent, false);

        GridViewHolder gridViewHolder = new GridViewHolder(view);
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(GridWaterfallAdapter.GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListWaterfall().get(position).getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListWaterfall().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        public GridViewHolder (View itemView){
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
        }
    }
}
