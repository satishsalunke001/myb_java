package com.rts.myb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_voucher")
public class MyVoucher {

	@Id
	private Integer id;
	private String voucherShopifyId;
	private String voucherPriceRule;
	private String voucherCode;
	private double voucherValue;
	private double currentBalance;
	private Date createdDate;
	private Integer issuedBy;
	private String source;
	private boolean active;
	private Integer noUsage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVoucherShopifyId() {
		return voucherShopifyId;
	}
	public void setVoucherShopifyId(String voucherShopifyId) {
		this.voucherShopifyId = voucherShopifyId;
	}
	public String getVoucherPriceRule() {
		return voucherPriceRule;
	}
	public void setVoucherPriceRule(String voucherPriceRule) {
		this.voucherPriceRule = voucherPriceRule;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	public double getVoucherValue() {
		return voucherValue;
	}
	public void setVoucherValue(double voucherValue) {
		this.voucherValue = voucherValue;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(Integer issuedBy) {
		this.issuedBy = issuedBy;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Integer getNoUsage() {
		return noUsage;
	}
	public void setNoUsage(Integer noUsage) {
		this.noUsage = noUsage;
	}
	
	
}
