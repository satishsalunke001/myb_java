package com.rts.myb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_payout_main")
public class MyPayoutMain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer payoutId;
	private String referId;
	private double treeIncentive;
	private double directIncentive;
	private double incentive;
	private Integer viewStatus;
	private double orgTreeIncentive;
	private double capping;
	private String invalidPayoutMessage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPayoutId() {
		return payoutId;
	}
	public void setPayoutId(Integer payoutId) {
		this.payoutId = payoutId;
	}
	public String getReferId() {
		return referId;
	}
	public void setReferId(String referId) {
		this.referId = referId;
	}
	public double getTreeIncentive() {
		return treeIncentive;
	}
	public void setTreeIncentive(double treeIncentive) {
		this.treeIncentive = treeIncentive;
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
	public Integer getViewStatus() {
		return viewStatus;
	}
	public void setViewStatus(Integer viewStatus) {
		this.viewStatus = viewStatus;
	}
	public double getOrgTreeIncentive() {
		return orgTreeIncentive;
	}
	public void setOrgTreeIncentive(double orgTreeIncentive) {
		this.orgTreeIncentive = orgTreeIncentive;
	}
	public double getCapping() {
		return capping;
	}
	public void setCapping(double capping) {
		this.capping = capping;
	}
	public String getInvalidPayoutMessage() {
		return invalidPayoutMessage;
	}
	public void setInvalidPayoutMessage(String invalidPayoutMessage) {
		this.invalidPayoutMessage = invalidPayoutMessage;
	}
	
	
}
