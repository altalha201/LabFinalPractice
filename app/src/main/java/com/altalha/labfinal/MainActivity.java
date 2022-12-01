package com.altalha.labfinal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText name_ET, email_ET, date_ET, month_ET, year_ET;
    Spinner gender_SP;
    String[] genderSelector = {"Male", "Female"};
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_ET = findViewById(R.id.name_ET);
        email_ET = findViewById(R.id.email_ET);
        date_ET = findViewById(R.id.date_ET);
        month_ET = findViewById(R.id.month_ET);
        year_ET = findViewById(R.id.year_ET);
        gender_SP = findViewById(R.id.gender_SP);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, genderSelector);
        gender_SP.setAdapter(adapter);
        gender_SP.setOnItemSelectedListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void register(View view) {
        String name = name_ET.getText().toString();
        String email = email_ET.getText().toString();
        String date = date_ET.getText().toString();
        String month = month_ET.getText().toString();
        String year = year_ET.getText().toString();

        if (!name.isEmpty() && !email.isEmpty() && !date.isEmpty() && !month.isEmpty() && !year.isEmpty() && !gender.isEmpty()) {
            String dateOfBirth = date + "/" + month + "/" + year;

            Intent myIntent = new Intent(this, Dashboard.class);
            myIntent.putExtra("name", name);
            myIntent.putExtra("email", email);
            myIntent.putExtra("dob", dateOfBirth);
            startActivity(myIntent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        gender = genderSelector[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}