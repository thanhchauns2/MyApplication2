package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DSSV extends AppCompatActivity {

    ListView lv;
    Button back, add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dssv);

        DatabaseHelper db = new DatabaseHelper(DSSV.this);
        lv = (ListView) findViewById(R.id.lv);
        back = findViewById(R.id.button5);
        add = findViewById(R.id.button10);

        ArrayList<SinhVien> ls = db.getSV();

        ArrayList<String> msv = new ArrayList<>();
        for (SinhVien sv : ls){
            msv.add(sv.toString());
        }

        ArrayAdapter ad = new ArrayAdapter<>(
                DSSV.this,
                android.R.layout.simple_list_item_1,
                msv
        );
        lv.setAdapter(ad);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DSSV.this, MainActivity.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DSSV.this, AddSV.class);
                startActivity(intent);
            }
        });
    }
}