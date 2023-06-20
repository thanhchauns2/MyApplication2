package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddSV extends AppCompatActivity {

    EditText ten, namSinh, queQuan, namHoc;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sv);

        DatabaseHelper db = new DatabaseHelper(AddSV.this);

        ten = findViewById(R.id.editTextTextPassword);
        namSinh = findViewById(R.id.editText2);
        queQuan = findViewById(R.id.editText4);
        namHoc = findViewById(R.id.editText4);
        button = findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = ten.getText().toString();
                String n = namSinh.getText().toString();
                String q = queQuan.getText().toString();
                String nh = namHoc.getText().toString();
                db.addSV(t, n, q, nh);
                Intent intent = new Intent(AddSV.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}