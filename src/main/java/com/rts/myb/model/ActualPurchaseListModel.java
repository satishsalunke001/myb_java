package com.rts.myb.model;

public class ActualPurchaseListModel {
	private String MemberName;
	private String MemberId;
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public String getPurchaseDate() {
		return PurchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		PurchaseDate = purchaseDate;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public String getTotalPV() {
		return TotalPV;
	}
	public void setTotalPV(String totalPV) {
		TotalPV = totalPV;
	}
	public String getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(String productPrice) {
		ProductPrice = productPrice;
	}
	public String getTotalPaid() {
		return TotalPaid;
	}
	public void setTotalPaid(String totalPaid) {
		TotalPaid = totalPaid;
	}
	private String PurchaseDate;
	private String ProductName;
	private String OrderNo;
	private String TotalPV;
	private String ProductPrice;
	private String TotalPaid;
}
