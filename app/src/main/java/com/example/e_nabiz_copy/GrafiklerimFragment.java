package com.example.e_nabiz_copy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class GrafiklerimFragment extends Fragment {

    public GrafiklerimFragment() {
        // Required empty public constructor
    }

    public static GrafiklerimFragment newInstance() {
        return new GrafiklerimFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grafiklerim, container, false);
    }


}
