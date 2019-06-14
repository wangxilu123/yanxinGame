package com.yanxin.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Advertisement {
    private Integer id;

    private String position;

    private String type;

    private String imageUrl;

    private String notifyUrl;

    private String productCode;

    private Date createTime;

    private Integer onShelf;

    private Integer shopId;
    
    private String adverName;
    
    private Integer number;
    
    private String shopName;
    
    private String goodName;
    
    private Integer isShop;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getPosition() {
		return position;
	}

	public final void setPosition(String position) {
		this.position = position;
	}

	public final String getType() {
		return type;
	}

	public final void setType(String type) {
		this.type = type;
	}

	public final String getImageUrl() {
		return imageUrl;
	}

	public final void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public final String getNotifyUrl() {
		return notifyUrl;
	}

	public final void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public final String getProductCode() {
		return productCode;
	}

	public final void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public final Date getCreateTime() {
		return createTime;
	}

	public final void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public final Integer getOnShelf() {
		return onShelf;
	}

	public final void setOnShelf(Integer onShelf) {
		this.onShelf = onShelf;
	}

	public final Integer getShopId() {
		return shopId;
	}

	public final void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public final String getAdverName() {
		return adverName;
	}

	public final void setAdverName(String adverName) {
		this.adverName = adverName;
	}

	public final Integer getNumber() {
		return number;
	}

	public final void setNumber(Integer number) {
		this.number = number;
	}

	public final String getShopName() {
		return shopName;
	}

	public final void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public final String getGoodName() {
		return goodName;
	}

	public final void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public final Integer getIsShop() {
		return isShop;
	}

	public final void setIsShop(Integer isShop) {
		this.isShop = isShop;
	}
    
}