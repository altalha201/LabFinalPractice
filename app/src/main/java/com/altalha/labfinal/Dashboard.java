package com.altalha.labfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    TextView name_TV, email_TV;
    String name, email, DOB, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        name_TV = findViewById(R.id.name_TV);
        email_TV = findViewById(R.id.email_TV);

        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        DOB = getIntent().getStringExtra("dob");
        gender = getIntent().getStringExtra("gender");

        name_TV.setText(name);
        email_TV.setText(email);

        transaction(new BMI());
    }

    public void changeFrame(View view) {
        if (view.getId() == R.id.bmi_id) {
            transaction(new BMI());
        }
        else if (view.getId() == R.id.bmr_id) {
            transaction(new BMR());
        }
        else {
            transaction(new List());
        }
    }

    private void transaction(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();
    }

    public void listGo(View view) {
        Intent myIntent = new Intent(this, ListView.class);
        startActivity(myIntent);
    }
}