package com.katishev.anotherunnecessarystore.ui.homeStation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.katishev.anotherunnecessarystore.R;


public class HomeStationFragment extends Fragment {

LinearLayout myHomeStation;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_station, container, false);
        myHomeStation = view.findViewById(R.id.ll_my_station);

        return view;
}
}