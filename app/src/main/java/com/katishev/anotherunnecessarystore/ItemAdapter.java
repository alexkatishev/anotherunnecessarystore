package com.katishev.anotherunnecessarystore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    public static class DataItem {

        String className = null;
        String name = null;
        String description = null;
        String price = null;
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


        return viewHolder;

    } //создаем новые элементы списка View Holder

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(position);
        ImageView imageView = holder.iv_item;

        Picasso.get()
                .load(mData.get(position).uriWhereImage)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(imageView);


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
        TextView tv_class_item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_info_item = itemView.findViewById(R.id.tv_info_item);
            tv_title_item = itemView.findViewById(R.id.tv_title_item);
            iv_item = itemView.findViewById(R.id.iv_item);
            tv_price_item = itemView.findViewById(R.id.tv_price_item);
            tv_class_item = itemView.findViewById(R.id.tv_class_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        void bind(int listIndex) {
            tv_title_item.setText(mData.get(listIndex).name);
            tv_price_item.setText(mData.get(listIndex).price);
            tv_class_item.setText(mData.get(listIndex).className);
            tv_info_item.setText(mData.get(listIndex).description);

        }
    }

}

