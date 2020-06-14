package com.graduation.jaegoproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Joinpage extends AppCompatActivity {
    Button submit;
    EditText join_uId, join_uPwd, join_uName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joinpage);
        submit = findViewById(R.id.join_submit);
        join_uId = findViewById(R.id.join_id);
        join_uPwd = findViewById(R.id.join_password);
        join_uName = findViewById(R.id.join_name);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String u_id = join_uId.getText().toString();
                final String u_pwd = join_uPwd.getText().toString();
                final String u_name = join_uName.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");

                            // 서버에서 true(success) 를 보낼 경우
                            if (success) {
                                finish();
                            } else {

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                JoinRequest joinRequest = new JoinRequest(u_id, u_pwd,u_name, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Joinpage.this);
                queue.add(joinRequest);


            }
        });

    }
}