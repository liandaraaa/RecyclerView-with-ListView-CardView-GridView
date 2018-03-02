package com.lianda.beginner.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL;

/**
 * Created by lenovo on 19/10/2017.
 */

public class ListWaterfallAdapter extends RecyclerView.Adapter<ListWaterfallAdapter.CategoryViewHolder> {

    private Context context;
    public ArrayList<Waterfall> getListWaterfall (){
        return listWaterfall;
    }
    public void setListWaterfall(ArrayList<Waterfall> listWaterfall)
    {
        this.listWaterfall = listWaterfall;
    }
    private ArrayList<Waterfall> listWaterfall;
    public ListWaterfallAdapter (Context context) {
        this.context = context;
    }

    @Override
    public ListWaterfallAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_waterfall, parent, false);
        return new CategoryViewHolder (itemRow);
    }

    @Override
    public void onBindViewHolder(ListWaterfallAdapter.CategoryViewHolder holder, int position) {
       holder.tvName.setText(getListWaterfall().get(position).getName());
        holder.tvPrice.setText(getListWaterfall().get(position).getPrice());

        Glide.with(context)
                .load(getListWaterfall().get(position).getPhoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListWaterfall().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvPrice;
        ImageView imgPhoto;

        public CategoryViewHolder(View itemView){
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvPrice = (TextView)itemView.findViewById(R.id.tv_item_price);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
        }
    }
}
