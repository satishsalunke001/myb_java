package com.rts.myb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_member_package_payment")
public class MyMemberPackagePayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Integer id;
	@Column(name="order_id", nullable = false)
	private Integer orderId;
	@Column(name="refer_id", nullable = false)
	private String referId;
	@Column(name="payment_type", nullable = false)
	private String paymentType;
	@Column(name="amount", nullable = false)
	private double amount;
	@Column(name="payment_mode", nullable = false)
	private String paymentMode;
	@Column(name="mode_type", nullable = false)
	private Integer modeType;
	@Column(name="transaction_id", nullable = false)
	private String transactionId;
	@Column(name="cheque_no", nullable = false)
	private String chequeNo;
	@Column(name="bank_name", nullable = false)
	private String bankName;
	@Column(name="date_entered", nullable = false)
	private Date dateEntered;
	@Column(name="date_modified", nullable = false)
	private Date dateModified;
	@Column(name="description", nullable = false)
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getReferId() {
		return referId;
	}
	public void setReferId(String referId) {
		this.referId = referId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Integer getModeType() {
		return modeType;
	}
	public void setModeType(Integer modeType) {
		this.modeType = modeType;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Date getDateEntered() {
		return dateEntered;
	}
	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
}
