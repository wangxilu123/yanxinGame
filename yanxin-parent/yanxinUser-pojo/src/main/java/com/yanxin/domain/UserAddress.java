package com.yanxin.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserAddress implements Serializable{
	
    private static final long serialVersionUID = 6031854054753338431L;
    
	@ApiModelProperty(name = "id",value = "主键ID",hidden = true)
    private Integer id;

	@ApiModelProperty(name = "userId",value = "用户ID",hidden = true)
    private Integer userId;

	@ApiModelProperty(name = "address",value = "详细地址")
    private String address;

	@ApiModelProperty(name = "phone",value = "联系电话")
    private String phone;

	@ApiModelProperty(name = "realName",value = "用户姓名")
    private String realName;

	@ApiModelProperty(name = "area",value = "地区信息")
    private String area;
    
	@ApiModelProperty(name = "longitude",value = "经度")
    private String longitude;
    
	@ApiModelProperty(name = "dimension",value = "维度")
    private String dimension;
	
	@ApiModelProperty(name = "isDef",value = "是否为默认值")
    private Integer isDef;
	
	@ApiModelProperty(name = "remarks",value = "备注")
    private String remarks;
	
	@ApiModelProperty(name = "yn",value = "是否有效")
    private Integer yn;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final Integer getUserId() {
		return userId;
	}

	public final void setUserId(Integer userId) {
		this.userId = userId;
	}

	public final String getAddress() {
		return address;
	}

	public final void setAddress(String address) {
		this.address = address;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	public final String getRealName() {
		return realName;
	}

	public final void setRealName(String realName) {
		this.realName = realName;
	}

	public final String getArea() {
		return area;
	}

	public final void setArea(String area) {
		this.area = area;
	}

	public final String getLongitude() {
		return longitude;
	}

	public final void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public final String getDimension() {
		return dimension;
	}

	public final void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public final Integer getIsDef() {
		return isDef;
	}

	public final void setIsDef(Integer isDef) {
		this.isDef = isDef;
	}

	public final String getRemarks() {
		return remarks;
	}

	public final void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public final Integer getYn() {
		return yn;
	}

	public final void setYn(Integer yn) {
		this.yn = yn;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

}