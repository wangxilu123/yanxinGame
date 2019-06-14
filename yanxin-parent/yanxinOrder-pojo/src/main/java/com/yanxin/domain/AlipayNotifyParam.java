package com.yanxin.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AlipayNotifyParam{
	
	private String appId;   
    private String tradeNo; // 支付宝交易凭证号 
    private String outTradeNo; // 原支付请求的商户订单号   
    private String outBizNo; // 商户业务ID，主要是退款通知中返回退款申请的流水号   
    private String buyerId; // 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字    
    private String buyerLogonId; // 买家支付宝账号 
    private String sellerId; // 卖家支付宝用户号    
    private String sellerEmail; // 卖家支付宝账号  
    private String tradeStatus; // 交易目前所处的状态，见交易状态说明    
    private BigDecimal totalAmount; // 本次交易支付的订单金额  
    private BigDecimal receiptAmount; // 商家在交易中实际收到的款项  
    private BigDecimal buyerPayAmount; // 用户在交易中支付的金额   
    private BigDecimal refundFee; // 退款通知中，返回总退款金额，单位为元，支持两位小数  
    private String subject; // 商品的标题/交易标题/订单标题/订单关键字等   
    private String body; // 该订单的备注、描述、明细等。对应请求时的body参数，原样通知回来   
    private Date gmtCreate; // 该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss 
    private Date gmtPayment; // 该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss  
    private Date gmtRefund; // 该笔交易的退款时间。格式为yyyy-MM-dd HH:mm:ss.S   
    private Date gmtClose; // 该笔交易结束时间。格式为yyyy-MM-dd HH:mm:ss   
    private String fundBillList; // 支付成功的各个渠道金额信息,array 
    private String passbackParams; // 公共回传参数，如果请求时传递了该参数，则返回给商户时会在异步通知时将该参数原样返回。    
	public final String getAppId() {
		return appId;
	}
	public final void setAppId(String appId) {
		this.appId = appId;
	}
	public final String getTradeNo() {
		return tradeNo;
	}
	public final void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public final String getOutTradeNo() {
		return outTradeNo;
	}
	public final void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public final String getOutBizNo() {
		return outBizNo;
	}
	public final void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	public final String getBuyerId() {
		return buyerId;
	}
	public final void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public final String getBuyerLogonId() {
		return buyerLogonId;
	}
	public final void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}
	public final String getSellerId() {
		return sellerId;
	}
	public final void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public final String getSellerEmail() {
		return sellerEmail;
	}
	public final void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public final String getTradeStatus() {
		return tradeStatus;
	}
	public final void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	public final BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public final void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public final BigDecimal getReceiptAmount() {
		return receiptAmount;
	}
	public final void setReceiptAmount(BigDecimal receiptAmount) {
		this.receiptAmount = receiptAmount;
	}
	public final BigDecimal getBuyerPayAmount() {
		return buyerPayAmount;
	}
	public final void setBuyerPayAmount(BigDecimal buyerPayAmount) {
		this.buyerPayAmount = buyerPayAmount;
	}
	public final BigDecimal getRefundFee() {
		return refundFee;
	}
	public final void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}
	public final String getSubject() {
		return subject;
	}
	public final void setSubject(String subject) {
		this.subject = subject;
	}
	public final String getBody() {
		return body;
	}
	public final void setBody(String body) {
		this.body = body;
	}
	public final Date getGmtCreate() {
		return gmtCreate;
	}
	public final void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public final Date getGmtPayment() {
		return gmtPayment;
	}
	public final void setGmtPayment(Date gmtPayment) {
		this.gmtPayment = gmtPayment;
	}
	public final Date getGmtRefund() {
		return gmtRefund;
	}
	public final void setGmtRefund(Date gmtRefund) {
		this.gmtRefund = gmtRefund;
	}
	public final Date getGmtClose() {
		return gmtClose;
	}
	public final void setGmtClose(Date gmtClose) {
		this.gmtClose = gmtClose;
	}
	public final String getFundBillList() {
		return fundBillList;
	}
	public final void setFundBillList(String fundBillList) {
		this.fundBillList = fundBillList;
	}
	public final String getPassbackParams() {
		return passbackParams;
	}
	public final void setPassbackParams(String passbackParams) {
		this.passbackParams = passbackParams;
	}

}