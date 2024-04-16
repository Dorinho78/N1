package com.example.myapplication;

import static android.app.ProgressDialog.show;
import static com.example.myapplication.R.id.btn2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btnOk);


        btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("dado", "Dorinho");
            startActivity(intent);
        });

    findViewById(R.id.btn3).setOnClickListener(view->{
        Toast.makeText(this, "Click Btn3", Toast.LENGTH_LONG).show();


    });




    }





}