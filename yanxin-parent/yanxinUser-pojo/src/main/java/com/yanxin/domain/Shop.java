package com.yanxin.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Shop {
	
	@ApiModelProperty(name = "id",value = "主键ID",hidden = true)
    private Integer id;

	@ApiModelProperty(name = "shopName",value = "门店名称")
    private String shopName;

	@ApiModelProperty(name = "shopAddress",value = "门店地址")
    private String shopAddress;

	@ApiModelProperty(name = "longitude",value = "门店经度")
    private String longitude;

	@ApiModelProperty(name = "dimension",value = "门店维度")
    private String dimension;

	@ApiModelProperty(name = "imageUrl",value = "门店图片")
    private String imageUrl;

	@ApiModelProperty(name = "description",value = "门店描述")
    private String description;

	@ApiModelProperty(name = "owner",value = "门店负责人")
    private String owner;

	@ApiModelProperty(name = "electronicFence",value = "门店配送范围")
    private String electronicFence;

	@ApiModelProperty(name = "weixinMchid",value = "门店微信商户ID")
    private String weixinMchid;

	@ApiModelProperty(name = "weixinApikey",value = "门店微信APPKEY")
    private String weixinApikey;

	@ApiModelProperty(name = "aliPartnerid",value = "门店支付宝合作和ID")
    private String aliPartnerid;

	@ApiModelProperty(name = "aliPrivatekey",value = "门店支付宝商户私钥")
    private String aliPrivatekey;
	
	@ApiModelProperty(name = "createTime",value = "创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
	
	@ApiModelProperty(name = "needTime",value = "所需时间")
	private Integer needTime;
	
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
	
	@ApiModelProperty(name = "industryType",value = "行业分类")
    private String industryType;

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

	public final String getOwner() {
		return owner;
	}

	public final void setOwner(String owner) {
		this.owner = owner;
	}

	public final String getElectronicFence() {
		return electronicFence;
	}

	public final void setElectronicFence(String electronicFence) {
		this.electronicFence = electronicFence;
	}

	public final String getWeixinMchid() {
		return weixinMchid;
	}

	public final void setWeixinMchid(String weixinMchid) {
		this.weixinMchid = weixinMchid;
	}

	public final String getWeixinApikey() {
		return weixinApikey;
	}

	public final void setWeixinApikey(String weixinApikey) {
		this.weixinApikey = weixinApikey;
	}

	public final String getAliPartnerid() {
		return aliPartnerid;
	}

	public final void setAliPartnerid(String aliPartnerid) {
		this.aliPartnerid = aliPartnerid;
	}

	public final String getAliPrivatekey() {
		return aliPrivatekey;
	}

	public final void setAliPrivatekey(String aliPrivatekey) {
		this.aliPrivatekey = aliPrivatekey;
	}

	public final Date getCreateTime() {
		return createTime;
	}

	public final void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public final Integer getNeedTime() {
		return needTime;
	}

	public final void setNeedTime(Integer needTime) {
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

	public final String getIndustryType() {
		return industryType;
	}

	public final void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	
	
}