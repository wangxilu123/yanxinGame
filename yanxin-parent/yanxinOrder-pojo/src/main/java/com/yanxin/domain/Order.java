package com.yanxin.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Order implements Serializable{
	
    private static final long serialVersionUID = 6031854054753338431L;
    
	@ApiModelProperty(name = "id",value = "主键ID",hidden = true)
    private Integer id;

	@ApiModelProperty(name = "userId",value = "用户ID",hidden = true)
    private Integer userId;

	@ApiModelProperty(name = "orderNum",value = "订单编号")
    private String orderNum;

	@ApiModelProperty(name = "status",value = "订单状态0待支付，1待配送（已支付），2配送中，3已完成，4退货，5已取消")
    private String status;

	@ApiModelProperty(name = "storeId",value = "门店ID")
    private Integer storeId;

	@ApiModelProperty(name = "payType",value = "支付方式")
    private String payType;

	@ApiModelProperty(name = "orderTime",value = "订单时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

	@ApiModelProperty(name = "orderAmount",value = "订单金额")
    private BigDecimal orderAmount;

	@ApiModelProperty(name = "remarks",value = "备注")
    private String remarks;
	
	@ApiModelProperty(name = "addressId",value = "收货地址ID")
    private String addressId;
	
	@ApiModelProperty(name = "receiveTime",value = "预计收货时间")
    private String receiveTime;
	
	@ApiModelProperty(name = "receipt",value = "发票实体对象")
    private Receipt receipt;
	
	@ApiModelProperty(name = "couponCodeId",value = "优惠券ID")
    private Integer couponCodeId;
	
	@ApiModelProperty(name = "productList",value = "下单时传的")
	private List<OrderProduct>  productList;
	
	@ApiModelProperty(name = "productList",value = "查询返回的")
	private List<OrderProductTransfer>  productDetails;
	
	@ApiModelProperty(name = "categoryAndAmountList",value = "二级分和金额")
	private List<CategoryAndAmount>  categoryAndAmountList;
	
	@ApiModelProperty(name = "address",value = "收货地址信息")
    private UserAddress address;
	
	@ApiModelProperty(name = "shopName",value = "门店名称")
    private String shopName;
	
	@ApiModelProperty(name = "shopAddress",value = "门店地址")
    private String shopAddress;
	
	@ApiModelProperty(name = "totalAmount",value = "商品总金额")
    private BigDecimal totalAmount;
	
	@ApiModelProperty(name = "preferential",value = "优惠总金额")
    private BigDecimal preferential;
	
	@ApiModelProperty(name = "orderResource",value = "订单来源")
    private String orderResource;
	
	@ApiModelProperty(name = "goodNum",value = "商品种类")
    private Integer goodNum;
	
	@ApiModelProperty(name = "haixinShopCode",value = "海信门店编码")
    private String haixinShopCode;
	
	@ApiModelProperty(name = "phone",value = "用户手机号")
    private String phone;
	
	@ApiModelProperty(name = "psPhone",value = "配送员手机号")
    private String psPhone;
	
	@ApiModelProperty(name = "youzanNum",value = "有赞订单号")
    private String youzanNum;
	
	@ApiModelProperty(name = "orderProducts",value = "对账单商品")
    private String orderProducts;
	
	@ApiModelProperty(name = "extractionType",value = "取货方式")
    private String extractionType;
	
	@ApiModelProperty(name = "postage",value = "邮费")
    private BigDecimal postage;

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

	public final String getOrderNum() {
		return orderNum;
	}

	public final void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	public final Integer getStoreId() {
		return storeId;
	}

	public final void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public final String getPayType() {
		return payType;
	}

	public final void setPayType(String payType) {
		this.payType = payType;
	}

	public final Date getOrderTime() {
		return orderTime;
	}

	public final void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public final BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public final void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public final String getRemarks() {
		return remarks;
	}

	public final void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public final String getAddressId() {
		return addressId;
	}

	public final void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public final String getReceiveTime() {
		return receiveTime;
	}

	public final void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public final Receipt getReceipt() {
		return receipt;
	}

	public final void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public final Integer getCouponCodeId() {
		return couponCodeId;
	}

	public final void setCouponCodeId(Integer couponCodeId) {
		this.couponCodeId = couponCodeId;
	}

	public final List<OrderProduct> getProductList() {
		return productList;
	}

	public final void setProductList(List<OrderProduct> productList) {
		this.productList = productList;
	}

	public final List<OrderProductTransfer> getProductDetails() {
		return productDetails;
	}

	public final void setProductDetails(List<OrderProductTransfer> productDetails) {
		this.productDetails = productDetails;
	}

	public final List<CategoryAndAmount> getCategoryAndAmountList() {
		return categoryAndAmountList;
	}

	public final void setCategoryAndAmountList(List<CategoryAndAmount> categoryAndAmountList) {
		this.categoryAndAmountList = categoryAndAmountList;
	}

	public final UserAddress getAddress() {
		return address;
	}

	public final void setAddress(UserAddress address) {
		this.address = address;
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

	public final BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public final void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public final BigDecimal getPreferential() {
		return preferential;
	}

	public final void setPreferential(BigDecimal preferential) {
		this.preferential = preferential;
	}

	public final String getOrderResource() {
		return orderResource;
	}

	public final void setOrderResource(String orderResource) {
		this.orderResource = orderResource;
	}

	public final Integer getGoodNum() {
		return goodNum;
	}

	public final void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}

	public final String getHaixinShopCode() {
		return haixinShopCode;
	}

	public final void setHaixinShopCode(String haixinShopCode) {
		this.haixinShopCode = haixinShopCode;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	public final String getPsPhone() {
		return psPhone;
	}

	public final void setPsPhone(String psPhone) {
		this.psPhone = psPhone;
	}

	public final String getYouzanNum() {
		return youzanNum;
	}

	public final void setYouzanNum(String youzanNum) {
		this.youzanNum = youzanNum;
	}

	public final String getOrderProducts() {
		return orderProducts;
	}

	public final void setOrderProducts(String orderProducts) {
		this.orderProducts = orderProducts;
	}

	public final String getExtractionType() {
		return extractionType;
	}

	public final void setExtractionType(String extractionType) {
		this.extractionType = extractionType;
	}

	public final BigDecimal getPostage() {
		return postage;
	}

	public final void setPostage(BigDecimal postage) {
		this.postage = postage;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
	
}