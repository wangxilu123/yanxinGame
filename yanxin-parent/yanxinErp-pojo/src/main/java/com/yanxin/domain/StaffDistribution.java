package com.yanxin.domain;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StaffDistribution {
	
	@ApiModelProperty(name = "id",value = "主键ID",hidden = true)
    private Integer id;

	@ApiModelProperty(name = "adminId",value = "员工ID")
    private Integer adminId;

	@ApiModelProperty(name = "orderId",value = "订单ID")
    private Integer orderId;

	@ApiModelProperty(name = "status",value = "订单状态")
    private String status;

	@ApiModelProperty(name = "addressId",value = "地址ID")
    private Integer addressId;

	@ApiModelProperty(name = "createTime",value = "创建时间")
    private Date createTime;
    
	@ApiModelProperty(name = "cancelReason",value = "取消原因")
    private String cancelReason;
	
	@ApiModelProperty(name = "shopId",value = "门店ID")
    private Integer shopId;
	
	@ApiModelProperty(name = "psPhone",value = "配送电话")
    private String psPhone;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final Integer getAdminId() {
		return adminId;
	}

	public final void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public final Integer getOrderId() {
		return orderId;
	}

	public final void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	public final Integer getAddressId() {
		return addressId;
	}

	public final void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public final Date getCreateTime() {
		return createTime;
	}

	public final void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public final String getCancelReason() {
		return cancelReason;
	}

	public final void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public final Integer getShopId() {
		return shopId;
	}

	public final void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public final String getPsPhone() {
		return psPhone;
	}

	public final void setPsPhone(String psPhone) {
		this.psPhone = psPhone;
	}

    
}