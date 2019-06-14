package com.yanxin.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;    

@Data
@ToString
public class UserLogin implements Serializable{
	private static final long serialVersionUID = 6031854054753338431L;
    
	@ApiModelProperty(name = "id",value = "主键ID",hidden = true)
    private Integer id;

	@ApiModelProperty(name = "userAccount",value = "用户账号")
    private String userAccount;

	@ApiModelProperty(name = "token",value = "用户token")
    private String token;
    
	@ApiModelProperty(name = "deviceToken",value = "手机型号")
    private String deviceToken;
    
	@ApiModelProperty(name = "lastLogin",value = "最近登录时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastLogin;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getUserAccount() {
		return userAccount;
	}

	public final void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public final String getToken() {
		return token;
	}

	public final void setToken(String token) {
		this.token = token;
	}

	public final String getDeviceToken() {
		return deviceToken;
	}

	public final void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public final Date getLastLogin() {
		return lastLogin;
	}

	public final void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
