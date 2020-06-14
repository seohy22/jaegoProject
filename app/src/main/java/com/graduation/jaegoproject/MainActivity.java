package com.graduation.jaegoproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {
    Button main_loginBtn, main_joinBtn;
    EditText main_editID, main_editPWD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_loginBtn = findViewById(R.id.main_loginBtn);
        main_joinBtn = findViewById(R.id.main_joinBtn);
        main_editID = findViewById(R.id.main_editID);
        main_editPWD = findViewById(R.id.main_editPWD);
        main_joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Joinpage.class);
                startActivity(intent);
            }
        });
        main_loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String u_id = main_editID.getText().toString();
                final String u_pwd = main_editPWD.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");
                            Log.i("로그인시 받는 success ",String.valueOf(success));

                            if (success) {
                                String u_id = jsonResponse.getString("u_id");
                                String u_pwd = jsonResponse.getString("u_pwd");
                                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                                intent.putExtra("u_id",u_id);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("로그인 실패")
                                        .setNegativeButton("다시시도", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(u_id, u_pwd, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);


            }
        });

    }
}
