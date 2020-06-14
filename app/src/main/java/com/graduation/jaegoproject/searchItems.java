package com.graduation.jaegoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class searchItems extends AppCompatActivity {
    EditText itemList_edt;
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
        itemList.add(new Products("나이키후드티","558483","의류","3층창고","30"));
        itemList.add(new Products("나이키후드티","558483","의류","3층창고","30"));
        itemList.add(new Products("나이키후드티","558483","의류","3층창고","30"));
        itemList.add(new Products("나이키후드티","558483","의류","3층창고","30"));
        itemList.add(new Products("나이키후드티","558483","의류","3층창고","30"));
        itemList.add(new Products("나이키후드티","558483","의류","3층창고","30"));
        itemList.add(new Products("나이키후드티","558483","의류","3층창고","30"));
        itemList.add(new Products("나이키후드티","558483","의류","3층창고","30"));
        itemList.add(new Products("나이키후드티","558483","의류","3층창고","30"));
        adapter = new ItemListAdapter(getApplicationContext(),itemList);
        search_items_itemListView.setAdapter(adapter);


    }
}
