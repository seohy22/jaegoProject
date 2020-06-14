package com.graduation.jaegoproject;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**

 * Created by kch on 2018. 7. 23..

 */
public class JoinRequest extends StringRequest {
    final static private String URL= "http://192.168.0.9:80/joinMember.php";
    private Map<String, String> parameters;

    public JoinRequest(String u_id, String u_pwd,String u_name,  Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();
        parameters.put("u_id",u_id);
        parameters.put("u_pwd",u_pwd);
        parameters.put("u_name",u_name);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {

        return  parameters;
    }
}
