package com.yanxin.domain;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Receipt {
    private Integer id;

    @ApiModelProperty(name = "type",value = "发票类型（0个人，1公司）")
    private String type;

    @ApiModelProperty(name = "orderId",value = "订单ID")
    private Integer orderId;

    @ApiModelProperty(name = "phone",value = "收票人信息")
    private String phone;

    @ApiModelProperty(name = "content",value = "发票内容")
    private String content;

    @ApiModelProperty(name = "companyName",value = "发票公司抬头")
    private String companyName;

    @ApiModelProperty(name = "createTime",value = "发票税号")
    private String dutyParagraph;

    @ApiModelProperty(name = "createTime",value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "userId",value = "用户ID")
    private Integer userId;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getType() {
		return type;
	}

	public final void setType(String type) {
		this.type = type;
	}

	public final Integer getOrderId() {
		return orderId;
	}

	public final void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	public final String getContent() {
		return content;
	}

	public final void setContent(String content) {
		this.content = content;
	}

	public final String getCompanyName() {
		return companyName;
	}

	public final void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public final String getDutyParagraph() {
		return dutyParagraph;
	}

	public final void setDutyParagraph(String dutyParagraph) {
		this.dutyParagraph = dutyParagraph;
	}

	public final Date getCreateTime() {
		return createTime;
	}

	public final void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public final Integer getUserId() {
		return userId;
	}

	public final void setUserId(Integer userId) {
		this.userId = userId;
	}

  
}