package com.rts.myb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_payout_run")
public class MyPayoutRun {

	@Id
	private Integer id;
	private Date payoutRunDate;
	private Date payoutStartDate;
	private Date payoutEndDate;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getPayoutRunDate() {
		return payoutRunDate;
	}
	public void setPayoutRunDate(Date payoutRunDate) {
		this.payoutRunDate = payoutRunDate;
	}
	public Date getPayoutStartDate() {
		return payoutStartDate;
	}
	public void setPayoutStartDate(Date payoutStartDate) {
		this.payoutStartDate = payoutStartDate;
	}
	public Date getPayoutEndDate() {
		return payoutEndDate;
	}
	public void setPayoutEndDate(Date payoutEndDate) {
		this.payoutEndDate = payoutEndDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
