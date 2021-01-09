package com.rts.myb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="my_order")
public class MyOrder {

	
	@Id
	@Column(name="id", length = 100)
	private String id;
	private byte orderType;
	private String referId;
	private String customerId;
	private Date dateEntered;
	private byte noOfItems;
	private byte totalQuantity;
	private double totalPrice;
	private String discountCode;
	private double discountAmount;
	private double subTotalPrice;
	private double totalTax;
	private double shipping;
	private double totalAmount;
	private boolean deleted;
	private boolean status;
	@Lob
	@Column(name="shopify_data", length=512)
	private String shopifyData;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte getOrderType() {
		return orderType;
	}
	public void setOrderType(byte orderType) {
		this.orderType = orderType;
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
	public Date getDateEntered() {
		return dateEntered;
	}
	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
	}
	public byte getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(byte noOfItems) {
		this.noOfItems = noOfItems;
	}
	public byte getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(byte totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public double getSubTotalPrice() {
		return subTotalPrice;
	}
	public void setSubTotalPrice(double subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}
	public double getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}
	public double getShipping() {
		return shipping;
	}
	public void setShipping(double shipping) {
		this.shipping = shipping;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getShopifyData() {
		return shopifyData;
	}
	public void setShopifyData(String shopifyData) {
		this.shopifyData = shopifyData;
	}
	
	
}
