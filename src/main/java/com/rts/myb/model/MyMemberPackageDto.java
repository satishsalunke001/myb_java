package com.rts.myb.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MyMemberPackageDto {

	private int id;
	private String name;
	private String referId;
	private Date dateEntered;
	private Date dateModified;
	private String customerId;
	private boolean deleted = false;
	private String productId;
	private double productPrice;
	private int qty;
	private double pv;
	private double totalPv;
	private double paidByOnline;
	private String orderId;
	private String onlineTransactionId;
	private double paidByVoucher;
	private String voucherCode;
	private double paidByDeposit;
	private double paidByCash;
	private double paidByBbT;
	private double totalTax;
	private double totalPaid;
	private int userAdd;
	private int paymentMode;
	private int paymentStatus;
	private int uploadVolume;
	private boolean addPosition;
	private boolean emi;
	private boolean powerLeg;
	private boolean rePurchase;
	private String depositSlip;
	private String trackingNum;
	private String kaptureOrderId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReferId() {
		return referId;
	}
	public void setReferId(String referId) {
		this.referId = referId;
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPv() {
		return pv;
	}
	public void setPv(double pv) {
		this.pv = pv;
	}
	public double getTotalPv() {
		return totalPv;
	}
	public void setTotalPv(double totalPv) {
		this.totalPv = totalPv;
	}
	public double getPaidByOnline() {
		return paidByOnline;
	}
	public void setPaidByOnline(double paidByOnline) {
		this.paidByOnline = paidByOnline;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOnlineTransactionId() {
		return onlineTransactionId;
	}
	public void setOnlineTransactionId(String onlineTransactionId) {
		this.onlineTransactionId = onlineTransactionId;
	}
	public double getPaidByVoucher() {
		return paidByVoucher;
	}
	public void setPaidByVoucher(double paidByVoucher) {
		this.paidByVoucher = paidByVoucher;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	public double getPaidByDeposit() {
		return paidByDeposit;
	}
	public void setPaidByDeposit(double paidByDeposit) {
		this.paidByDeposit = paidByDeposit;
	}
	public double getPaidByCash() {
		return paidByCash;
	}
	public void setPaidByCash(double paidByCash) {
		this.paidByCash = paidByCash;
	}
	public double getPaidByBbT() {
		return paidByBbT;
	}
	public void setPaidByBbT(double paidByBbT) {
		this.paidByBbT = paidByBbT;
	}
	public double getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}
	public double getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}
	public int getUserAdd() {
		return userAdd;
	}
	public void setUserAdd(int userAdd) {
		this.userAdd = userAdd;
	}
	public int getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(int paymentMode) {
		this.paymentMode = paymentMode;
	}
	public int getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getUploadVolume() {
		return uploadVolume;
	}
	public void setUploadVolume(int uploadVolume) {
		this.uploadVolume = uploadVolume;
	}
	public boolean isAddPosition() {
		return addPosition;
	}
	public void setAddPosition(boolean addPosition) {
		this.addPosition = addPosition;
	}
	public boolean isEmi() {
		return emi;
	}
	public void setEmi(boolean emi) {
		this.emi = emi;
	}
	public boolean isPowerLeg() {
		return powerLeg;
	}
	public void setPowerLeg(boolean powerLeg) {
		this.powerLeg = powerLeg;
	}
	public boolean isRePurchase() {
		return rePurchase;
	}
	public void setRePurchase(boolean rePurchase) {
		this.rePurchase = rePurchase;
	}
	public String getDepositSlip() {
		return depositSlip;
	}
	public void setDepositSlip(String depositSlip) {
		this.depositSlip = depositSlip;
	}
	public String getTrackingNum() {
		return trackingNum;
	}
	public void setTrackingNum(String trackingNum) {
		this.trackingNum = trackingNum;
	}
	public String getKaptureOrderId() {
		return kaptureOrderId;
	}
	public void setKaptureOrderId(String kaptureOrderId) {
		this.kaptureOrderId = kaptureOrderId;
	}
	
}
