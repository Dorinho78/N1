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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_second);
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
    }

    @Override
    protected void onStart(){
        super.onStart();
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.guuuogle.com";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        TextView tv = findViewById(R.id.textoCentral3);
                        tv.setText("Response is: " + response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                TextView tv = findViewById(R.id.textoCentral3);
                tv.setText("Nao funcionou!" +error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }




}