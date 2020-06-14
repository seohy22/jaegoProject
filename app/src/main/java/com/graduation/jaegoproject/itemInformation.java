package com.graduation.jaegoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class itemInformation extends AppCompatActivity {
    TextView item_information_pcodeTv,item_information_pnameTv,item_information_pcategoryTv,item_information_psizeTv,
            item_information_peaTv,item_information_snameTv;
    Button item_information_btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_information);

        item_information_pcodeTv = findViewById(R.id.item_information_pcodeTv);
        item_information_pnameTv = findViewById(R.id.item_information_pnameTv);
        item_information_pcategoryTv = findViewById(R.id.item_information_pcategoryTv);
        item_information_psizeTv = findViewById(R.id.item_information_psizeTv);
        item_information_peaTv = findViewById(R.id.item_information_peaTv);
        item_information_snameTv = findViewById(R.id.item_information_snameTv);

        //이전 List에서 보낸 값을 받습니다.
        Intent intent = getIntent();
        String p_code = intent.getExtras().getString("p_code");
        String p_name = intent.getExtras().getString("p_name");
        String p_category = intent.getExtras().getString("p_category");
        String p_size = intent.getExtras().getString("p_size");
        String p_ea = intent.getExtras().getString("p_ea");
        String s_name = intent.getExtras().getString("s_name");

        //받은 값을 각 TextView에 setText하여 보여줍니다.
        item_information_pcodeTv.setText(p_code);
        item_information_pnameTv.setText(p_name);
        item_information_pcategoryTv.setText(p_category);
        item_information_psizeTv.setText(p_size);
        item_information_peaTv.setText(p_ea);
        item_information_snameTv.setText(s_name);


        //btn누를 시 현재 화면을 닫습니다.
        item_information_btnOk = findViewById(R.id.item_information_btnOk);
        item_information_btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
