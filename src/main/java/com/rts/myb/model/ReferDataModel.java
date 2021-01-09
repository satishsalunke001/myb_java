package com.rts.myb.model;

public class ReferDataModel {

	private Integer referId;
	private Boolean isPaid;
	private String unPaidReason = "";
	public Integer getReferId() {
		return referId;
	}
	public void setReferId(Integer referId) {
		this.referId = referId;
	}
	public Boolean getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}
	public String getUnPaidReason() {
		return unPaidReason;
	}
	public void setUnPaidReason(String unPaidReason) {
		this.unPaidReason = unPaidReason;
	}
	
}
