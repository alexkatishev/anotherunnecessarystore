package com.katishev.anotherunnecessarystore.ui.galleryShip;


import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.katishev.anotherunnecessarystore.R;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import static com.katishev.anotherunnecessarystore.NetworkUtils.generateURL;
import static com.katishev.anotherunnecessarystore.NetworkUtils.getResponseFromURL;

public class GalleryShipFragment extends Fragment {
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    private RecyclerViewAdapter mAdapter;
    private RecyclerView galleryShip;
    private String mParam2;
    private String mParam1;

    class QueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            String response = null;
            try {
                response = getResponseFromURL(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    public GalleryShipFragment() {
    }

    public static GalleryShipFragment newInstance(String param1, String param2) {

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


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery_ship, container, false);
        galleryShip = view.findViewById(R.id.lv_fr_ship);
        galleryShip.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new RecyclerViewAdapter(galleryShip);
        galleryShip.setAdapter(mAdapter);
        mAdapter.addItem("Initial item", 0);

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



