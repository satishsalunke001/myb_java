package com.rts.myb.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rts.myb.domain.MyPayoutWeekly;
import com.rts.myb.domain.MyRegistration;
import com.rts.myb.domain.MyWeeklyPayoutRun;
import com.rts.myb.repo.MyPayoutWeeklyRepo;
import com.rts.myb.repo.MyRegistrationRepo;
import com.rts.myb.repo.MyWeeklyPayoutRunRepo;
import com.rts.myb.repo.MyWeeklyPayoutRunRepo.WeeklyPayoutModel;

@Component
public class PayOutWeeklyService {

	
	@Autowired
	MyPayoutWeeklyRepo myPayOutWeeklyRepo;
	@Autowired
	MyRegistrationRepo myRegRepo;
	@Autowired
	MyWeeklyPayoutRunRepo myWeeklyPayOutRunRepo;
	
	public Integer previousPayoutID;
	public Integer currentPayoutID;
	public Integer sevendaysBefore;
	public Date onlyDate;
	public Date startDate;
	public Date endDate;
	public List<String>leftMembers;
	public List<String> rightMembers;
	public double cappingAmount;
	public double directAmount;
	public double leftPv = 0;
	public double rightPv = 0;
	public double treeIncentive;
	public double carryPv;
	public double carryNode;
	public double lastCarryPV = 0;
	public String lastCarryNode = "0";
	public double incentive = 0;
	public double rtgs_num=0;
	public String leaderId = "";
	public String leaderName = "";
	public double leaderPayoutPerce = 0;
	public String leaderBankName = ""; 
	public String leaderAccNumber = ""; 
	public String leaderIfsc = ""; 
	public String leaderPan = ""; 
	public String leaderKyc = "";
	public double leaderIncentive = 0;
	public double leaderFinalIncentive = 0;
	
	
	
	public List<MyPayoutWeekly> getReleaseNotReleasePayOutList(Integer flag){
		List<MyPayoutWeekly> payOutWeeklyList = new ArrayList<MyPayoutWeekly>();
		if(flag == 1) {
			payOutWeeklyList = myPayOutWeeklyRepo.getReleasePayOutList();	
		}else if(flag == 0) {
			payOutWeeklyList = myPayOutWeeklyRepo.getNotReleasePayOutList();
		}
		
		return payOutWeeklyList;
	}
	
	
	public Boolean approvalPending() {
		if(myWeeklyPayOutRunRepo.getWeeklyPayoutByStatusZero().size() > 1) {
			return true;
		}
		
		return false;
	}
	
	public Boolean checkPayoutEntry() {
		if(myWeeklyPayOutRunRepo.checkPayoutEntry(this.endDate).size() > 1) {
			return false;
		}
		return true;
	}
	
	public void setPreviousPayoutID() throws Exception {
		MyWeeklyPayoutRun myWeeklyPayOutRun = myWeeklyPayOutRunRepo.setPreviousPayoutID();
		if(myWeeklyPayOutRun != null) {
			this.previousPayoutID = myWeeklyPayOutRun.getId();
			this.currentPayoutID = this.previousPayoutID + 1;
			this.startDate = myWeeklyPayOutRun.getPayoutEndDate();
		}else{
			this.previousPayoutID = 0;
			this.currentPayoutID = this.previousPayoutID + 1;
			Calendar cal = Calendar.getInstance();
			cal.setTime(this.onlyDate);
			cal.add(Calendar.DATE, -7);
			this.startDate = cal.getTime();
			
		}
		
		MyWeeklyPayoutRun myWeeklyPayoutRunNew = new MyWeeklyPayoutRun();
		myWeeklyPayoutRunNew.setId(this.currentPayoutID);
		myWeeklyPayoutRunNew.setPayoutRunDate(new Date());
		myWeeklyPayoutRunNew.setPayoutStartDate(this.startDate);
		myWeeklyPayoutRunNew.setPayoutEndDate(this.endDate);
		myWeeklyPayoutRunNew.setStatus(0);
		
		MyWeeklyPayoutRun savedMyWeeklyPayoutRun = myWeeklyPayOutRunRepo.save(myWeeklyPayoutRunNew);
		
		if(savedMyWeeklyPayoutRun == null) {
			throw new Exception("Error in saving weekly payout data");
		}
	}
	
	
	public void calculateWeeklyPayout() throws Exception {
		List<WeeklyPayoutModel> weeklyPayOutResult  =myWeeklyPayOutRunRepo.weeklyPayoutDetail(this.startDate,this.endDate);
		
		for(WeeklyPayoutModel weekylyPayOur : weeklyPayOutResult) {
			this.leaderId = "";
			this.leaderName = "";
			
			Integer MemberId;

			Double TreeIncentive;

		    Double Direct_incentive;

			Double Incentive;

			String Bank_name;

			String Account_number;

			String Ifsc_code;

			String Pan_no;

			String KYC;
			
			
			
		    this.getLeader(weekylyPayOur.getMemberId());	//Work done 20-12-2020
		    
		    if(weekylyPayOur.getTreeIncentive() == null) {
		    	TreeIncentive = (double) 0;
		    }
		    if(weekylyPayOur.getDirect_incentive() == null) {
		    	Direct_incentive = (double) 0;
		    }
		    if(weekylyPayOur.getIncentive() == null) {
		    	Incentive = (double) 0;
		    }
		    if(weekylyPayOur.getBank_name() == null) {
		    	Bank_name = "";
		    }
		    if(weekylyPayOur.getAccount_number() == null) {
		    	Account_number = "";
		    }
		    if(weekylyPayOur.getIfsc_code() == null) {
		    	Ifsc_code = "";
		    }
		    if(weekylyPayOur.getPan_no() == null) {
		    	Pan_no = "";
		    }
		    if(weekylyPayOur.getKYC() == null) {
		    	KYC = "";
		    }
		    
		    MyPayoutWeekly myPayOutWeekly = new MyPayoutWeekly();
		    myPayOutWeekly.setWeeklyId(this.currentPayoutID);
		    myPayOutWeekly.setReferId(String.valueOf(weekylyPayOur.getMemberId()));
		    myPayOutWeekly.setName(weekylyPayOur.getMemberName());
		    myPayOutWeekly.setTreeIncentive(weekylyPayOur.getTreeIncentive());
		    myPayOutWeekly.setDirectIncentive(weekylyPayOur.getDirect_incentive());
		    myPayOutWeekly.setIncentive(weekylyPayOur.getIncentive());
		    myPayOutWeekly.setTds(0.0375 * weekylyPayOur.getIncentive());
		    myPayOutWeekly.setProcessFee(0.01 * weekylyPayOur.getIncentive());
		    myPayOutWeekly.setTotalAmount(weekylyPayOur.getIncentive() - ((0.0375 * weekylyPayOur.getIncentive())+(0.01 * weekylyPayOur.getIncentive())));
		    myPayOutWeekly.setBankName(weekylyPayOur.getBank_name());
		    myPayOutWeekly.setAccNum(weekylyPayOur.getAccount_number());
		    myPayOutWeekly.setIfscCode(weekylyPayOur.getIfsc_code());
		    myPayOutWeekly.setPanNum(weekylyPayOur.getPan_no());
		    myPayOutWeekly.setKyc(weekylyPayOur.getKYC());
		    myPayOutWeekly.setLeaderId(this.leaderId);
		    myPayOutWeekly.setLeaderName(this.leaderName);
		    
		    MyPayoutWeekly savedMyPayOutWeekly = myPayOutWeeklyRepo.save(myPayOutWeekly);
		    
		    if(savedMyPayOutWeekly == null) {
		    	throw new Exception("Error in calculating weekly payout");
		    } //Work done 20-12-2020-2
	}
}
		
		public void getLeader(Integer referId) throws Exception {
			MyRegistration memberLeader = myRegRepo.findByReferId(referId);
			if(memberLeader != null) {
				if(memberLeader.getIsLeader() == 1) {
					this.leaderId = String.valueOf(referId);
					this.leaderName = memberLeader.getName()+" "+memberLeader.getLastName();
					this.leaderBankName = memberLeader.getBankName();
					this.leaderAccNumber = memberLeader.getAccountNumber();
					this.leaderIfsc = memberLeader.getIfscCode();
					this.leaderPan = memberLeader.getPan();
					this.leaderKyc = memberLeader.getPhotoPath()+"/"+memberLeader.getDocName();
				}else {
					getLeader(memberLeader.getSponsorId());
				}
			}else {
				throw new Exception("Error in getting leader");
			}
		}
		
		
		
		
	}

