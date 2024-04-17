package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.models.User;
import com.example.myapplication.repositories.UserRepositorie;
import com.example.myapplication.services.UserServices;

import org.json.JSONException;
import org.json.JSONObject;

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
        String url = "https://jsonplaceholder.typicode.com/users/2";
        String url2 = "https://jsonplaceholder.typicode.com/users";

        JsonArrayRequest jarrRequest = new JsonArrayRequest(Request.Method.GET, url2, null, new Response.Listener<org.json.JSONArray>() {
            @Override
            public void onResponse(org.json.JSONArray response) {
                UserRepositorie repo = UserRepositorie.getInstance();

                TextView tv = findViewById(R.id.textoCentral3);
                String nomes = "";
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        User user = UserServices.createUserFromJson(obj);
                        if (user != null) {
                            repo.addUser(user);
                            // nomes += user.getName() + "\n";
                            // nomes += obj.getString("name") + " \n";
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
               for (User u : repo.getAllUsers() ) {
                   nomes += u.getName() + "\n";
                }

                tv.setText(nomes);
            }
        },
        new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    TextView tv = findViewById(R.id.textoCentral3);
                    tv.setText("Nao funcionou2");
                }

            });

            queue.add(jarrRequest);


        /*JsonObjectRequest jasonRequest = new JsonObjectRequest(Request.Method.GET,url, null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                TextView tv = findViewById(R.id.textoCentral3);*/





      /*  JsonObjectRequest jasonRequest = new JsonObjectRequest(Request.Method.GET,url, null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                TextView tv = findViewById(R.id.textoCentral3);
                try {
                    tv.setText(response.getString("name"));
                } catch (JSONException e){
                    tv.setText("Erro"+e.getMessage());
                }

            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                TextView tv = findViewById(R.id.textoCentral3);
                tv.setText("Nao funcionou!" +error.getMessage());
            }
        });

        queue.add(jasonRequest);

        /*


        /* Request a string response from the provided URL.
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

         */
    }




}