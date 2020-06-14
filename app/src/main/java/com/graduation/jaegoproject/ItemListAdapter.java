package com.graduation.jaegoproject;

//아이템리스트에서 리스트에 어떻게 뿌려줄지 정의하는 클래스

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemListAdapter extends BaseAdapter {
    private Context context;
    private List<Products> itemList;
    public ItemListAdapter(Context context, List<Products> itemList){
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount(){
        return itemList.size(); //리스트뷰의 총 갯수
    }

    @Override
    public Object getItem(int position){
        return itemList.get(position); //해당 위치의 값을 리스트뷰에 뿌려준다
    }

    @Override
    public long getItemId(int position){
        return position;
    }


    //리스트뷰에서 실질적으로 뿌려주는 부분
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        View v = View.inflate(context,R.layout.itemlist,null);
        TextView list_p_nameTv = v.findViewById(R.id.list_p_nameTv);
        TextView list_p_codeTv = v.findViewById(R.id.list_p_codeTv);
        TextView list_p_categoryTv = v.findViewById(R.id.list_p_categoryTv);
        TextView list_p_s_nameTv = v.findViewById(R.id.list_p_s_nameTv);
        TextView list_p_eaTv = v.findViewById(R.id.list_p_eaTv);

        list_p_nameTv.setText(itemList.get(position).getP_name());
        list_p_codeTv.setText((itemList.get(position).getP_code()));
        list_p_categoryTv.setText(itemList.get(position).getP_category());
        list_p_s_nameTv.setText((itemList.get(position).getS_name()));
        list_p_eaTv.setText(itemList.get(position).getP_ea());

        return v;
    }
}
