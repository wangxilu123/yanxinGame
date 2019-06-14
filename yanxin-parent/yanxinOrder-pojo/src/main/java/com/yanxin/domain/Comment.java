package com.yanxin.domain;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Comment {
	
	@ApiModelProperty(name = "id",value = "主键ID",hidden = true)
    private Integer id;

	@ApiModelProperty(name = "score",value = "评分")
    private Double score;

	@ApiModelProperty(name = "createTime",value = "创建时间")
    private Date createTime;

	@ApiModelProperty(name = "userId",value = "用户ID")
    private Integer userId;

	@ApiModelProperty(name = "userName",value = "用户名")
    private String userName;

	@ApiModelProperty(name = "shopId",value = "门店ID")
    private Integer shopId;

	@ApiModelProperty(name = "content",value = "评论内容")
    private String content;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final Double getScore() {
		return score;
	}

	public final void setScore(Double score) {
		this.score = score;
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

	public final String getUserName() {
		return userName;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final Integer getShopId() {
		return shopId;
	}

	public final void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public final String getContent() {
		return content;
	}

	public final void setContent(String content) {
		this.content = content;
	}

}