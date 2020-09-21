package com.katishev.anotherunnecessarystore.ui.galleryShip;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.katishev.anotherunnecessarystore.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import static com.katishev.anotherunnecessarystore.ui.galleryShip.NetworkUtils.generateAllURL;
import static com.katishev.anotherunnecessarystore.ui.galleryShip.NetworkUtils.generateURL;
import static com.katishev.anotherunnecessarystore.ui.galleryShip.NetworkUtils.getResponseFromURL;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    public static class DataItem {
        String className = null;
        String name = null;
        String description = null;
        String uriWhereImage = null;
    }

    private List<ItemAdapter.DataItem> mData = new LinkedList<>();

// методы адаптера

    public void setData(List<DataItem> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);

             ItemViewHolder viewHolder = new ItemViewHolder(view);
        viewHolder.tv_info_item.setText("viewHolder index");

        return viewHolder;

    } //создаем новые элементы списка View Holder

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(position);
    } // меняем значения в элементах списка View Holder

    @Override
    public int getItemCount() {
        return mData.size();
    }//


    // View Holder - один элемент списка
    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title_item;
        ImageView iv_item;
        TextView tv_price_item;
        TextView tv_info_item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_info_item = itemView.findViewById(R.id.tv_info_item);
            tv_title_item = itemView.findViewById(R.id.tv_title_item);
            iv_item = itemView.findViewById(R.id.iv_item);
            tv_price_item = itemView.findViewById(R.id.tv_price_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        void bind(int listIndex) {
            tv_title_item.setText(mData.get(listIndex).name);
        }

    }

}
