package com.rts.myb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_direct_payout")
public class MyDirectPayout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Integer id;
	@Column(name="sponsor_id", nullable = true)
	private Integer sponsorId;
	@Column(name="purchase", nullable = false)
	private double purchase = (double) 0.00;
	@Column(name="purchase_pv", nullable = false)
	private double purchasePv = (double) 0.00;
	@Column(name="direct_incentive", nullable = false)
	private double directIncentive = (double) 0.00;
	@Column(name="incentive", nullable = false)
	private double incentive = (double) 0.00;
	@Column(name="capping", nullable = false)
	private double capping = (double) 0.00;
	@Column(name="payout_date", nullable = true)
	private Date payoutDate;
	@Column(name="actual_date", nullable = true)
	private Date actualDate;
	@Column(name="is_paid", nullable = true)
	private Integer isPaid;
	@Column(name="invalid_message", nullable = true)
	private String invalidMessage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}
	public double getPurchase() {
		return purchase;
	}
	public void setPurchase(double purchase) {
		this.purchase = purchase;
	}
	public double getPurchasePv() {
		return purchasePv;
	}
	public void setPurchasePv(double purchasePv) {
		this.purchasePv = purchasePv;
	}
	public double getDirectIncentive() {
		return directIncentive;
	}
	public void setDirectIncentive(double directIncentive) {
		this.directIncentive = directIncentive;
	}
	public double getIncentive() {
		return incentive;
	}
	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}
	public double getCapping() {
		return capping;
	}
	public void setCapping(double capping) {
		this.capping = capping;
	}
	public Date getPayoutDate() {
		return payoutDate;
	}
	public void setPayoutDate(Date payoutDate) {
		this.payoutDate = payoutDate;
	}
	public Date getActualDate() {
		return actualDate;
	}
	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}
	public Integer getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(Integer isPaid) {
		this.isPaid = isPaid;
	}
	public String getInvalidMessage() {
		return invalidMessage;
	}
	public void setInvalidMessage(String invalidMessage) {
		this.invalidMessage = invalidMessage;
	}
	
	
	
	
	
	
	
}
