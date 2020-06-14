package com.graduation.jaegoproject;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class insertItems extends AppCompatActivity {
    EditText insertItem_pcodeEdt,insertItem_pnameEdt,insertItem_pcategoryEdt,insertItem_psizeEdt,insertItem_peaEdt;
    EditText insertItem_sNameSpin;
    Button insertItem_insertBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_items);
        insertItem_insertBtn = findViewById(R.id.insertItem_insertBtn);
        insertItem_pnameEdt = findViewById(R.id.insertItem_pnameEdt);
        insertItem_pcategoryEdt = findViewById(R.id.insertItem_pcategoryEdt);
        insertItem_psizeEdt = findViewById(R.id.insertItem_psizeEdt);
        insertItem_peaEdt = findViewById(R.id.insertItem_peaEdt);
        insertItem_sNameSpin = findViewById(R.id.insertItem_sNameSpin);

        insertItem_pcodeEdt = findViewById(R.id.insertItem_pcodeEdt);
        final Intent intent = getIntent();
        String searchCode = intent.getExtras().getString("searchCode");
        insertItem_pcodeEdt.setText(searchCode);

        insertItem_insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String u_id = "tare";
                final String p_code = insertItem_pcodeEdt.getText().toString();
                final String p_name = insertItem_pnameEdt.getText().toString();
                final String p_category = insertItem_pcategoryEdt.getText().toString();
                final String p_size = insertItem_pcategoryEdt.getText().toString();
                final String p_ea = insertItem_peaEdt.getText().toString();
                final String s_name =insertItem_sNameSpin.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");
                            // 서버에서 true(success) 를 보낼 경우
                            if (success == true) {
                                Log.i("success 값은?", String.valueOf(success));
                                Intent intent = new Intent(insertItems.this, Main2Activity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            } else {
                                Log.i("success 값은?", String.valueOf(success));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                InsertItemRequest insertItemRequest = new InsertItemRequest(p_code,p_name,u_id,p_category,p_size,p_ea,s_name, responseListener);
                RequestQueue queue = Volley.newRequestQueue(insertItems.this);
                queue.add(insertItemRequest);
            }
        });
    }
}