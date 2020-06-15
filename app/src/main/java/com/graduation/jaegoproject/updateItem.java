package com.graduation.jaegoproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class updateItem extends AppCompatActivity {
    Button updateItem_insertBtn;
    EditText updateItem_pcodeEdt,updateItem_pnameEdt,updateItem_pcategoryEdt,updateItem_psizeEdt,updateItem_peaEdt,updateitem_sNameSpin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);

        updateItem_insertBtn = findViewById(R.id.updateItem_insertBtn);
        updateItem_pcodeEdt = findViewById(R.id.updateItem_pcodeEdt);
        updateItem_pnameEdt = findViewById(R.id.updateItem_pnameEdt);
        updateItem_pcategoryEdt = findViewById(R.id.updateItem_pcategoryEdt);
        updateItem_psizeEdt = findViewById(R.id.updateItem_psizeEdt);
        updateItem_peaEdt = findViewById(R.id.updateItem_peaEdt);
        updateitem_sNameSpin = findViewById(R.id.updateitem_sNameSpin);

        Intent intent = getIntent();
        String p_code = intent.getExtras().getString("p_code");
        String p_name = intent.getExtras().getString("p_name");
        String p_category = intent.getExtras().getString("p_category");
        String p_size = intent.getExtras().getString("p_size");
        String p_ea = intent.getExtras().getString("p_ea");
        String s_name = intent.getExtras().getString("s_name");

        //받은 값을 각 TextView에 setText하여 보여줍니다.
        updateItem_pcodeEdt.setText(p_code);
        updateItem_pnameEdt.setText(p_name);
        updateItem_pcategoryEdt.setText(p_category);
        updateItem_psizeEdt.setText(p_size);
        updateItem_peaEdt.setText(p_ea);
        updateitem_sNameSpin.setText(s_name);

        updateItem_insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(updateItem.this);
                builder.setMessage("등록완료")
                        .setNegativeButton("확인", null)
                        .create()
                        .show();


            }
        });
    }
}
