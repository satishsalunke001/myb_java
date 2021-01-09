package com.rts.myb.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_payout_child")
public class MyPayoutChild {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Timestamp dateTime;
	private Timestamp updateTime;
	private Integer sponsorId;
	private Integer referId;
	private String node;
	private Integer packageId;
	private double purchase;
	private double pv;
	private Integer addon;
	private Integer applied;
	private Integer payoutId;
	private boolean powerLeg;
	private Integer backendUpdated;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}
	public Integer getReferId() {
		return referId;
	}
	public void setReferId(Integer referId) {
		this.referId = referId;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public double getPurchase() {
		return purchase;
	}
	public void setPurchase(double purchase) {
		this.purchase = purchase;
	}
	public double getPv() {
		return pv;
	}
	public void setPv(double pv) {
		this.pv = pv;
	}
	public Integer getAddon() {
		return addon;
	}
	public void setAddon(Integer addon) {
		this.addon = addon;
	}
	public Integer getApplied() {
		return applied;
	}
	public void setApplied(Integer applied) {
		this.applied = applied;
	}
	public Integer getPayoutId() {
		return payoutId;
	}
	public void setPayoutId(Integer payoutId) {
		this.payoutId = payoutId;
	}
	public boolean isPowerLeg() {
		return powerLeg;
	}
	public void setPowerLeg(boolean powerLeg) {
		this.powerLeg = powerLeg;
	}
	public Integer getBackendUpdated() {
		return backendUpdated;
	}
	public void setBackendUpdated(Integer backendUpdated) {
		this.backendUpdated = backendUpdated;
	}
	
	
}
