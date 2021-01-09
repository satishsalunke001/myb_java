package com.rts.myb.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MyPayOutRunDto {


	private Integer id;
	private String payoutRunDate;
	private String payoutStartDate;
	private String payoutEndDate;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPayoutRunDate() {
		return payoutRunDate;
	}
	public void setPayoutRunDate(String payoutRunDate) {
		this.payoutRunDate = payoutRunDate;
	}
	public String getPayoutStartDate() {
		return payoutStartDate;
	}
	public void setPayoutStartDate(String payoutStartDate) {
		this.payoutStartDate = payoutStartDate;
	}
	
	public String getPayoutEndDate() {
		return payoutEndDate;
	}
	public void setPayoutEndDate(String payoutEndDate) {
		this.payoutEndDate = payoutEndDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
