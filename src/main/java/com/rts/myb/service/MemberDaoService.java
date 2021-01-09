package com.rts.myb.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.rts.myb.domain.MyMemberPackage;
import com.rts.myb.domain.MyRegistration;
import com.rts.myb.model.ActualPurchaseListModel;
import com.rts.myb.model.KycModel;
import com.rts.myb.model.MyMemberPackageDto;
import com.rts.myb.model.MyRegistrationDto;
import com.rts.myb.model.PowerLegListModel;
import com.rts.myb.repo.MyMemberPackageRepo;
import com.rts.myb.repo.MyRegistrationRepo;
import com.rts.myb.utils.CommonUtils;

@Component
public class MemberDaoService {

	@Autowired
	MyRegistrationRepo myRegistrationRepo;
	@Autowired
	MyMemberPackageRepo myMemberPackageRepo;
	@Autowired
	AWSS3ServiceImpl awsS3Servcice;
	@Value("${aws.s3.bucket.url}")
    private String awsS3Url;
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public MyRegistrationDto saveMemeber(MyRegistrationDto myRegistrationDto) throws ParseException {
		MyRegistration myRegistration = new MyRegistration();
		myRegistration.setId(UUID.randomUUID().toString());
		myRegistration.setName(myRegistrationDto.getName());
		myRegistration.setLastName(myRegistrationDto.getLastName());
		//myRegistration.setMotherName(myRegistrationDto.getMotherName());
		//myRegistration.setGender(myRegistrationDto.getGender());
		//Date dateOfBirth = format.parse(myRegistrationDto.getDob());
		//myRegistration.setDob( dateOfBirth);
		//myRegistration.setSponsorBy(myRegistrationDto.getSponsorBy());
		myRegistration.setSponsorId(myRegistrationDto.getSponsorId());
		//myRegistration.setLeftNode(myRegistrationDto.getLeftNode());
		//myRegistration.setRightNode(myRegistrationDto.getRightNode());
		//myRegistration.setCustomerId(myRegistrationDto.getCustomerId());
		myRegistration.setReferId(generateReferId());
		myRegistration.setPassword(myRegistrationDto.getPassword());
		
		//myRegistration.setTransactionPassword(myRegistrationDto.getTransactionPassword());
		//myRegistration.setCountryCode(myRegistrationDto.getCountryCode());
		myRegistration.setCountry(myRegistrationDto.getCountry());
		myRegistration.setCity(myRegistrationDto.getCity());
		myRegistration.setState(myRegistrationDto.getState());
		myRegistration.setMobileNumber(myRegistrationDto.getMobileNumber());
		myRegistration.setEmailAddress(myRegistrationDto.getEmailAddress());
//		myRegistration.setAddress1(myRegistrationDto.getAddress1());
//		myRegistration.setAddress2(myRegistrationDto.getAddress2());
		myRegistration.setZipCode(myRegistrationDto.getZipCode());
		myRegistration.setAccountType(myRegistrationDto.getAccountType());
		
		
		myRegistration.setDateEntered(new Date());
		myRegistration.setDateModified(new Date());
		
		
	
		//myRegistration.setSource(myRegistrationDto.getSource());
//		myRegistration.setAccountHolderName(myRegistrationDto.getAccountHolderName());
//		myRegistration.setAccountNumber(myRegistrationDto.getAccountNumber());
		myRegistration.setAccountType(myRegistrationDto.getAccountType());
		//myRegistration.setBankName(myRegistrationDto.getBankName());
		//myRegistration.setBranchName(myRegistrationDto.getBranchName());
		//myRegistration.setSwiftCode(myRegistrationDto.getSwiftCode());
		//myRegistration.setIfscCode(myRegistrationDto.getIfscCode());
		//myRegistration.setNomineeName(myRegistrationDto.getNomineeName());
		
		//myRegistration.setRelationNominee(myRegistrationDto.getRelationNominee());
		//myRegistration.setCompanyName(myRegistrationDto.getCompanyName());
		//myRegistration.setGstNo(myRegistrationDto.getGstNo());
		//myRegistration.setPan(myRegistrationDto.getPan());
		//myRegistration.setDocName(myRegistrationDto.getDocName());
		//myRegistration.setAddressProof(myRegistrationDto.getAddressProof());
		//myRegistration.setProofId(myRegistrationDto.getProofId());
		
		//myRegistration.setFrontCover(myRegistrationDto.getFrontCover());
		//myRegistration.setBackCover(myRegistrationDto.getBackCover());
		myRegistration.setAddress1(myRegistrationDto.getAddress1());
		myRegistration.setAddress2(myRegistrationDto.getAddress2());
	    MyRegistration savedMember = myRegistrationRepo.save(myRegistration);
	    myRegistrationDto.setId(savedMember.getId());
		
		//Work is remaining
		
		return myRegistrationDto;
		
	}
	
	
	public List<MyRegistrationDto> memberList(){
		List<MyRegistration> members = myRegistrationRepo.findAll();
		List<MyRegistrationDto> memberDtos = new ArrayList<MyRegistrationDto>();
		MyRegistrationDto memberDto;
		for(MyRegistration member : members) {
			memberDto = new MyRegistrationDto();
			memberDto.setName(member.getName());
			memberDto.setLastName(member.getLastName());
			memberDto.setEmailAddress(member.getEmailAddress());
			//set desired fields
			
			memberDtos.add(memberDto);
		}
		
		return memberDtos;
	}
	
	public MyRegistration getMemberById(String id) {
		Optional<MyRegistration> member = myRegistrationRepo.findById(id);
		if(!member.isPresent()) {
			return null;
		}
		return member.get();
	}
	
	public MyRegistration getMemberByReferId(Integer referId) {
		MyRegistration member = myRegistrationRepo.findByReferId(referId);
		if(member ==  null) {
			return null;
		}
		return member;
	}
	
    public MyRegistration getMemberByEmail(String emailAddress) {
		MyRegistration member = myRegistrationRepo.findByEmailAddress(emailAddress);
		return member;
	}
    
    public Integer generateReferId() {
    	Random random = new Random();
		boolean flag = true;
		String gen = "";
		while(flag) {
			gen = String.format("%09d", random.nextInt(1000000000));
			if(myRegistrationRepo.findByReferId(Integer.valueOf(gen)) == null) {
				flag = false;
				 break;
				 
			}
		}
		
		return Integer.valueOf(gen);
    }
	
	
//	public MyRegistration getMemberBySponsorId(Integer sponsorId) {
//		
//	}
	
	
	public MyRegistrationDto updateMemberDetails(MyRegistrationDto memberDto, String id) throws ParseException {
		MyRegistration myRegistration = getMemberByReferId(Integer.valueOf(id));
		if(myRegistration == null) {
			
		}
		
		myRegistration.setName(memberDto.getName());
		myRegistration.setLastName(memberDto.getLastName());
		myRegistration.setGender(memberDto.getGender());
		Date dateOfBirth = format.parse(memberDto.getDob());
		myRegistration.setDob( dateOfBirth);
		myRegistration.setMobileNumber(memberDto.getMobileNumber());
		myRegistration.setEmailAddress(memberDto.getEmailAddress());
		
//		myRegistration.setAddress1(memberDto.getAddress1());
//		myRegistration.setAddress2(memberDto.getAddress2());
//		myRegistration.setZipCode(memberDto.getZipCode());
//		myRegistration.setCountry(memberDto.getCountry());
//		myRegistration.setState(memberDto.getState());
//		myRegistration.setCity(memberDto.getCity());
//		
//		myRegistration.setAccountNumber(memberDto.getAccountNumber());
//		myRegistration.setBankName(memberDto.getBankName());
//		myRegistration.setSwiftCode(memberDto.getSwiftCode());
//		myRegistration.setIfscCode(memberDto.getIfscCode());
		myRegistration.setDateModified(new Date());
		 //set the require fields.
		//and update the member
		
		MyRegistration updatedMember = myRegistrationRepo.save(myRegistration);
		
		
		return memberDto;
	}
	
	
	public MyRegistrationDto updateMemberAddressDetails(MyRegistrationDto memberDto, Integer id) {
		MyRegistration myRegistration = getMemberByReferId(id);
		if(myRegistration == null) {
			
		}
		
		myRegistration.setAddress1(memberDto.getAddress1());
		myRegistration.setAddress2(memberDto.getAddress2());
		myRegistration.setZipCode(memberDto.getZipCode());
		myRegistration.setCity(memberDto.getCity());
		myRegistration.setState(memberDto.getState());
		myRegistration.setCountry(memberDto.getCountry());
		
		MyRegistration updatedMember = myRegistrationRepo.save(myRegistration);
		
		
		return memberDto;
	}
	
	public MyRegistrationDto updateMemberBankDetails(MyRegistrationDto memberDto, String id) {
		MyRegistration myRegistration = getMemberByReferId(Integer.valueOf(id));
		if(myRegistration == null) {
			
		}
		
		myRegistration.setAccountNumber(memberDto.getAccountNumber());
		myRegistration.setBankName(memberDto.getBankName());
		myRegistration.setSwiftCode(memberDto.getSwiftCode());
		myRegistration.setIfscCode(memberDto.getIfscCode());
		
        MyRegistration updatedMember = myRegistrationRepo.save(myRegistration);
		
		
		return memberDto;
	}
	
	
	public MyRegistrationDto updateMemberPassword(MyRegistrationDto memberDto, String id) {
		MyRegistration myRegistration = getMemberByReferId(Integer.valueOf(id)); 
		if(myRegistration == null) {
			
		}
		
		myRegistration.setPassword(memberDto.getPassword());
		
        MyRegistration updatedMember = myRegistrationRepo.save(myRegistration);
		
		
        
		return memberDto;
	}
	
	
	public MyRegistrationDto updateMemberTransPassword(MyRegistrationDto memberDto, String id) {
		MyRegistration myRegistration = getMemberByReferId(Integer.valueOf(id));
		if(myRegistration == null) {
			
		}
		
		myRegistration.setTransactionPassword(memberDto.getTransactionPassword());
		
        MyRegistration updatedMember = myRegistrationRepo.save(myRegistration);
		
		
		return memberDto;
	}
	
	
	public List<PowerLegListModel> powerLegList(){
		List<MyRegistration> memberObjectlist = myRegistrationRepo.findAll();
		List<PowerLegListModel> powerLegs = new ArrayList<PowerLegListModel>();
		PowerLegListModel powerLegModel;
		MyMemberPackage myMemberPackageObj;
		for(MyRegistration myReg : memberObjectlist) {
			if(myReg.getReferId()!=null) {
				myMemberPackageObj = myMemberPackageRepo.findByReferId(String.valueOf(myReg.getReferId()));
				if(myMemberPackageObj!=null && myMemberPackageObj.isPowerLeg() == true && myMemberPackageObj.isDeleted() == false) {
					powerLegModel = new PowerLegListModel();
					powerLegModel.setPurchaseDate(String.valueOf(myMemberPackageObj.getDateEntered()));
					powerLegModel.setTotalPv(String.valueOf(myMemberPackageObj.getTotalPv()));
					powerLegModel.setName(myReg.getName()+" "+myReg.getLastName());
					powerLegModel.setMemberId(myReg.getId());
					powerLegs.add(powerLegModel);
				}
				
			}
			
		}
		
		return powerLegs;
	}
	
	
	
	
	
	public List<ActualPurchaseListModel> actualPurchaseList(){
		List<MyRegistration> memberObjectlist = myRegistrationRepo.findAll();
		List<ActualPurchaseListModel> actualPurchases = new ArrayList<ActualPurchaseListModel>();
		ActualPurchaseListModel actualPurchaseModel;
		MyMemberPackage myMemberPackageObj;
		for(MyRegistration myReg : memberObjectlist) {
			if(myReg.getReferId()!=null) {
				myMemberPackageObj = myMemberPackageRepo.findByReferId(String.valueOf(myReg.getReferId()));
				if(myMemberPackageObj!=null && myMemberPackageObj.isPowerLeg() == false && myMemberPackageObj.isDeleted() == false) {
					actualPurchaseModel = new ActualPurchaseListModel();
					actualPurchaseModel.setPurchaseDate(String.valueOf(myMemberPackageObj.getDateEntered()));
					actualPurchaseModel.setMemberId(myReg.getId());
					actualPurchaseModel.setMemberName(myReg.getName()+" "+myReg.getLastName());
					actualPurchaseModel.setProductName(myMemberPackageObj.getName());
					actualPurchaseModel.setProductPrice(String.valueOf(myMemberPackageObj.getProductPrice()));
					actualPurchaseModel.setPurchaseDate(String.valueOf(myMemberPackageObj.getDateEntered()));
					actualPurchaseModel.setTotalPaid(String.valueOf(myMemberPackageObj.getTotalPaid()));
					actualPurchaseModel.setTotalPV(String.valueOf(myMemberPackageObj.getTotalPv()));
					actualPurchaseModel.setOrderNo(myMemberPackageObj.getOrderId());
					actualPurchases.add(actualPurchaseModel);
				}
				
			}
			
		}
		
		return actualPurchases;
		
	}
	
	public Map<String,Object> processKycDetails(MyRegistration member, KycModel kycDetails, MultipartFile panDoc, MultipartFile frontDoc, MultipartFile backDoc) throws Exception{
		member.setPan(kycDetails.getPanNo());
		member.setAddressProof(kycDetails.getAddressProof());
		member.setProofId(kycDetails.getAddressProofInfo());
		member.setAccountType(Integer.valueOf(kycDetails.getAccounType()));
		
		if(backDoc != null) {
			String backDocName = CommonUtils.reNameImage(backDoc, "back");
			awsS3Servcice.uploadFileToS3Bucket(backDoc, true, backDocName);
			member.setBackCover(backDocName);
		}
		
		if(panDoc!=null) {
			String panDocName = CommonUtils.reNameImage(panDoc, "pan");
			awsS3Servcice.uploadFileToS3Bucket(backDoc, true, panDocName);
			member.setDocName(panDocName);
		}
		
		
		if(frontDoc!=null) {
			String frontDocName = CommonUtils.reNameImage(panDoc, "front");
			awsS3Servcice.uploadFileToS3Bucket(frontDoc, true, frontDocName);
			member.setFrontCover(frontDocName);
		}
		
		member.setPhotoPath(awsS3Url);
		member.setDateModified(new Date());
		MyRegistration savedMember = myRegistrationRepo.save(member);
		if(savedMember == null) {
			throw new Exception("An error occured while updating kyc details.");
		}
		
		Map<String,Object> mapper = new HashMap<String,Object>();
		mapper.put("statusDetail", "Kyc Details updated");
		mapper.put("Success", true);
		
		return mapper;
		
		
	}
	
	public MyMemberPackageDto makePurchase(MyMemberPackageDto memberPackage) {
		MyMemberPackage myMemberPackage = new MyMemberPackage();
		myMemberPackage.setName(memberPackage.getName());
		myMemberPackage.setReferId(memberPackage.getReferId());
		myMemberPackage.setProductId(memberPackage.getProductId());
		myMemberPackage.setCustomerId(memberPackage.getCustomerId());
		myMemberPackage.setProductPrice(memberPackage.getProductPrice());
		myMemberPackage.setTotalPv(memberPackage.getPv());
		myMemberPackage.setOrderId(memberPackage.getOrderId());
		myMemberPackage.setPowerLeg(true);
		myMemberPackage.setDateEntered(new Date());
		myMemberPackage.setDateModified(new Date());
		myMemberPackage.setUserAdd(0);
		myMemberPackage.setPaidByBbT(0);
		myMemberPackage.setPaidByVoucher(0);
		myMemberPackage.setPaidByCash(0);
		myMemberPackage.setPaidByCash(0);
		myMemberPackage.setVoucherCode("0");
		myMemberPackage.setTotalTax(0);
		myMemberPackage.setPaymentMode(3);
		myMemberPackage.setAddPosition(false);
		//myMemberPackage.setKaptureOrderId(memberPackage.getKaptureOrderId());
		myMemberPackage.setEmi(false);
		myMemberPackage.setQty(1);
		myMemberPackage.setUploadVolume(1);
		myMemberPackage.setPaymentStatus(1);
		
		MyMemberPackage memberPackageSaved = myMemberPackageRepo.save(myMemberPackage);
		memberPackage.setId(memberPackageSaved.getId());
		
		return memberPackage;
		
	}
	
	
	public MyRegistration updateMember(MyRegistration memberObj) {
		return myRegistrationRepo.save(memberObj);
	}
	
    public List<MyRegistration> getActiveInactiveMembers(Integer isActive) {
    	List<MyRegistration> members = myRegistrationRepo.getActInActMembers(isActive);
    	return members;
    }
	
    
    public List<com.rts.myb.repo.MyRegistrationRepo.PaidUnPaidListModel> getPaidUnPaidMembers(Integer isPaid) throws Exception{
    	List<com.rts.myb.repo.MyRegistrationRepo.PaidUnPaidListModel> paidMembers = new ArrayList<com.rts.myb.repo.MyRegistrationRepo.PaidUnPaidListModel>();
    	switch(isPaid) {
    	case 1:
    		paidMembers = myRegistrationRepo.paidMemberList();
    		break;
    		
    	case 0:
    		paidMembers = myRegistrationRepo.unPaidMemberList();
    		break;
    			default:
    				throw new Exception("Invalid selection");
    	}
    	
    	return paidMembers;
    }
	
    
    public List<MyRegistration> getAbsentKycList(){
    	List<MyRegistration> absentKycList = myRegistrationRepo.getAbsentKycList();
    	return absentKycList;
    }
    
    public List<MyRegistration> get306090DayList(String days) throws Exception{
    	List<MyRegistration> thirtySixtyNinetyList = new ArrayList<MyRegistration>();
    	switch(days) {
    	case "30":
    		thirtySixtyNinetyList = myRegistrationRepo.thirtyDayInActiveMemberList();
    		break;
    		
    	case "60":
    		thirtySixtyNinetyList =  myRegistrationRepo.sixtyDayInActiveMemberList();
    		break;
    		
    	case "90":
    		thirtySixtyNinetyList = myRegistrationRepo.ninetyDayInActiveMemberList();
    		break;
    		default:
    			throw new Exception("Invalid selection");
    	}
    	
    	return thirtySixtyNinetyList;
    }
    
    
    public List<MyRegistration> getTransferIdsList(){
    	List<MyRegistration> transIdsList = myRegistrationRepo.getTransferIdsList();
    	return transIdsList;
    }
    
    public List<MyRegistration> getLeaderList(){
    	List<MyRegistration> leaderList = myRegistrationRepo.getLeaderList();
    	return leaderList;
    }
    
    public MyRegistrationDto updateLeader(MyRegistrationDto memberDto, MyRegistration member) {
    	member.setPayoutPerce(memberDto.getPayoutPerce());
    	member.setIsLeader(1);
    	myRegistrationRepo.save(member);
    	memberDto.setReferId(member.getReferId());
    	return memberDto;
    }
    
    public MyRegistration updateActiveStatus(Integer referId) throws Exception {
    	MyRegistration member = myRegistrationRepo.findByReferId(referId);
    	if(member == null) {
    		throw new Exception("Invalid refer id");
    	}
    	
    	if(member.getInvalid() == 0) {
    		member.setInvalid(1);
    	}else {
    		member.setInvalid(0);
    	}
    	
    	return myRegistrationRepo.save(member);
    }
    
}
