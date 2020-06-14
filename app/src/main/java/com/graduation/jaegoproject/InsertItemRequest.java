package com.graduation.jaegoproject;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class InsertItemRequest extends StringRequest {
    final static private String URL= "http://192.168.0.9:80/insertItem.php";
    final static String p_no = "null";
    private Map<String, String> parameters;
    public InsertItemRequest(String p_code,String p_name,String u_id,String p_category,String p_size,String p_ea,String s_name, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
;

        parameters = new HashMap<>();
        parameters.put("p_no",p_no);
        parameters.put("u_id",u_id);
        parameters.put("p_code",p_code);
        parameters.put("p_name",p_name);
        parameters.put("p_category",p_category);
        parameters.put("p_size",p_size);
        parameters.put("p_ea",p_ea);
        parameters.put("s_name",s_name);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {

        return  parameters;
    }
}
