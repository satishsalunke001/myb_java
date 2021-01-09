package com.rts.myb.model;

public class KycModel {

	private String memberId;
	private String refeId;
	private String customerId;
	private String companyName;
	private String panNo;
	private String addressProof;
	private String addressProofInfo;
	private String accounType;
	private String docName;
	private String frontDoc;
	private String backDoc;
	
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getFrontDoc() {
		return frontDoc;
	}
	public void setFrontDoc(String frontDoc) {
		this.frontDoc = frontDoc;
	}
	public String getBackDoc() {
		return backDoc;
	}
	public void setBackDoc(String backDoc) {
		this.backDoc = backDoc;
	}
	public String getAccounType() {
		return accounType;
	}
	public void setAccounType(String accounType) {
		this.accounType = accounType;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRefeId() {
		return refeId;
	}
	
	public void setRefeId(String refeId) {
		
		this.refeId = refeId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getAddressProof() {
		return addressProof;
	}
	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}
	public String getAddressProofInfo() {
		return addressProofInfo;
	}
	public void setAddressProofInfo(String addressProofInfo) {
		this.addressProofInfo = addressProofInfo;
	}
}
