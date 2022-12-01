package com.altalha.labfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BMI extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View containerView = inflater.inflate(R.layout.fragment_b_m_i, container, false);
        // Inflate the layout for this fragment
        return containerView;
    }
}