package com.example.e_nabiz_copy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class GuvenlikFragment extends Fragment {

    public GuvenlikFragment() {
        // Required empty public constructor
    }

    public static GuvenlikFragment newInstance() {
        return new GuvenlikFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guvenlik, container, false);
    }


}
