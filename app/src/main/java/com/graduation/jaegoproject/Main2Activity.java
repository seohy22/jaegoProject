package com.graduation.jaegoproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Main2Activity extends AppCompatActivity {
    private long lastTimeBackPressed;
    LinearLayout searchItem, main2_insertItem,main2_ioItem;
    String pageType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        searchItem = findViewById(R.id.searchItem);
        searchItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentIntegrator(Main2Activity.this).initiateScan();
                pageType ="search";
                /*Intent intent = new Intent(getApplicationContext(),scanner.class);
                startActivity(intent);*/
            }
        });
        main2_insertItem = findViewById(R.id.main2_insertItem);
        main2_insertItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentIntegrator(Main2Activity.this).initiateScan();
                pageType = "insertItem";
            }
        });
        main2_ioItem = findViewById(R.id.main2_ioItem);
        main2_ioItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,storageMap.class);
                startActivity(intent);
            }
        });
    }
    //뒤로가기 2번시 종료 합니다

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTimeBackPressed < 1500){
            finish();
            return;
        }
        Toast.makeText(this, "뒤로 버튼 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String searchCode = result.getContents();
        if(pageType.equals("search")) {
            Intent intent = new Intent(Main2Activity.this, searchItems.class);
            intent.putExtra("searchCode", searchCode);
            startActivity(intent);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } else if(pageType.equals("insertItem")) {
            Intent intent = new Intent(Main2Activity.this, insertItems.class);
            intent.putExtra("searchCode", searchCode);
            startActivity(intent);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
