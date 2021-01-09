package com.rts.myb.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rts.myb.domain.MyPayoutWeekly;
import com.rts.myb.domain.MyRegistration;
import com.rts.myb.repo.MyPayoutWeeklyRepo;
import com.rts.myb.repo.MyRegistrationRepo.PaidUnPaidListModel;
import com.rts.myb.service.MemberDaoService;
import com.rts.myb.service.PayOutWeeklyService;

@RestController
@RequestMapping("/api/")
public class ReportController {
	
	@Autowired
	MemberDaoService memberService;
	@Autowired
	PayOutWeeklyService myPayOutWeeklyService;

	@GetMapping("admin/report/activeInActiveMembers/{flag}")
	public ResponseEntity<Map<String, Object>> getactiveInActiveMembers(@PathVariable String flag) {
		List<MyRegistration> members = memberService.getActiveInactiveMembers(Integer.valueOf(flag));
		Map<String, Object> model = new HashMap<>();
		model.put("StatusDetails", members.size() +members.get(0).getIsFreezed() == 0?"Inactive":"active"+" members found");
		model.put("Success", "true");
		model.put("members", members);

		return ok(model);

	}
	
	@GetMapping("admin/report/paidUnPaidMembers/{flag}")
	public ResponseEntity<Map<String, Object>> getPaidUnPaidMembers(@PathVariable String flag) throws NumberFormatException, Exception {
		List<PaidUnPaidListModel> members = memberService.getPaidUnPaidMembers(Integer.valueOf(flag));
		Map<String, Object> model = new HashMap<>();
		model.put("StatusDetails", members.size() +" Members found");
		model.put("Success", "true");
		model.put("members", members);

		return ok(model);

	}
	
	
	@GetMapping("admin/report/releaseNotRelPayOutList/{flag}")
	public ResponseEntity<Map<String, Object>> getreleaseNotRelPayOutList(@PathVariable String flag) throws NumberFormatException, Exception {
		List<MyPayoutWeekly> releaseNotPayList = myPayOutWeeklyService.getReleaseNotReleasePayOutList(Integer.valueOf(flag));
		Map<String, Object> model = new HashMap<>();
		model.put("StatusDetails", releaseNotPayList.size() +" records found");
		model.put("Success", "true");
		model.put("payoutList", releaseNotPayList);

		return ok(model);

	}
	
	
	@GetMapping("admin/report/asentKycList")
	public ResponseEntity<Map<String, Object>> getAbsentKycList() throws NumberFormatException, Exception {
		List<MyRegistration> absentKycList = memberService.getAbsentKycList();
		Map<String, Object> model = new HashMap<>();
		model.put("StatusDetails", absentKycList.size() +" records found");
		model.put("Success", "true");
		model.put("incompleteKycList", absentKycList);

		return ok(model);

	}
	
	
	@GetMapping("admin/report/getThirtySixtyNinetyList/{days}")
	public ResponseEntity<Map<String, Object>> getThirtySixtyNinetyList(@PathVariable String days) throws NumberFormatException, Exception {
		List<MyRegistration> thirtySixtyNinetyList = memberService.get306090DayList(days);
		Map<String, Object> model = new HashMap<>();
		model.put("StatusDetails", thirtySixtyNinetyList.size() +" records found");
		model.put("Success", "true");
		model.put("thirtySixtyNinetyList", thirtySixtyNinetyList);
		return ok(model);

	}
	
	@GetMapping("admin/report/getTransIdsList")
	public ResponseEntity<Map<String, Object>> getTransIdsList() throws NumberFormatException, Exception {
		List<MyRegistration> transIdsList = memberService.getTransferIdsList();
		Map<String, Object> model = new HashMap<>();
		model.put("StatusDetails", transIdsList.size() +" records found");
		model.put("Success", "true");
		model.put("transIdsList", transIdsList);
		return ok(model);

	}
}
