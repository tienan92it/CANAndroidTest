package com.antran.canandroidtest.model;

/**
 * Created by AN TRAN on 26/11/2016.
 */

public class Country {

    public static final String CTRY_CD = "ctry_cd";
    public static final String CTRY_KR = "ctry_kr";
    public static final String CTRY_EN = "ctry_en";
    public static final String CURR_CD = "curr_cd";
    public static final String CURR_NAME = "curr_name";
    public static final String AP_ICAN = "ap_ican";
    public static final String AP_CT_KR = "ap_ct_kr";
    public static final String AP_KR = "ap_kr";



    private String ctry_cd;
    private String ctry_kr;
    private String ctry_en;
    private String curr_cd;
    private String curr_name;
    private String ap_ican;
    private String ap_ct_kr;
    private String ap_kr;

    public String getCtry_cd() {
        return ctry_cd;
    }

    public void setCtry_cd(String ctry_cd) {
        this.ctry_cd = ctry_cd;
    }

    public String getCtry_kr() {
        return ctry_kr;
    }

    public void setCtry_kr(String ctry_kr) {
        this.ctry_kr = ctry_kr;
    }

    public String getCtry_en() {
        return ctry_en;
    }

    public void setCtry_en(String ctry_en) {
        this.ctry_en = ctry_en;
    }

    public String getCurr_cd() {
        return curr_cd;
    }

    public void setCurr_cd(String curr_cd) {
        this.curr_cd = curr_cd;
    }

    public String getCurr_name() {
        return curr_name;
    }

    public void setCurr_name(String curr_name) {
        this.curr_name = curr_name;
    }

    public String getAp_ican() {
        return ap_ican;
    }

    public void setAp_ican(String ap_ican) {
        this.ap_ican = ap_ican;
    }

    public String getAp_ct_kr() {
        return ap_ct_kr;
    }

    public void setAp_ct_kr(String ap_ct_kr) {
        this.ap_ct_kr = ap_ct_kr;
    }

    public String getAp_kr() {
        return ap_kr;
    }

    public void setAp_kr(String ap_kr) {
        this.ap_kr = ap_kr;
    }
}
