package com.yanxin.domain;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderProductTransfer {
	
	@ApiModelProperty(name = "productId",value = "商品ID")
    private Integer productId;
	
	@ApiModelProperty(name = "productName",value = "商品名称")
    private String productName;

	@ApiModelProperty(name = "productCode",value = "商品唯一标识")
    private String productCode;
	
	@ApiModelProperty(name = "barCode",value = "商品条码")
    private String barCode;

	@ApiModelProperty(name = "productNum",value = "商品数量")
    private Integer productNum;
    
	@ApiModelProperty(name = "productUrl",value = "商品图片")
    private String productUrl;
    
	@ApiModelProperty(name = "price",value = "商品单价")
    private BigDecimal price;
	
	@ApiModelProperty(name = "originalPrice",value = "商品原单价")
    private BigDecimal originalPrice;
    
	@ApiModelProperty(name = "amount",value = "商品总金额")
    private BigDecimal amount;
	
	@ApiModelProperty(name = "unit",value = "商品单位")
    private String unit;
	
	@ApiModelProperty(name = "weight",value = "商品重量")
    private String weight;
  
	@ApiModelProperty(name = "haixinNum",value = "海信数量")
    private String haixinNum;

	public final Integer getProductId() {
		return productId;
	}

	public final void setProductId(Integer productId) {
		this.productId = productId;
	}

	public final String getProductName() {
		return productName;
	}

	public final void setProductName(String productName) {
		this.productName = productName;
	}

	public final String getProductCode() {
		return productCode;
	}

	public final void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public final String getBarCode() {
		return barCode;
	}

	public final void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public final Integer getProductNum() {
		return productNum;
	}

	public final void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public final String getProductUrl() {
		return productUrl;
	}

	public final void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public final BigDecimal getPrice() {
		return price;
	}

	public final void setPrice(BigDecimal price) {
		this.price = price;
	}

	public final BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public final void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public final BigDecimal getAmount() {
		return amount;
	}

	public final void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public final String getUnit() {
		return unit;
	}

	public final void setUnit(String unit) {
		this.unit = unit;
	}

	public final String getWeight() {
		return weight;
	}

	public final void setWeight(String weight) {
		this.weight = weight;
	}

	public final String getHaixinNum() {
		return haixinNum;
	}

	public final void setHaixinNum(String haixinNum) {
		this.haixinNum = haixinNum;
	}
}