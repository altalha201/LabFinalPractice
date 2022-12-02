package com.altalha.labfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    String[] names = {"Talha", "Uday", "Apurbo"};
    ListView lv;
    Boolean show = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv = findViewById(R.id.lv_ID);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_custom_layout, R.id.custom_layout_TV, names);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, names[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void showList(View view) {
        if (show) {
            lv.setVisibility(View.INVISIBLE);
            show = false;
        }
        else {
            lv.setVisibility(View.VISIBLE);
            show = true;
        }
    }
}