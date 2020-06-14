package com.graduation.jaegoproject;

public class Products {
    private String p_no;
    private String u_id;
    private String p_code;
    private String p_name;
    private String p_category;
    private String p_size;
    private String p_ea;
    private String s_name;

    public Products(String p_no,String u_id,String p_code,String p_name,String p_category,String p_size,String p_ea,String s_name)
    {
        this.p_no = p_no; this.u_id =u_id; this.p_code = p_code;this.p_name = p_name; this.p_category = p_category; this.p_size = p_size; this.p_ea = p_ea; this.s_name = s_name;
    }
    public Products(String p_name,String p_code,String p_category,String s_name,String p_ea){
        this.p_name = p_name; this.p_category = p_category; this.p_code = p_code; this.s_name = s_name; this.p_ea = p_ea;
    }

    public String getP_no() {return p_no; }

    public void setP_no(String p_no) {
        this.p_no = p_no;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getP_code() {
        return p_code;
    }

    public void setP_code(String p_code) {
        this.p_code = p_code;
    }
    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_category() {
        return p_category;
    }

    public void setP_category(String p_category) {
        this.p_category = p_category;
    }

    public String getP_size() {
        return p_size;
    }

    public void setP_size(String p_size) {
        this.p_size = p_size;
    }

    public String getP_ea() {
        return p_ea;
    }

    public void setP_ea(String p_ea) {
        this.p_ea = p_ea;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }


}
