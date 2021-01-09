package com.rts.myb.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_member_volume")
public class MyMemberVolume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="role", nullable = false)
	private Integer refer_id;
	@Column(name="total_purchase", nullable = false)
	private double totalPurchase;
	@Column(name="total_pv", nullable = false)
	private double totalPv;
	@Column(name="total_member_count", nullable = false)
	private Integer totalMemberCount;
	@Column(name="left_member_count", nullable = false)
	private Integer leftMemberCount;
	@Column(name="left_member_purchaseCount", nullable = false)
	private Integer leftMemberPurchaseCount;
	@Column(name="left_member_purchase", nullable = false)
	private double leftMemberPurchase;
	@Column(name="left_member_pv", nullable = false)
	private double leftMemberPv;
	@Column(name="right_member_count", nullable = false)
	private Integer rightMemberCount;
	@Column(name=" right_member_purchase_count", nullable = false)
	private Integer rightMemberPurchaseCount;
	@Column(name="right_member_purchase", nullable = false)
	private double rightMemberPurchase;
	@Column(name="right_member_pv", nullable = false)
	private double rightMemberPv;
	@Column(name="date_modified", nullable = false)
	private Timestamp dateModified;
	@Column(name="status", nullable = false)
	private Integer status = 0;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRefer_id() {
		return refer_id;
	}
	public void setRefer_id(Integer refer_id) {
		this.refer_id = refer_id;
	}
	public double getTotalPurchase() {
		return totalPurchase;
	}
	public void setTotalPurchase(double totalPurchase) {
		this.totalPurchase = totalPurchase;
	}
	public double getTotalPv() {
		return totalPv;
	}
	public void setTotalPv(double totalPv) {
		this.totalPv = totalPv;
	}
	public Integer getTotalMemberCount() {
		return totalMemberCount;
	}
	public void setTotalMemberCount(Integer totalMemberCount) {
		this.totalMemberCount = totalMemberCount;
	}
	public Integer getLeftMemberCount() {
		return leftMemberCount;
	}
	public void setLeftMemberCount(Integer leftMemberCount) {
		this.leftMemberCount = leftMemberCount;
	}
	public Integer getLeftMemberPurchaseCount() {
		return leftMemberPurchaseCount;
	}
	public void setLeftMemberPurchaseCount(Integer leftMemberPurchaseCount) {
		this.leftMemberPurchaseCount = leftMemberPurchaseCount;
	}
	public double getLeftMemberPurchase() {
		return leftMemberPurchase;
	}
	public void setLeftMemberPurchase(double leftMemberPurchase) {
		this.leftMemberPurchase = leftMemberPurchase;
	}
	public double getLeftMemberPv() {
		return leftMemberPv;
	}
	public void setLeftMemberPv(double leftMemberPv) {
		this.leftMemberPv = leftMemberPv;
	}
	public Integer getRightMemberCount() {
		return rightMemberCount;
	}
	public void setRightMemberCount(Integer rightMemberCount) {
		this.rightMemberCount = rightMemberCount;
	}
	public Integer getRightMemberPurchaseCount() {
		return rightMemberPurchaseCount;
	}
	public void setRightMemberPurchaseCount(Integer rightMemberPurchaseCount) {
		this.rightMemberPurchaseCount = rightMemberPurchaseCount;
	}
	public double getRightMemberPurchase() {
		return rightMemberPurchase;
	}
	public void setRightMemberPurchase(double rightMemberPurchase) {
		this.rightMemberPurchase = rightMemberPurchase;
	}
	public double getRightMemberPv() {
		return rightMemberPv;
	}
	public void setRightMemberPv(double rightMemberPv) {
		this.rightMemberPv = rightMemberPv;
	}
	public Timestamp getDateModified() {
		return dateModified;
	}
	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
