package com.altalha.labfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class OMG extends AppCompatActivity {

    RadioButton btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omg);

        btn1 = findViewById(R.id.radio_btn_1);
        btn2 = findViewById(R.id.radio_btn_2);

        btn1.setOnClickListener(v -> {
            transaction(new BMI());
        });

        btn2.setOnClickListener(v -> {
            transaction(new BMR());
        });
    }

    public void listGo(View view) {
        Intent myIntent = new Intent(this, ListViewActivity.class);
        startActivity(myIntent);
    }

    private void transaction(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container_id, fragment);
        ft.commit();
    }
}