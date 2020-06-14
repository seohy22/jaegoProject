package com.graduation.jaegoproject;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;
import java.util.HashMap;
import com.android.volley.AuthFailureError;

import java.util.Map;

public class LoginRequest extends StringRequest {
    final static private String URL= "http://192.168.0.9:80/login.php";
    private Map<String, String> parameters;

    public LoginRequest(String u_id,String u_pwd, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();
        parameters.put("u_id",u_id);
        parameters.put("u_pwd",u_pwd);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {

        return  parameters;
    }
}
