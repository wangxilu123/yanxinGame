package com.yanxin.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderProduct {
    private Integer id;

    private Integer orderId;

    private String productName;

    private String goodCode;
    
    private Integer productId;

    private Integer productNum;

    private Date createTime;
    
    private String haixinUrl;
    
    private BigDecimal price;
    
    private String weight;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final Integer getOrderId() {
		return orderId;
	}

	public final void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public final String getProductName() {
		return productName;
	}

	public final void setProductName(String productName) {
		this.productName = productName;
	}

	public final String getGoodCode() {
		return goodCode;
	}

	public final void setGoodCode(String goodCode) {
		this.goodCode = goodCode;
	}

	public final Integer getProductId() {
		return productId;
	}

	public final void setProductId(Integer productId) {
		this.productId = productId;
	}

	public final Integer getProductNum() {
		return productNum;
	}

	public final void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public final Date getCreateTime() {
		return createTime;
	}

	public final void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public final String getHaixinUrl() {
		return haixinUrl;
	}

	public final void setHaixinUrl(String haixinUrl) {
		this.haixinUrl = haixinUrl;
	}

	public final BigDecimal getPrice() {
		return price;
	}

	public final void setPrice(BigDecimal price) {
		this.price = price;
	}

	public final String getWeight() {
		return weight;
	}

	public final void setWeight(String weight) {
		this.weight = weight;
	}

}