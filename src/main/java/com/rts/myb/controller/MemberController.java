package com.rts.myb.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rts.myb.domain.MyRegistration;
import com.rts.myb.model.ActualPurchaseListModel;
import com.rts.myb.model.MyMemberPackageDto;
import com.rts.myb.model.MyRegistrationDto;
import com.rts.myb.service.MemberDaoService;



@RestController
@RequestMapping("/api")
public class MemberController {

	@Autowired
	MemberDaoService myRegService;
	
	@PostMapping("/saveMember") //new API for member registration 22-12-2020
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<MyRegistrationDto> registerUser(@Valid @RequestBody MyRegistrationDto myRegistrationDto) throws Exception {
		if (myRegistrationDto.getName() == null || myRegistrationDto.getName().isEmpty()) {
           throw new Exception("Name cannot be blank");
		}

		if (myRegistrationDto.getLastName() == null || myRegistrationDto.getLastName().isEmpty()) {

			throw new Exception("Last name cannot be blank");
		}

		if (myRegistrationDto.getEmailAddress() == null || myRegistrationDto.getEmailAddress().isEmpty()) {

			throw new Exception("Email cannot be blank");
		}
		
		if(myRegService.getMemberByEmail(myRegistrationDto.getEmailAddress()) != null) {
			
			throw new Exception("Member already registered with this email Id");
		}

		if (myRegistrationDto.getMobileNumber() == null || myRegistrationDto.getMobileNumber().isEmpty()) {

			throw new Exception("Mobile number cannot be blank");
		}
		if (myRegistrationDto.getAddress1() == null || myRegistrationDto.getAddress1().isEmpty()) {

			throw new Exception("Address 1 cannot be blank");
		}
		if (myRegistrationDto.getAddress2() == null || myRegistrationDto.getAddress2().isEmpty()) {

			throw new Exception("Address 2 cannot be blank");
		}
		if (myRegistrationDto.getZipCode() == null || myRegistrationDto.getZipCode().isEmpty()) {

			throw new Exception("Mobile number cannot be blank");
		}
		if (myRegistrationDto.getCountry() == null || myRegistrationDto.getCountry().isEmpty()) {

			throw new Exception("Country code cannot be blank");
		}
		if (myRegistrationDto.getCity() == null || myRegistrationDto.getCity().isEmpty()) {

			throw new Exception("City cannot be blank");
		}
		if (myRegistrationDto.getSponsorId() == null) {

			throw new Exception("Sponsor id cannot be blank");
		}
		
		if(myRegService.getMemberByReferId(myRegistrationDto.getSponsorId()) ==  null) {
			
			throw new Exception("Invalid Sponsor Id");
		}
		if (myRegistrationDto.getAccountType() == 0) {

			throw new Exception("Account either should be 1 or 2");
		}
		if (myRegistrationDto.getLeg() == 0) {

			throw new Exception("Kindly provide either leg");
		}
		if (myRegistrationDto.getPassword() == null || myRegistrationDto.getPassword().isEmpty()) {

			throw new Exception("Password cannot be blank");
		}
	
		
		myRegistrationDto = myRegService.saveMemeber(myRegistrationDto);
		myRegistrationDto.setStatusDetail("Member registered");
		myRegistrationDto.setSuccess(true);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(myRegistrationDto);
	}
	
	
	@GetMapping("member/memberDetailByReferIdId/{id}")
	public ResponseEntity<MyRegistrationDto> getMemberDetailByReferId(@PathVariable Integer id) throws Exception {
		MyRegistration member = myRegService.getMemberByReferId(id);
		if(member == null) {
			throw new Exception("Memeber with refer id " +id+" not found");
		}
		
		MyRegistrationDto memberDto = new MyRegistrationDto();
		memberDto.setName(member.getName());
		memberDto.setLastName(member.getLastName());
		memberDto.setEmailAddress(member.getEmailAddress());
		memberDto.setSponsorBy(member.getSponsorBy());
		memberDto.setSponsorId(member.getSponsorId());
		memberDto.setAccountType(member.getAccountType());
		memberDto.setAccountHolderName(member.getAccountHolderName());
		memberDto.setAccountNumber(member.getAccountNumber());
		memberDto.setAddress1(member.getAddress1());
		memberDto.setAddress2(member.getAddress2());
		memberDto.setAddressProof(member.getAddressProof());
		
		memberDto.setBackCover(member.getBackCover());
		memberDto.setBankName(member.getBankName());
		memberDto.setBranchName(member.getBranchName());
		memberDto.setCaptureCustomerId(member.getCaptureCustomerId());
		memberDto.setCity(member.getCity());
		memberDto.setCompanyName(member.getCompanyName());
		memberDto.setCountry(member.getCountry());
		memberDto.setCountryCode(member.getCountryCode());
		memberDto.setZipCode(member.getZipCode());
		memberDto.setTransactionPassword(member.getTransactionPassword());
		memberDto.setSwiftCode(member.getSwiftCode());
		memberDto.setState(member.getState());
		memberDto.setSource(member.getSource());
		memberDto.setRightNode(member.getRightNode());
		memberDto.setRelationNominee(member.getRelationNominee());
		memberDto.setReferId(member.getReferId());
		memberDto.setProofId(member.getProofId());
	
		memberDto.setPhotoPath(member.getPhotoPath());
		memberDto.setPayoutPerce(member.getPayoutPerce());
		memberDto.setPassword(member.getPassword());
		memberDto.setPan(member.getPan());
		
		memberDto.setCreatedOn(member.getDateEntered());
		memberDto.setDateEntered(member.getDateEntered());
		memberDto.setNomineeName(member.getNomineeName());
		memberDto.setMotherName(member.getMotherName());
		
		
		
		//More details
		
		
		
		
		memberDto.setStatusDetail("Member found");
		memberDto.setSuccess(true);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(memberDto);
	}
	
	    @PostMapping("member/makePurchase")
		public ResponseEntity<Map<String,Object>> getActualPurchases(@Valid @RequestBody MyMemberPackageDto myMemPackageDto) throws Exception{
		   	
		 if(myMemPackageDto.getReferId() == null || myMemPackageDto.getReferId().isEmpty()) {
			 throw new Exception("ReferId is missing");
		 }
		 
		 if(myMemPackageDto.getCustomerId() == null || myMemPackageDto.getCustomerId().isEmpty()) {
			 throw new Exception("Customer id is missing");
		 }
		 
		 if(myMemPackageDto.getProductId() == null || myMemPackageDto.getProductId().isEmpty()) {
			 throw new Exception("Product id is missing");
		 }
		 
		 if(myMemPackageDto.getName() == null || myMemPackageDto.getName().isEmpty()) {
			 throw new Exception("Name is missing");
		 }
		 
		 if(myMemPackageDto.getOrderId() == null || myMemPackageDto.getOrderId().isEmpty()) {
			 throw new Exception("Order id is missing");
		 }
		 
		 
		 
		    MyMemberPackageDto myMemDtoSaved = myRegService.makePurchase(myMemPackageDto);
		 
			Map<String,Object> response = new HashMap<String,Object>();
			response.put("status", myMemDtoSaved!=null?"Purchase successfull":"Error in making the purchase");
			response.put("success", myMemDtoSaved!=null?true:false);
			
			return ok(response);
		}
	
	

}
