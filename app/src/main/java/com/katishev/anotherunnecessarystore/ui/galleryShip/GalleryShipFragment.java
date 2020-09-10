package com.katishev.anotherunnecessarystore.ui.galleryShip;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.katishev.anotherunnecessarystore.R;

public class GalleryShipFragment extends Fragment {
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    private RecyclerView galleryShip;
    private GalleryShipViewModel galleryShipViewModel;
    private String mParam2;
    private String mParam1;

    private final RecyclerViewAdapter mAdapter = new RecyclerViewAdapter();

    public GalleryShipFragment() {

    }

    public static GalleryShipFragment newInstance(String param1,String param2) {


        GalleryShipFragment fragment = new GalleryShipFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_gallery_ship);

        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    private void setContentView(int fragment_gallery_ship) {
    }






    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryShipViewModel =
                ViewModelProviders.of(this).get(GalleryShipViewModel.class);
        View view = inflater.inflate(R.layout.fragment_gallery_ship, container, false);
        galleryShip = view.findViewById(R.id.lv_fr_ship);
        galleryShip.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}



