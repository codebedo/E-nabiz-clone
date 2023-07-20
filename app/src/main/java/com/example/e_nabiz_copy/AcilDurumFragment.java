package com.example.e_nabiz_copy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class AcilDurumFragment extends Fragment {

    public AcilDurumFragment() {

    }

    public static AcilDurumFragment newInstance() {
        return new AcilDurumFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_acil_durum, container, false);
    }


}
