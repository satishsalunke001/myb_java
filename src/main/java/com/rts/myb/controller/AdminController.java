package com.rts.myb.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rts.myb.domain.MyPayoutRun;
import com.rts.myb.domain.MyRegistration;
import com.rts.myb.model.ActualPurchaseListModel;
import com.rts.myb.model.KycModel;
import com.rts.myb.model.MyPayOutRunDto;
import com.rts.myb.model.MyRegistrationDto;
import com.rts.myb.model.MyRoleDto;
import com.rts.myb.model.PayOutModel;
import com.rts.myb.model.PowerLegListModel;
import com.rts.myb.repo.MyRegistrationRepo;
import com.rts.myb.service.AWSS3ServiceImpl;
import com.rts.myb.service.AdminDaoService;
import com.rts.myb.service.MemberDaoService;
import com.rts.myb.service.PayOutDailyService;
import com.rts.myb.utils.CommonUtils;
import com.rts.myb.utils.Constants;

@RestController
@RequestMapping("/api/")
public class AdminController {

	@Autowired
	AdminDaoService adminService;
	@Autowired
	MemberDaoService memberService;
	@Autowired
	PayOutDailyService payService;
	@Autowired
	MyRegistrationRepo myRegistrationRepo;
	@Autowired
	private AWSS3ServiceImpl service;

	@PostMapping("admin/createRole")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<MyRoleDto> createRole(@Valid @RequestBody MyRoleDto myRoleDto) throws Exception {
		if (myRoleDto.getRole() == null || myRoleDto.getRole().isEmpty()) {
			throw new Exception("Role cannot be black");
		}

		MyRoleDto savedMyRole = adminService.createRole(myRoleDto);

		savedMyRole.setStatusDetail("Role");
		savedMyRole.setSuccess(true);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedMyRole);

	}

	@GetMapping("admin/memberList")
	public ResponseEntity<Map<String, Object>> getAllMembers() {
		List<MyRegistrationDto> members = memberService.memberList();
		Map<String, Object> model = new HashMap<>();
		model.put("StatusDetails", members.size() + " members found");
		model.put("Success", "true");
		model.put("members", members);

		return ok(model);

	}

	@GetMapping("admin/memberDetailById/{id}")
	public ResponseEntity<MyRegistrationDto> getMemberDetailById(@PathVariable String id) throws Exception {
		MyRegistration member = memberService.getMemberByReferId(Integer.valueOf(id));
		if (member == null) {
			throw new Exception("Memeber with id " + id + " not found");
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

		// More details

		memberDto.setStatusDetail("Member found");
		memberDto.setSuccess(true);

		return ResponseEntity.status(HttpStatus.CREATED).body(memberDto);
	}

	@PutMapping("admin/editMemberDetails/{memberId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<MyRegistrationDto> updateMemberDetails(@Valid @RequestBody MyRegistrationDto memberDto,
			@PathVariable String memberId) throws Exception {

		if (memberDto.getName() == null || memberDto.getName().isEmpty()) {
			throw new Exception("First name  cannot be black");
		}
		if (memberDto.getLastName() == null || memberDto.getLastName().isEmpty()) {
			throw new Exception("Last name cannot be black");
		}
		if (memberDto.getDob() == null || memberDto.getDob().isEmpty()) {
			throw new Exception("Date of birth cannot be black");
		}
		if (memberDto.getGender() == null || memberDto.getGender().isEmpty()) {
			throw new Exception("Gender cannot be black");
		}
		if (memberDto.getMobileNumber() == null || memberDto.getMobileNumber().isEmpty()) {
			throw new Exception("Mobile number cannot be black");
		}
		if (memberDto.getEmailAddress() == null || memberDto.getEmailAddress().isEmpty()) {
			throw new Exception("Email address cannot be black");
		}

		memberDto = memberService.updateMemberDetails(memberDto, memberId);
		memberDto.setStatusDetail("Details updated");
		memberDto.setSuccess(true);
		return ResponseEntity.status(HttpStatus.OK).body(memberDto);
	}

	@PutMapping("admin/editMemberAddress/{memberId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<MyRegistrationDto> updateMemberAddress(@Valid @RequestBody MyRegistrationDto memberDto,
			@PathVariable String memberId) throws Exception {

		if (memberDto.getAddress1() == null || memberDto.getAddress1().isEmpty()) {
			throw new Exception("Address 1  cannot be black");
		}
		if (memberDto.getAddress2() == null || memberDto.getAddress2().isEmpty()) {
			throw new Exception("Address 2 cannot be black");
		}
		if (memberDto.getZipCode() == null || memberDto.getZipCode().isEmpty()) {
			throw new Exception("Zip code cannot be black");
		}
		if (memberDto.getCity() == null || memberDto.getCity().isEmpty()) {
			throw new Exception("City cannot be black");
		}
		if (memberDto.getState() == null || memberDto.getState().isEmpty()) {
			throw new Exception("State cannot be black");
		}
		if (memberDto.getCountry() == null || memberDto.getCountry().isEmpty()) {
			throw new Exception("Country cannot be black");
		}

		memberDto = memberService.updateMemberAddressDetails(memberDto, Integer.valueOf(memberId));
		memberDto.setStatusDetail("Address Details updated");
		memberDto.setSuccess(true);
		return ResponseEntity.status(HttpStatus.OK).body(memberDto);
	}

	@PutMapping("admin/editMemberBankDetails/{memberId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<MyRegistrationDto> updateMemberBank(@Valid @RequestBody MyRegistrationDto memberDto,
			@PathVariable String memberId) throws Exception {

		if (memberDto.getAccountNumber() == null || memberDto.getAccountNumber().isEmpty()) {
			throw new Exception("Account number  cannot be black");
		}
		if (memberDto.getBankName() == null || memberDto.getBankName().isEmpty()) {
			throw new Exception("Bank name cannot be black");
		}
		if (memberDto.getSwiftCode() == null || memberDto.getSwiftCode().isEmpty()) {
			throw new Exception("Swift code cannot be black");
		}
		if (memberDto.getIfscCode() == null || memberDto.getIfscCode().isEmpty()) {
			throw new Exception("Ifsc code be black");
		}

		memberDto = memberService.updateMemberBankDetails(memberDto, memberId);
		memberDto.setStatusDetail("Bank Details updated");
		memberDto.setSuccess(true);
		return ResponseEntity.status(HttpStatus.OK).body(memberDto);
	}

	@PutMapping("admin/editMemberPassword/{memberId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<MyRegistrationDto> updateMemberPassword(@Valid @RequestBody MyRegistrationDto memberDto,
			@PathVariable String memberId) throws Exception {

		if (memberDto.getPassword() == null || memberDto.getPassword().isEmpty()) {
			throw new Exception("Password cannot be black");
		}

		memberDto = memberService.updateMemberPassword(memberDto, memberId);
		memberDto.setStatusDetail("Password updated");
		memberDto.setSuccess(true);
		return ResponseEntity.status(HttpStatus.OK).body(memberDto);
	}

	@PutMapping("admin/editMemberTransPassword/{memberId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<MyRegistrationDto> updateMemberTransPassword(@Valid @RequestBody MyRegistrationDto memberDto,
			@PathVariable String memberId) throws Exception {

		if (memberDto.getTransactionPassword() == null || memberDto.getTransactionPassword().isEmpty()) {
			throw new Exception("Transaction password cannot be black");
		}

		memberDto = memberService.updateMemberTransPassword(memberDto, memberId);
		memberDto.setStatusDetail("Transaction password updated");
		memberDto.setSuccess(true);
		return ResponseEntity.status(HttpStatus.OK).body(memberDto);
	}

	@GetMapping("admin/getPowerLegList")
	public ResponseEntity<Map<String, Object>> getPowerLegPurchases() {
		List<PowerLegListModel> powerLegPurchaseList = memberService.powerLegList();
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("PowerLegList", powerLegPurchaseList);
		response.put("Total Power leg purchases", powerLegPurchaseList.size());
		return ok(response);
	}

	@PostMapping("admin/uploadFile")
	public Map<String, String> uploadFile(@RequestPart(value = "file") MultipartFile file) {
		this.service.uploadFileToS3Bucket(file, true, "myfile7");

		Map<String, String> response = new HashMap<>();
		response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");

		return response;
	}

	@GetMapping("admin/getActualPurchaseList")
	public ResponseEntity<Map<String, Object>> getActualPurchases() {
		List<ActualPurchaseListModel> actualPurchaseList = memberService.actualPurchaseList();
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", "Actual purchase list found");
		response.put("success", true);
		response.put("actualPurchaseList", actualPurchaseList);
		response.put("Total purchasers", actualPurchaseList.size());
		return ok(response);
	}

	@PostMapping("admin/kycDetails/{referId}")
	public ResponseEntity<Map<String, Object>> updateKycDetails(
			@RequestPart(value = "panDoc", required = false) MultipartFile panDoc,
			@RequestPart(value = "backDoc", required = false) MultipartFile backDoc,
			@RequestPart(value = "frontDoc", required = false) MultipartFile frontDoc,
			@Valid @RequestPart(value = "kycModel", required = true) KycModel kycModel, @PathVariable Integer referId)
			throws Exception {

		List<MyRegistration> memberList = myRegistrationRepo.findByPan(kycModel.getPanNo());
		Map<String, Object> response = new HashMap<String, Object>();

		if (memberList == null || memberList.size() < 3) {

			MyRegistration member = memberService.getMemberByReferId(referId);
			if (member == null) {
				throw new Exception("Invalid refer id");
			}

			if (kycModel.getPanNo() == null || kycModel.getPanNo().isEmpty()) {
				throw new Exception("Please enter the Pan no.");
			}
			if (kycModel.getAddressProofInfo() == null || kycModel.getAddressProofInfo().isEmpty()) {
				throw new Exception("Please enter the address proof Id");
			}
			if (kycModel.getAddressProof() == null || kycModel.getAddressProof().isEmpty()) {
				throw new Exception("Please select atleast one document");
			}

			if (kycModel.getAccounType() == null || kycModel.getAccounType().isEmpty()) {
				throw new Exception("Please select account type");
			}

			if (panDoc == null) {
				throw new Exception("Document photo is missing");
			}
			if (frontDoc == null) {
				throw new Exception("Front doc photo is missing");
			}
			if (backDoc == null) {
				throw new Exception("Back doc photo is missing");
			}

			response = memberService.processKycDetails(member, kycModel, panDoc, frontDoc, backDoc);

		} else {
			throw new Exception("Pan no entries exceeded limit");
		}

		return ok(response);
	}

	@PostMapping("admin/changeSponsorBy/{referId}")
	public ResponseEntity<Map<String, Object>> changeSponsor(@Valid @RequestBody MyRegistrationDto myRegistrationDto,
			@PathVariable String referId) throws Exception {
		MyRegistration member = memberService.getMemberByReferId(Integer.valueOf(referId));
		if (member == null) {
			throw new Exception("No memeber found with this refer id ");
		}

		if (myRegistrationDto.getSponsorBy() == null) {
			throw new Exception("Refer id cannot be blank ");
		}

		member.setSponsorBy(myRegistrationDto.getSponsorBy());
		MyRegistration updatedMemeber = memberService.updateMember(member);
		Map<String, Object> response = new HashMap<String, Object>();
		if (updatedMemeber != null) {
			response.put("status", "SponsorBy updated successfully");
			response.put("success", true);

		} else {
			response.put("status", "An error occured");
			response.put("success", false);
		}

		return ok(response);
	}
	
	
	@GetMapping("admin/getLeaderList")
	public ResponseEntity<Map<String, Object>> getTransIdsList() throws NumberFormatException, Exception {
		List<MyRegistration> leaderList = memberService.getLeaderList();
		Map<String, Object> model = new HashMap<>();
		model.put("StatusDetails", leaderList.size() +" records found");
		model.put("Success", "true");
		model.put("leaderList", leaderList);
		return ok(model);

	}
	
	@PutMapping("admin/updateLeader/{memberId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<MyRegistrationDto> updateLeaderByMemberId(@Valid @RequestBody MyRegistrationDto memberDto,
			@PathVariable String memberId) throws Exception {

		if (memberDto.getPayoutPerce() == 0) {
			throw new Exception("Payout percent cannot be blank");
		}
		
		MyRegistration member = myRegistrationRepo.checkReferId(Integer.valueOf(memberId.trim()));
		
		if(member == null) {
			throw new Exception("Invalid member id");
		}

		memberDto = memberService.updateLeader(memberDto, member);
		memberDto.setStatusDetail("Leader successfull updated");
		memberDto.setSuccess(true);
		return ResponseEntity.status(HttpStatus.OK).body(memberDto);
	}
	
	@GetMapping("admin/updateActiveStatus/{referId}")
	public ResponseEntity<Map<String, Object>> updateActiveStatus(@PathVariable Integer referId) throws NumberFormatException, Exception {
		MyRegistration member = memberService.updateActiveStatus(referId);
		Map<String, Object> model = new HashMap<>();
		model.put("StatusDetails", "Status changed");
		model.put("Success", "true");
		return ok(model);

	}
	
	@GetMapping("admin/getPayOutList")
	public ResponseEntity<Map<String, Object>> getPayOutList() throws NumberFormatException, Exception {
		List<MyPayoutRun> payOutList = payService.getPayOutList();
		List<MyPayOutRunDto> payOutDtos = new ArrayList<MyPayOutRunDto>();
		MyPayOutRunDto payOutDto;
		for(MyPayoutRun payout: payOutList) {
			payOutDto = new MyPayOutRunDto();
			payOutDto.setId(payout.getId());
			payOutDto.setPayoutRunDate(CommonUtils.formatDate(payout.getPayoutRunDate(), Constants.DATETIME__FORMAT_yyyyMMdd));
			payOutDto.setPayoutStartDate(CommonUtils.formatDate(payout.getPayoutStartDate(),Constants.DATETIME__FORMAT_yyyyMMdd));
			payOutDto.setPayoutEndDate(CommonUtils.formatDate(payout.getPayoutEndDate(),Constants.DATETIME__FORMAT_yyyyMMdd));
			payOutDto.setStatus(payout.getStatus());
			payOutDtos.add(payOutDto);
		}
		Map<String, Object> model = new HashMap<>();
		model.put("StatusDetails", payOutDtos.size() +" records found");
		model.put("Success", "true");
		model.put("payOut list", payOutDtos);
		return ok(model);

	}
	
	@PostMapping("admin/calculateDailyPayout")
	public ResponseEntity<Map<String, Object>> calculateDailyPayout(@Valid @RequestBody PayOutModel payOutModel) throws NumberFormatException, Exception {
		Date selectedDate  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(payOutModel.getDate());
		Calendar cal = Calendar.getInstance();
		cal.setTime(selectedDate);
		cal.add(Calendar.DATE, -7);
		
		System.out.println("Date = "+ cal.getTime());
		payService.startDate = selectedDate;
		payService.endDate = selectedDate;
		payService.onlyDate = selectedDate;
		payService.preDate = cal.getTime();
		payService.preEndDate = cal.getTime();
		payService.preOnlyDate = cal.getTime();
		
		Map<String, Object> model = new HashMap<>();
		
		
		if(payService.checkPayOutEntry() == false) {
			model.put("message", "Payout for a given interval is already done!");
			model.put("status", "0");
			
		}
		
		else if(payService.checkPurchase() == null) {
			model.put("message", "Check purchase process failed!");
			model.put("status", false);
		}
		
		else if(payService.calculateDirectPayouts() == false) {
			model.put("message", "Direct payout calculation process failed!");
			model.put("status", false);
		}
		
		else if(payService.getReferIds() == false) {
			model.put("message", "Incentive payout calculation process failed!");
			model.put("status", false);
		}else {
			
			model.put("message", "Incentive payout calculation process successful!");
			model.put("status", true);
		}
		
		return ok(model);
	}
	
	

}
