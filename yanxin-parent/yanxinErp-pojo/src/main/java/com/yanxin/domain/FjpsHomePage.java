package com.yanxin.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FjpsHomePage {
	
	@ApiModelProperty(name = "todayDfjNum",value = "今日待分拣数量")
    private Integer todayDfjNum;
    
	@ApiModelProperty(name = "todayWfjNum",value = "今日完成分拣数量")
    private Integer todayWfjNum;

	@ApiModelProperty(name = "weekWfjNum",value = "本周完成分拣数量")
    private Integer weekWfjNum;

	@ApiModelProperty(name = "monthWfjNum",value = "本月完成分拣数量")
    private Integer monthWfjNum;

	@ApiModelProperty(name = "fjPercentage",value = "分拣完成百分比")
    private String fjPercentage;
	
	
	@ApiModelProperty(name = "todayDpsNum",value = "今日待配送数量")
    private Integer todayDpsNum;
    
	@ApiModelProperty(name = "todayWpsNum",value = "今日完成配送数量")
    private Integer todayWpsNum;

	@ApiModelProperty(name = "weekWpsNum",value = "本周完成配送数量")
    private Integer weekWpsNum;

	@ApiModelProperty(name = "monthWpsNum",value = "本月完成配送数量")
    private Integer monthWpsNum;

	@ApiModelProperty(name = "psPercentage",value = "配送完成百分比")
    private String psPercentage;

	public final Integer getTodayDfjNum() {
		return todayDfjNum;
	}

	public final void setTodayDfjNum(Integer todayDfjNum) {
		this.todayDfjNum = todayDfjNum;
	}

	public final Integer getTodayWfjNum() {
		return todayWfjNum;
	}

	public final void setTodayWfjNum(Integer todayWfjNum) {
		this.todayWfjNum = todayWfjNum;
	}

	public final Integer getWeekWfjNum() {
		return weekWfjNum;
	}

	public final void setWeekWfjNum(Integer weekWfjNum) {
		this.weekWfjNum = weekWfjNum;
	}

	public final Integer getMonthWfjNum() {
		return monthWfjNum;
	}

	public final void setMonthWfjNum(Integer monthWfjNum) {
		this.monthWfjNum = monthWfjNum;
	}

	public final String getFjPercentage() {
		return fjPercentage;
	}

	public final void setFjPercentage(String fjPercentage) {
		this.fjPercentage = fjPercentage;
	}

	public final Integer getTodayDpsNum() {
		return todayDpsNum;
	}

	public final void setTodayDpsNum(Integer todayDpsNum) {
		this.todayDpsNum = todayDpsNum;
	}

	public final Integer getTodayWpsNum() {
		return todayWpsNum;
	}

	public final void setTodayWpsNum(Integer todayWpsNum) {
		this.todayWpsNum = todayWpsNum;
	}

	public final Integer getWeekWpsNum() {
		return weekWpsNum;
	}

	public final void setWeekWpsNum(Integer weekWpsNum) {
		this.weekWpsNum = weekWpsNum;
	}

	public final Integer getMonthWpsNum() {
		return monthWpsNum;
	}

	public final void setMonthWpsNum(Integer monthWpsNum) {
		this.monthWpsNum = monthWpsNum;
	}

	public final String getPsPercentage() {
		return psPercentage;
	}

	public final void setPsPercentage(String psPercentage) {
		this.psPercentage = psPercentage;
	}
    
   
}