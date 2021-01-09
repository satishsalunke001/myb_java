package com.rts.myb.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MyRegistrationDto extends BaseDto {

	private String id;
	private String name;
	private String lastName;
	private String motherName;
	private String gender;
	private String dob;
	private Integer sponsorBy;
	private Integer sponsorId;
	private Integer leftNode;
	private Integer rightNode;
	private Integer leg;
	private String customerId;
	private Integer referId;
	private String password;
	private String transactionPassword;
	private String countryCode;
	private String country;
	private String accountNumber;
	private String companyName;
	private String emailAddress;
	private String mobileNumber;
	private String address1;
	private String address2;
	private String city;
	private String zipCode;
	private String state;
	private Date dateEntered;
	private Date dateModified;
	private String source;
	private String accountHolderName;
	private String bankName;
	private String branchName;
	private String swiftCode;
	private String ifscCode;
	private String nomineeName;
	private String relationNominee;
	private int accountType;
	private String gstNo;
	private String pan;
	private String docName;
	private String addressProof;
	private String proofId;
	private String frontCover;
	private String backCover;
	private String ipAddress;
	private Date lastLoginDateTime;
	private String captureCustomerId;
    private double payoutPerce;
    private String photoPath;
    private String otp;
    
	public Integer getLeg() {
		return leg;
	}
	public void setLeg(Integer leg) {
		this.leg = leg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Integer getSponsorBy() {
		return sponsorBy;
	}
	public void setSponsorBy(Integer sponsorBy) {
		this.sponsorBy = sponsorBy;
	}
	public Integer getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}
	public Integer getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Integer leftNode) {
		this.leftNode = leftNode;
	}
	public Integer getRightNode() {
		return rightNode;
	}
	public void setRightNode(Integer rightNode) {
		this.rightNode = rightNode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Integer getReferId() {
		return referId;
	}
	public void setReferId(Integer referId) {
		this.referId = referId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTransactionPassword() {
		return transactionPassword;
	}
	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getSwiftCode() {
		return swiftCode;
	}
	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getNomineeName() {
		return nomineeName;
	}
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}
	public String getRelationNominee() {
		return relationNominee;
	}
	public void setRelationNominee(String relationNominee) {
		this.relationNominee = relationNominee;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getAddressProof() {
		return addressProof;
	}
	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}
	public String getProofId() {
		return proofId;
	}
	public void setProofId(String proofId) {
		this.proofId = proofId;
	}
	public String getFrontCover() {
		return frontCover;
	}
	public void setFrontCover(String frontCover) {
		this.frontCover = frontCover;
	}
	public String getBackCover() {
		return backCover;
	}
	public void setBackCover(String backCover) {
		this.backCover = backCover;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Date getLastLoginDateTime() {
		return lastLoginDateTime;
	}
	public void setLastLoginDateTime(Date lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}
	public String getCaptureCustomerId() {
		return captureCustomerId;
	}
	public void setCaptureCustomerId(String captureCustomerId) {
		this.captureCustomerId = captureCustomerId;
	}
	public double getPayoutPerce() {
		return payoutPerce;
	}
	public void setPayoutPerce(double payoutPerce) {
		this.payoutPerce = payoutPerce;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
  
    
	
}
