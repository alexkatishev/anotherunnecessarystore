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

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class GalleryShipFragment extends Fragment {


    @NotNull
    private RecyclerView galleryShip;
    private View noInternetTv;
    @NotNull
    private ItemAdapter itemAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery_ship, container, false);
        galleryShip = view.findViewById(R.id.rv_fr_ship);
        noInternetTv = view.findViewById(R.id.tv_no_internet);
        galleryShip.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemAdapter = new ItemAdapter();
        galleryShip.setAdapter(itemAdapter);


        return view;
    }

    private void showData(boolean show) {
        if (show) {
            noInternetTv.setVisibility(View.INVISIBLE);
            galleryShip.setVisibility(View.VISIBLE);
        } else {
            noInternetTv.setVisibility(View.VISIBLE);
            galleryShip.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        showData(false);

        NetworkUtils.QueryTaskShip task = new NetworkUtils.QueryTaskShip();
        task.setListener(new NetworkUtils.QueryTaskShip.onLoadComplete() {
            @Override
            public void onLoadComplete(@NotNull List<ItemAdapter.DataItem> data) {
                itemAdapter.setData(data);
                showData(true);
            }

            @Override
            public void onLoadFailed() {
                showData(false);
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



