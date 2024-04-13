package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        TextView tv = findViewById(R.id.textoCentral2);
        tv.setText(intent.getStringExtra("dado"));

        tv.setOnClickListener(v-> {
            LinearLayout ll = findViewById(R.id.layoutVert);
            for (int i=1; i<=10; i++) {
                TextView tv2 = new TextView(this);
                tv2.setText("Linha" + i);
                EditText ed = new EditText(this);
                ed.setHint("Digite algo");

                ll.addView(tv2);
                ll.addView(ed);

            }

        });






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}