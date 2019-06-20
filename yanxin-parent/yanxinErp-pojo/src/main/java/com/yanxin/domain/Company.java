package com.yanxin.domain;

import java.io.Serializable;

public class Company implements Serializable {
    private Integer id;

    private String companyName;

    private String companyAddress;

    private String businessLicense;

    private String idCardpositive;

    private String idCardotherside;

    private String weixinPayaccount;

    private String aliPayaccount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public String getIdCardpositive() {
        return idCardpositive;
    }

    public void setIdCardpositive(String idCardpositive) {
        this.idCardpositive = idCardpositive == null ? null : idCardpositive.trim();
    }

    public String getIdCardotherside() {
        return idCardotherside;
    }

    public void setIdCardotherside(String idCardotherside) {
        this.idCardotherside = idCardotherside == null ? null : idCardotherside.trim();
    }

    public String getWeixinPayaccount() {
        return weixinPayaccount;
    }

    public void setWeixinPayaccount(String weixinPayaccount) {
        this.weixinPayaccount = weixinPayaccount == null ? null : weixinPayaccount.trim();
    }

    public String getAliPayaccount() {
        return aliPayaccount;
    }

    public void setAliPayaccount(String aliPayaccount) {
        this.aliPayaccount = aliPayaccount == null ? null : aliPayaccount.trim();
    }
}