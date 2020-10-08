package com.katishev.anotherunnecessarystore.ui.weaponInfo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.katishev.anotherunnecessarystore.R;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


class FragmentScrollWeapon extends Fragment {
    InputStream inputStream;
    TextView infoScrollWeapon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        infoScrollWeapon = getView().findViewById(R.id.tv_scroll_info_weapon);
        try(Scanner scanner =new Scanner(inputStream).useDelimiter("")){
          infoScrollWeapon.setText( scanner.hasNext() ? scanner.next() : ""); }
        try {
         inputStream = getActivity().getAssets().open("info_weapon.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scroll_weapon, container, false);
    }
}