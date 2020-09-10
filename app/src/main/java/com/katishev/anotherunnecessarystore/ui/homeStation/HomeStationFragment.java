package com.katishev.anotherunnecessarystore.ui.homeStation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.katishev.anotherunnecessarystore.R;

public class HomeStationFragment extends Fragment {

    private HomeStationViewModel homeStationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeStationViewModel =
                ViewModelProviders.of(this).get(HomeStationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home_station, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeStationViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}