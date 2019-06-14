package com.yanxin.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ShopResponse {
	
	@ApiModelProperty(name = "id",value = "主键ID")
    private Integer id;

    @ApiModelProperty(name = "shopName",value = "门店名称")
    private String shopName;

	@ApiModelProperty(name = "shopAddress",value = "门店地址")
    private String shopAddress;

	@ApiModelProperty(name = "imageUrl",value = "门店图片")
    private String imageUrl;

	@ApiModelProperty(name = "description",value = "门店描述")
    private String description;
	
	@ApiModelProperty(name = "needTime",value = "所需时间")
	private double needTime;
	
	@ApiModelProperty(name = "distance",value = "距离")
	private double distance;
	
	@ApiModelProperty(name = "monthSales",value = "月销")
	private Integer monthSales;
	
	@ApiModelProperty(name = "distributionCosts",value = "配送费")
	private double distributionCosts;
	
	@ApiModelProperty(name = "startDistributionCosts",value = "起送")
	private double startDistributionCosts;
	
	@ApiModelProperty(name = "score",value = "评分")
	private double score;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getShopName() {
		return shopName;
	}

	public final void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public final String getShopAddress() {
		return shopAddress;
	}

	public final void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public final String getImageUrl() {
		return imageUrl;
	}

	public final void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final double getNeedTime() {
		return needTime;
	}

	public final void setNeedTime(double needTime) {
		this.needTime = needTime;
	}

	public final double getDistance() {
		return distance;
	}

	public final void setDistance(double distance) {
		this.distance = distance;
	}

	public final Integer getMonthSales() {
		return monthSales;
	}

	public final void setMonthSales(Integer monthSales) {
		this.monthSales = monthSales;
	}

	public final double getDistributionCosts() {
		return distributionCosts;
	}

	public final void setDistributionCosts(double distributionCosts) {
		this.distributionCosts = distributionCosts;
	}

	public final double getStartDistributionCosts() {
		return startDistributionCosts;
	}

	public final void setStartDistributionCosts(double startDistributionCosts) {
		this.startDistributionCosts = startDistributionCosts;
	}

	public final double getScore() {
		return score;
	}

	public final void setScore(double score) {
		this.score = score;
	}
	
}