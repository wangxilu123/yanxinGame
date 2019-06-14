package com.yanxin.domain;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ShopCart {
	
	@ApiModelProperty(name = "id",value = "主键ID",hidden = true)
    private Integer id;

	@ApiModelProperty(name = "userId",value = "用户ID")
    private Integer userId;

	@ApiModelProperty(name = "shopId",value = "门店ID")
    private Integer shopId;

	@ApiModelProperty(name = "goodName",value = "商品名称")
    private String goodName;

	@ApiModelProperty(name = "goodCode",value = "商品唯一标志")
    private String goodCode;
	
	@ApiModelProperty(name = "categoryId",value = "商品二级分类ID")
    private Integer categoryId;
	
	@ApiModelProperty(name = "productId",value = "商品ID")
    private Integer productId;
    
	@ApiModelProperty(name = "specifications",value = "规格")
    private String specifications;

	@ApiModelProperty(name = "goodNum",value = "商品订购数量")
    private Integer goodNum;

	@ApiModelProperty(name = "amount",value = "商品订购总价")
    private BigDecimal amount;

	@ApiModelProperty(name = "imageUrl",value = "商品图片")
    private String imageUrl;

	@ApiModelProperty(name = "originalPrice",value = "商品原价")
    private BigDecimal originalPrice;
	
	@ApiModelProperty(name = "price",value = "商品单价")
    private BigDecimal price;
	
	@ApiModelProperty(name = "promotionList",value = "商品促销信息")
	private List<Promotion>  promotionList;
    
	@ApiModelProperty(name = "coupon",value = "商品优惠券")
    private String coupon;
    
	@ApiModelProperty(name = "couponId",value = "商品优惠券ID")
    private Integer couponId;

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

	public final Integer getShopId() {
		return shopId;
	}

	public final void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public final String getGoodName() {
		return goodName;
	}

	public final void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public final String getGoodCode() {
		return goodCode;
	}

	public final void setGoodCode(String goodCode) {
		this.goodCode = goodCode;
	}

	public final Integer getCategoryId() {
		return categoryId;
	}

	public final void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public final Integer getProductId() {
		return productId;
	}

	public final void setProductId(Integer productId) {
		this.productId = productId;
	}

	public final String getSpecifications() {
		return specifications;
	}

	public final void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public final Integer getGoodNum() {
		return goodNum;
	}

	public final void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}

	public final BigDecimal getAmount() {
		return amount;
	}

	public final void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public final String getImageUrl() {
		return imageUrl;
	}

	public final void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public final BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public final void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public final BigDecimal getPrice() {
		return price;
	}

	public final void setPrice(BigDecimal price) {
		this.price = price;
	}

	public final List<Promotion> getPromotionList() {
		return promotionList;
	}

	public final void setPromotionList(List<Promotion> promotionList) {
		this.promotionList = promotionList;
	}

	public final String getCoupon() {
		return coupon;
	}

	public final void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public final Integer getCouponId() {
		return couponId;
	}

	public final void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	
}