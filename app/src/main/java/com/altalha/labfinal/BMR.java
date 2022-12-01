package com.altalha.labfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BMR extends Fragment {

    Button check_Btn;
    RadioGroup rG;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View containerView = inflater.inflate(R.layout.fragment_b_m_r, container, false);

        check_Btn = containerView.findViewById(R.id.check_btn);
        rG = containerView.findViewById(R.id.radio_group_id);

        check_Btn.setOnClickListener(v -> {
            if (rG.getCheckedRadioButtonId() != -1) {
                RadioButton rb = containerView.findViewById(rG.getCheckedRadioButtonId());
                String msg = rb.getText().toString();

                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getContext(), "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return containerView;
    }
}