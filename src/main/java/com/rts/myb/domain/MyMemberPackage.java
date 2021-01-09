package com.rts.myb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_member_package")
public class MyMemberPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int id;
	@Column(name="name", nullable = true)
	private String name;
	@Column(name="refer_id", nullable = true)
	private String referId;
	
	@Column(name="date_entered", nullable = true)
	private Date dateEntered;
	@Column(name="date_modified", nullable = true)
	private Date dateModified;
	
	
	@Column(name="customer_id", nullable = true)
	private String customerId;
	@Column(name="deleted", nullable = true)
	private boolean deleted = false;
	@Column(name="product_id", nullable = true)
	private String productId;
	@Column(name="product_price", nullable = true)
	private double productPrice;
	@Column(name="qty", nullable = false)
	private int qty;
	@Column(name="pv", nullable = false)
	private double pv;
	@Column(name="total_pv", nullable = true)
	private double totalPv;
	@Column(name="paid_by_online", nullable = true)
	private double paidByOnline;
	@Column(name="order_id", nullable = false)
	private String orderId;
	@Column(name="online_transaction_id", nullable = true)
	private String onlineTransactionId;
	@Column(name="paid_by_voucher", nullable = true)
	private double paidByVoucher;
	@Column(name="voucher_code", nullable = true)
	private String voucherCode;
	@Column(name="paid_by_deposit", nullable = false)
	private double paidByDeposit;
	@Column(name="paid_by_cash", nullable = false)
	private double paidByCash;
	@Column(name="paid_by_bbT", nullable = false)
	private double paidByBbT;
	@Column(name="total_tax", nullable = false)
	private double totalTax;
	@Column(name="total_paid", nullable = false)
	private double totalPaid;
	@Column(name="user_add", nullable = true)
	private int userAdd;
	@Column(name="payment_mode", nullable = true)
	private int paymentMode;
	@Column(name="payment_status", nullable = false)
	private int paymentStatus;
	@Column(name="upload_volume", nullable = true)
	private int uploadVolume;
	@Column(name="add_position", nullable = false)
	private boolean addPosition;
	@Column(name="emi", nullable = false)
	private boolean emi;
	@Column(name="power_leg", nullable = false)
	private boolean powerLeg;
	@Column(name="re_purchase", nullable = false)
	private boolean rePurchase;
	@Column(name="deposit_slip", nullable = true)
	private String depositSlip;
	@Column(name="tracking_num", nullable = true)
	private String trackingNum;
	@Column(name="kapture_order_id", nullable = true)
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
	
	
}
