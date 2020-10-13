package com.katishev.anotherunnecessarystore.ui.fitInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.katishev.anotherunnecessarystore.R;

class FragmentScrollFit extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

           View view = inflater.inflate(R.layout.fragment_scroll_fit, container, false);
            return  view;

    }
}