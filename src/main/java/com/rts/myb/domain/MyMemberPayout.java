package com.rts.myb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_member_payout")
public class MyMemberPayout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String referId;
	private Date enteredDate;
	private double totalPv;
	private double capping;
	private int approve;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReferId() {
		return referId;
	}
	public void setReferId(String referId) {
		this.referId = referId;
	}
	public Date getEnteredDate() {
		return enteredDate;
	}
	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}
	public double getTotalPv() {
		return totalPv;
	}
	public void setTotalPv(double totalPv) {
		this.totalPv = totalPv;
	}
	public double getCapping() {
		return capping;
	}
	public void setCapping(double capping) {
		this.capping = capping;
	}
	public int getApprove() {
		return approve;
	}
	public void setApprove(int approve) {
		this.approve = approve;
	}
	
	
}
