package com.yanxin.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AppUser implements Serializable{
	private static final long serialVersionUID = 6031854054753338431L;

    @ApiModelProperty(name = "id",value = "主键ID",hidden = true)
    private Integer id;

    @ApiModelProperty(name = "userName",value = "用户名称")
    private String userName;
    
    @ApiModelProperty(name = "userPwd",value = "用户密码")
    private String userPwd;

    @ApiModelProperty(name = "mobile",value = "手机号码")
    private String mobile;

    @ApiModelProperty(name = "headUrl",value = "头像")
    private String headUrl;
    
    @ApiModelProperty(name = "token",value = "用户token")
    private String token;
    
    @ApiModelProperty(name = "createTime",value = "创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getUserName() {
		return userName;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final String getUserPwd() {
		return userPwd;
	}

	public final void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public final String getMobile() {
		return mobile;
	}

	public final void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public final String getHeadUrl() {
		return headUrl;
	}

	public final void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public final String getToken() {
		return token;
	}

	public final void setToken(String token) {
		this.token = token;
	}

	public final Date getCreateTime() {
		return createTime;
	}

	public final void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

}
