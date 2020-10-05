package com.katishev.anotherunnecessarystore.ui.galletyGround;

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

public class GalleryGroundFragment extends Fragment {

    @NotNull
    private RecyclerView galleryGround;
    @NotNull
    private ItemAdapter itemAdapter;
    private View noInternetTv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery_ground, container, false);
        galleryGround = view.findViewById(R.id.rv_fr_ground);
        galleryGround.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemAdapter = new ItemAdapter();
        noInternetTv = view.findViewById(R.id.tv_no_internet);
        galleryGround.setAdapter(itemAdapter);

        return view;
    }

    private void showData(boolean show) {
        if (show) {
            noInternetTv.setVisibility(View.INVISIBLE);
            galleryGround.setVisibility(View.VISIBLE);
        } else {
            noInternetTv.setVisibility(View.VISIBLE);
            galleryGround.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        showData(false);

        NetworkUtils.QueryTaskGround task = new NetworkUtils.QueryTaskGround();
        task.setListener(new NetworkUtils.QueryTaskGround.onLoadComplete() {
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

