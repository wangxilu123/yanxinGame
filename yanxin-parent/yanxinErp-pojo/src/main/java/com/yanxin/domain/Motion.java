package com.yanxin.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Motion {
    private Integer id;

    private String imageUrl;

    private String productIds;

    private Date createTime;

    private String position;

    private Integer shopId;

    private Integer onShelf;

    private String motionName;
    
    private String type;

    private String urlType;
    
    private String productCode;
    
    private List<ProductTransfer> productList;
    
    private String notifyUrl;
    private String shopName;
    
    private String goodName;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getImageUrl() {
		return imageUrl;
	}

	public final void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public final String getProductIds() {
		return productIds;
	}

	public final void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public final Date getCreateTime() {
		return createTime;
	}

	public final void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public final String getPosition() {
		return position;
	}

	public final void setPosition(String position) {
		this.position = position;
	}

	public final Integer getShopId() {
		return shopId;
	}

	public final void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public final Integer getOnShelf() {
		return onShelf;
	}

	public final void setOnShelf(Integer onShelf) {
		this.onShelf = onShelf;
	}

	public final String getMotionName() {
		return motionName;
	}

	public final void setMotionName(String motionName) {
		this.motionName = motionName;
	}

	public final String getType() {
		return type;
	}

	public final void setType(String type) {
		this.type = type;
	}

	public final String getUrlType() {
		return urlType;
	}

	public final void setUrlType(String urlType) {
		this.urlType = urlType;
	}

	public final String getProductCode() {
		return productCode;
	}

	public final void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public final List<ProductTransfer> getProductList() {
		return productList;
	}

	public final void setProductList(List<ProductTransfer> productList) {
		this.productList = productList;
	}

	public final String getNotifyUrl() {
		return notifyUrl;
	}

	public final void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
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
    
}