package com.katishev.anotherunnecessarystore.ui.galleryShip;


import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.katishev.anotherunnecessarystore.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import static com.katishev.anotherunnecessarystore.ui.galleryShip.NetworkUtils.getResponseFromURL;

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
        itemAdapter =new ItemAdapter (82);
        galleryShip.setAdapter(itemAdapter);


        return view;
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



