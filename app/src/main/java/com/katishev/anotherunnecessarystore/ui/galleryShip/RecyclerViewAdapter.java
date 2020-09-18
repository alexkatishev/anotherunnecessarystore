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

    public RecyclerViewAdapter(RecyclerView view) {
        mView = view;
    }
    //данные для адаптера
    List<String> mItems = new LinkedList<>();
    private RecyclerView mView;



    public void addItem(String item, int ind) {
        mItems.add(ind, item);
        notifyItemInserted(ind);
        notifyItemRangeChanged(ind + 1, mItems.size() - (ind + 1));
    }

    public void setItems(List<String> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void removeItem(int ind) {
        mItems.remove(ind);
        notifyItemRemoved(ind);
        notifyItemRangeChanged(ind, mItems.size() - (ind));
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

            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
    private ViewHolder getViewHolderAt(int idx) {
        return ((ViewHolder) mView.findViewHolderForAdapterPosition(idx));
    }

    @Override
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder holder) {
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivItem;
        TextView tvTitleItem;
        ImageView ivPriceItem;
        TextView tvInfoItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItem = itemView.findViewById(R.id.iv_item);
            tvTitleItem = itemView.findViewById(R.id.tv_title_item);
            ivPriceItem = itemView.findViewById(R.id.iv_price_item);
            tvInfoItem = itemView.findViewById(R.id.tv_info_item);
        }
    }
}