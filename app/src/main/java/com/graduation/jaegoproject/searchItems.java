package com.graduation.jaegoproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class searchItems extends AppCompatActivity {
    EditText itemList_edt;
    ImageButton search_items_barcodeScan_btn;
    private ListView search_items_itemListView;
    private ItemListAdapter adapter;
    private List<Products> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_items);

        itemList_edt = findViewById(R.id.itemList_edt);
        Intent intent = getIntent();

        String searchCode = intent.getExtras().getString("searchCode");
        itemList_edt.setText(searchCode);

        search_items_itemListView = findViewById(R.id.search_items_itemListView);
        itemList = new ArrayList<Products>();
        itemList.add(new Products("나이키후드티","558483","의류","S","3층창고","30"));
        itemList.add(new Products("나이키후드티2","558484","의류2","M","3층창고","31"));
        itemList.add(new Products("나이키후드티3","558485","의류3","L","3층창고","32"));
        itemList.add(new Products("나이키후드티4","558486","의류4","XL","3층창고","33"));
        itemList.add(new Products("나이키후드티5","558487","의류5","2XL","3층창고","34"));
        itemList.add(new Products("나이키후드티6","558488","의류6","3XL","3층창고","35"));
        itemList.add(new Products("나이키후드티7","558489","의류7","4XL","3층창고","36"));
        itemList.add(new Products("나이키후드티8","558490","의류8","5XL","3층창고","37"));
        itemList.add(new Products("나이키후드티9","558491","의류9","6XL","3층창고","38"));
        adapter = new ItemListAdapter(getApplicationContext(),itemList);
        search_items_itemListView.setAdapter(adapter);

        search_items_itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),itemInformation.class);
                intent.putExtra("p_name",itemList.get(position).getP_name());
                intent.putExtra("p_code",itemList.get(position).getP_code());
                intent.putExtra("p_category",itemList.get(position).getP_category());
                intent.putExtra("p_size",itemList.get(position).getP_size());
                intent.putExtra("s_name",itemList.get(position).getS_name());
                intent.putExtra("p_ea",itemList.get(position).getP_ea());
                startActivity(intent);
            }
        });
    }
}
