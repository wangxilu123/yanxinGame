package com.yanxin.domain;

import java.io.Serializable;

public class Game implements Serializable {
    private Integer id;

    private String gameName;

    private String logoUrl;

    private String iosPackage;

    private String androidPackage;

    private String iosStatus;

    private String androidStatus;

    private String downloadUrl;

    private Integer companyId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getIosPackage() {
        return iosPackage;
    }

    public void setIosPackage(String iosPackage) {
        this.iosPackage = iosPackage == null ? null : iosPackage.trim();
    }

    public String getAndroidPackage() {
        return androidPackage;
    }

    public void setAndroidPackage(String androidPackage) {
        this.androidPackage = androidPackage == null ? null : androidPackage.trim();
    }

    public String getIosStatus() {
        return iosStatus;
    }

    public void setIosStatus(String iosStatus) {
        this.iosStatus = iosStatus == null ? null : iosStatus.trim();
    }

    public String getAndroidStatus() {
        return androidStatus;
    }

    public void setAndroidStatus(String androidStatus) {
        this.androidStatus = androidStatus == null ? null : androidStatus.trim();
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl == null ? null : downloadUrl.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}