package com.katishev.anotherunnecessarystore.ui.galleryShip;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.katishev.anotherunnecessarystore.R;

import java.util.LinkedList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    //данные для адаптера
    List<String> mItems = new LinkedList<>();

    public void addItem(String item) {
        mItems.add(item);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.fragment_gallery_ship, parent, false)
                .findViewById(R.id.list_item);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final ViewHolder vh = (ViewHolder) holder;
        vh.tvTitleItem.setText(mItems.get(position));
        vh.tvInfoItem.setText(mItems.get(position));
        vh.ivItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(this.getClass().getSimpleName(),
                        "click" + vh.tvTitleItem.getText().toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivItem;
        ImageView ivProductionItem;
        TextView tvTitleItem;
        ImageView ivPriceItem;
        TextView tvInfoItem;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItem = itemView.findViewById(R.id.iv_item);
            ivProductionItem = itemView.findViewById(R.id.iv_production_item);
            tvTitleItem = itemView.findViewById(R.id.tv_title_item);
            ivPriceItem = itemView.findViewById(R.id.iv_price_item);
            tvInfoItem = itemView.findViewById(R.id.tv_info_item);
        }
    }
}