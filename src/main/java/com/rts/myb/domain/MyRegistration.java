package com.rts.myb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_registration")
public class MyRegistration {

	@Id
	@Column(name="id", length = 100)
	private String id;
	private String name;
	private String lastName;
	private String motherName;
	private String gender;
	private Date dob;
	private Integer sponsorBy;
	private Integer sponsorId;
	private Integer leftNode;
	private Integer rightNode;
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
	private boolean deleted = false;
	private Integer updateEmail = 0;
	private Integer assignedUserId = 0;
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
	private Integer verified = 0;
	private Integer powerLeg = 0;
	private String ipAddress;
	private Date lastLoginDateTime;
	private Integer invalid = 0;
	private String captureCustomerId;
	private Integer isPaid = 0;
	private Integer virtualSale = 0;
	private Integer isFreezed = 0;
	private Integer isTransfer = 0;
	private Integer isLeader = 0;
    private double payoutPerce;
    private String photoPath;
    private Integer disclaimer = 0;
    private String otp;
    private Integer otpVerified = 0;
    private String distributorId;
    private String distributor;
	public String getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
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
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Integer getUpdateEmail() {
		return updateEmail;
	}
	public void setUpdateEmail(Integer updateEmail) {
		this.updateEmail = updateEmail;
	}
	public Integer getAssignedUserId() {
		return assignedUserId;
	}
	public void setAssignedUserId(Integer assignedUserId) {
		this.assignedUserId = assignedUserId;
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
	public Integer getVerified() {
		return verified;
	}
	public void setVerified(Integer verified) {
		this.verified = verified;
	}
	public Integer getPowerLeg() {
		return powerLeg;
	}
	public void setPowerLeg(Integer powerLeg) {
		this.powerLeg = powerLeg;
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
	public Integer getInvalid() {
		return invalid;
	}
	public void setInvalid(Integer invalid) {
		this.invalid = invalid;
	}
	public String getCaptureCustomerId() {
		return captureCustomerId;
	}
	public void setCaptureCustomerId(String captureCustomerId) {
		this.captureCustomerId = captureCustomerId;
	}
	public Integer getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(Integer isPaid) {
		this.isPaid = isPaid;
	}
	public Integer getVirtualSale() {
		return virtualSale;
	}
	public void setVirtualSale(Integer virtualSale) {
		this.virtualSale = virtualSale;
	}
	public Integer getIsFreezed() {
		return isFreezed;
	}
	public void setIsFreezed(Integer isFreezed) {
		this.isFreezed = isFreezed;
	}
	public Integer getIsTransfer() {
		return isTransfer;
	}
	public void setIsTransfer(Integer isTransfer) {
		this.isTransfer = isTransfer;
	}
	public Integer getIsLeader() {
		return isLeader;
	}
	public void setIsLeader(Integer isLeader) {
		this.isLeader = isLeader;
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
	public Integer getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(Integer disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Integer getOtpVerified() {
		return otpVerified;
	}
	public void setOtpVerified(Integer otpVerified) {
		this.otpVerified = otpVerified;
	}
    
    
    
	
	 
	
	
}
