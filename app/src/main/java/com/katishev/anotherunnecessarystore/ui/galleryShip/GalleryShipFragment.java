package com.katishev.anotherunnecessarystore.ui.galleryShip;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.katishev.anotherunnecessarystore.ItemAdapter;
import com.katishev.anotherunnecessarystore.NetworkUtils;
import com.katishev.anotherunnecessarystore.R;

import java.util.List;


public class GalleryShipFragment extends Fragment {


    private RecyclerView galleryShip;
    private ItemAdapter itemAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery_ship, container, false);
        galleryShip = view.findViewById(R.id.rv_fr_ship);
        galleryShip.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemAdapter = new ItemAdapter();
        galleryShip.setAdapter(itemAdapter);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        NetworkUtils.QueryTask task = new NetworkUtils.QueryTask();
        task.setListener(new NetworkUtils.QueryTask.onLoadComplete() {
            @Override
            public void onLoadComplete(List<ItemAdapter.DataItem> data) {
                itemAdapter.setData(data);
            }
        });
        task.execute();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}



