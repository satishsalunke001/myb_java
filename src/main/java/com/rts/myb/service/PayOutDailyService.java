package com.rts.myb.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rts.myb.domain.MyDirectPayout;
import com.rts.myb.domain.MyPayoutDaily;
import com.rts.myb.domain.MyPayoutMain;
import com.rts.myb.domain.MyPayoutRun;
import com.rts.myb.model.CalculatePayOutModel;
import com.rts.myb.model.ReferDataModel;
import com.rts.myb.repo.MyDirectPayoutRepo;
import com.rts.myb.repo.MyMemberPackageRepo;
import com.rts.myb.repo.MyPayOutChildRepo;
import com.rts.myb.repo.MyPayOutChildRepo.DirectPayOutModel;
import com.rts.myb.repo.MyPayOutDailyRepo;
import com.rts.myb.repo.MyPayOutDailyRepo.checkIfNewMemberQualifiedModel;
import com.rts.myb.repo.MyPayOutDailyRepo.prePayResultModel;
import com.rts.myb.repo.MyPayOutMainRepo;
import com.rts.myb.repo.MyPayOutRunRepo;
import com.rts.myb.repo.MyRegistrationRepo;

@Component
public class PayOutDailyService {
	

	@Autowired
	MyPayOutRunRepo myPayOutRunRepo;
	@Autowired
	MyPayOutDailyRepo myPayOutDailyRepo;
	@Autowired
	MyPayOutChildRepo myPayOutChildRepo;
	@Autowired
	MyMemberPackageRepo myMemberPackageRepo;
	@Autowired
	MyRegistrationRepo myRegRepo;
	@Autowired
	MyDirectPayoutRepo myDirectPayoutRepo;
	@Autowired
	MyPayOutMainRepo myPayOutMainRepo;
	
	

	public String  previousPayoutID;
	public String  currentPayoutID;
	public Date preDate;
	public Date preEndDate;
	public Date  preOnlyDate;
	public Date onlyDate;
	public Date  startDate;
	public Date  endDate;
	public List<String> leftMembers;
	public List<String> rightMembers;
	public Integer cappingAmount;
	public Integer directAmount;
	public Integer leftPv = 0;
	public Integer rightPv = 0;
	public Integer treeIncentive;
	public Integer carryPv;
	public String carryNode;
	public Integer lastCarryPV = 0;
	public String lastCarryNode = "0";
	public Integer incentive = 0;
	
	
	
	public List<MyPayoutRun> getPayOutList(){
		return myPayOutRunRepo.getPayOutList();
	}
	
	public boolean checkPayOutEntry() {
		MyPayoutDaily dailyPayOut = myPayOutDailyRepo.checkPayOutEntry(startDate);
		if(dailyPayOut == null) {
			return true;
		}
		return false;
	}
	
	public Integer checkPurchase() {
		Integer totalCount = myPayOutChildRepo.checkPurchase(preOnlyDate);
		return totalCount;
	}
	
	public boolean checkIfMemberIsPaid(Integer referId) {
		Integer totalCount = myMemberPackageRepo.checkIfMemberIsPaid(referId);
		boolean flag = false;
		if(totalCount == null) {
			flag = false;
		}
		
		if(totalCount!= 0) {
			flag = true;
		}else {
			flag = false;
		}
		
		return flag;
	}
	
	
	public boolean getReferIds() {
		List<Integer> sponsorIds = myPayOutChildRepo.sponsorIds(preOnlyDate);
		List<ReferDataModel> referDataList = new ArrayList<ReferDataModel>();
		for(Integer referId:sponsorIds) {
			List<String> leftMembers = new ArrayList<String>();
			List<String> rightMembers = new ArrayList<String>();
			
			List<Integer> leftNwReferIds = myRegRepo.getLeftNwReferIds(referId);
			for(Integer leftNwId:leftNwReferIds ) {
				leftMembers.add(String.valueOf(leftNwId));
			}
			
			List<Integer> rightNwReferIds = myRegRepo.getRightNwReferIds(referId);
			for(Integer rightNwId:rightNwReferIds ) {
				rightMembers.add(String.valueOf(rightNwId));
			}
			
			
			ReferDataModel referData = new ReferDataModel();
			//Work in progress 27-11-2020
			referData.setReferId(referId);
			
			if(!(leftMembers.size() < 1) && !(rightMembers.size() <1)) {
				MyPayoutMain checkPrePayOut = myPayOutMainRepo.getMyPayOutMain(referId);
				if(checkPrePayOut == null) {
					//Work in progress 28-11-2020
					Integer directMembers = myRegRepo.directCount(referId);
					if(directMembers > 1) {
						if(checkIfMemberIsPaid(referId)) {
							referData.setIsPaid(true);
						}else {
							referData.setIsPaid(false);
							referData.setUnPaidReason("Member is not paid");
						}
						
					}else {
						referData.setIsPaid(false);
						referData.setUnPaidReason("Two direct members");
					}
				}else {
					referData.setIsPaid(true);
				}
			}else {
				referData.setIsPaid(false);
				referData.setUnPaidReason("should have both legs");
			}
			
			referDataList.add(referData);
		}
		
		return calculatePayOut(referDataList);
	}
	
	
	
	
	
	public boolean calculatePayOut(List<ReferDataModel> referDataList) {
		
		CalculatePayOutModel calculateModel;
		
		for(ReferDataModel referData : referDataList) {
			calculateModel = new CalculatePayOutModel();
			double orgTreeIncentive = 0;
			String invalidPayOutMessage = "";
			
			/**
			 * Calculate left leg amount and calculate incentive by 10%
			 */
			Integer leftLegAmount = myPayOutChildRepo.calculateLeftLegAmount(preOnlyDate, referData.getReferId());
			if(leftLegAmount != null) {
				calculateModel.setLeftPv(calculateModel.getLeftP1Pv() + leftLegAmount);
			}
			
			calculateModel.setOrgLeftPv(calculateModel.getLeftPv());
			
			/**
			 * Calculate right leg amount and calculate incentive by 10%
			 */
			
			Integer rightLegAmount = myPayOutChildRepo.calculateRightLegAmount(preOnlyDate, referData.getReferId());
			if(rightLegAmount != null) {
				calculateModel.setRightPv(calculateModel.getRightPv() + rightLegAmount);
			}
			
			calculateModel.setOrgRightPv(calculateModel.getRightPv());
			
			/**
			 * Calculate left leg power leg PV
			 */
			
			Integer leftPlPv = myPayOutChildRepo.calculateLeftLegPowerLegPv(preOnlyDate, referData.getReferId());
			if(leftPlPv != null) {
				calculateModel.setLeftP1Pv(calculateModel.getLeftP1Pv() + leftPlPv);
			}
			
			calculateModel.setOrgLeftP1Pv(calculateModel.getLeftP1Pv());
			
			/**
			 * Calculate right leg power leg PV
			 */
			
			Integer rightPlPv = myPayOutChildRepo.calculateRightLegPowerLegPv(preOnlyDate, referData.getReferId());
			if(rightPlPv != null) {
				calculateModel.setRightP1Pv(calculateModel.getRightP1Pv() + rightPlPv);
			}
			
			calculateModel.setOrgRightP1Pv(calculateModel.getLeftP1Pv());
			
			
			/**
			 * Check previous carry forward amount
			 * If available, add it into current incentive by checking respective leg
			 */
			
			MyPayoutDaily preCarryPayOut = myPayOutDailyRepo.checkPreCarryAmount(referData.getReferId());
			if(preCarryPayOut != null) {
				if(preCarryPayOut.getCurrentCarryNode().equals("1")) {
					calculateModel.setLeftPv(calculateModel.getLeftPv() + Integer.valueOf(String.valueOf(preCarryPayOut.getCurrentCarryPV())));
					calculateModel.setLastCarryPv(Integer.valueOf(String.valueOf(preCarryPayOut.getCurrentCarryPV())));
					calculateModel.setLastCarryNode("1");
				}else if(preCarryPayOut.getCurrentCarryNode().equals("r")) {
					calculateModel.setRightPv(calculateModel.getRightPv() + Integer.valueOf(String.valueOf(preCarryPayOut.getCurrentCarryPV())));
					calculateModel.setLastCarryPv(Integer.valueOf(String.valueOf(preCarryPayOut.getCurrentCarryPV())));
					calculateModel.setLastCarryNode("r");
				}
				calculateModel.setPowerLegNode(preCarryPayOut.getPoweringNode());
			}
			
			
			/**
			 * Rule No 11: Power Leg Logic: Power legs from both legs should not be considered for payout
			 */
			
			if(calculateModel.getRightP1Pv() == null) {
				calculateModel.setRightP1Pv(0);
			}
			
			if(calculateModel.getLeftP1Pv() == null) {
				calculateModel.setLeftP1Pv(0);
			}
			
			/**
			 * If powerleg is same in both legs, they will cross each other and zero PV will be considered
			 */
			
			if(calculateModel.getRightP1Pv() == calculateModel.getLeftP1Pv()) {
				calculateModel.setLeftP1Pv(0);
				calculateModel.setRightP1Pv(0);
			}
			
			
			// If powerleg in both legs next time
			// If other leg powerleg is more next time
			// Remaining powerleg
			
			
			if(!calculateModel.getPowerLegNode().equals("0")) {
				MyPayoutDaily prePayOut = myPayOutDailyRepo.prePayOut(referData.getReferId());
				if(prePayOut != null) {
					if(prePayOut.getCurrentCarryNode().equals(calculateModel.getPowerLegNode())) {
						if(preCarryPayOut.getCurrentCarryPV() >= prePayOut.getCurrentCarryPV()) {
							if(calculateModel.getPowerLegNode().equals("1")) {
								calculateModel.setLeftP1Pv(Integer.valueOf(String.valueOf(calculateModel.getLeftP1Pv()+prePayOut.getCurrentPoweringPv())));
							}else {
								calculateModel.setRightP1Pv(Integer.valueOf(String.valueOf(calculateModel.getRightP1Pv()+prePayOut.getCurrentPoweringPv())));
							}
						}
					}
				}
				
				
				
				if(calculateModel.getRightP1Pv() > calculateModel.getLeftP1Pv()) {
					calculateModel.setRightP1Pv(calculateModel.getRightP1Pv() - calculateModel.getLeftP1Pv());
					calculateModel.setPowerLegNode("r");
					calculateModel.setRightPv(calculateModel.getRightPv() + calculateModel.getRightP1Pv());
					calculateModel.setCurrentPowerLegPv(String.valueOf(calculateModel.getRightP1Pv()));
					
				}else {
					if(calculateModel.getLeftP1Pv() < 1) {
						calculateModel.setPowerLegNode("0");
						calculateModel.setCurrentPowerLegPv("0");
						
					}else {
						calculateModel.setLeftP1Pv(calculateModel.getLeftP1Pv() - calculateModel.getRightP1Pv());
						calculateModel.setPowerLegNode("l");
						calculateModel.setLeftPv(calculateModel.getLeftPv() + calculateModel.getLeftP1Pv());
						calculateModel.setCurrentPowerLegPv(String.valueOf(calculateModel.getLeftP1Pv()));
					}
				}
			}else {
				if(calculateModel.getRightP1Pv() > calculateModel.getLeftP1Pv()) {
					calculateModel.setRightP1Pv(calculateModel.getRightP1Pv() - calculateModel.getLeftP1Pv());
					calculateModel.setPowerLegNode("r");
					calculateModel.setRightPv(calculateModel.getRightPv() + calculateModel.getRightP1Pv());
					calculateModel.setCurrentPowerLegPv(String.valueOf(calculateModel.getRightP1Pv()));
				}else {
					if(calculateModel.getLeftP1Pv() < 1) {
						calculateModel.setPowerLegNode("0");
						calculateModel.setCurrentPowerLegPv("0");
						
					}else {
						calculateModel.setLeftP1Pv(calculateModel.getLeftP1Pv() - calculateModel.getRightP1Pv());
						calculateModel.setPowerLegNode("l");
						calculateModel.setLeftPv(calculateModel.getLeftPv() + calculateModel.getLeftP1Pv());
						calculateModel.setCurrentPowerLegPv(String.valueOf(calculateModel.getLeftP1Pv()));
					}
				}
			}
			
			/**
			 * Rule No 4: Select weaker leg by amount. Carry forward remaining amount
			 */

			boolean firstPayOut = false;
			MyPayoutDaily checkPrePayout = myPayOutDailyRepo.checkPrePayOut(referData.getReferId());
			if(checkPrePayout != null) {
				firstPayOut = true;
			}
			if(firstPayOut && calculateModel.getLeftPv() > 0 && calculateModel.getRightPv() > 0) {
				int calculatePv = 0;
				if(calculateModel.getLeftPv() == calculateModel.getRightPv()) {
					calculatePv = (int) (calculateModel.getLeftPv() * 0.5);
					calculateModel.setCarryNode("l");
					calculateModel.setCarryPv(calculateModel.getLeftPv() - calculatePv);
				}else {
					if(calculateModel.getLeftPv() > calculateModel.getRightPv()) {
						// Let's say LeftPV = 40,000 and RightPV = 2,00,000
						if((calculateModel.getLeftPv() * 2) == calculateModel.getRightPv()) {
							calculatePv = calculateModel.getLeftPv();
						}else if((calculateModel.getLeftPv() * 2) < calculateModel.getRightPv()) {
							calculatePv = calculateModel.getLeftPv();
							calculateModel.setCarryNode("r");
							calculateModel.setCarryPv(calculateModel.getRightP1Pv() - (calculateModel.getLeftPv() * 2));
							
						}else {
							calculatePv = (int) (calculateModel.getRightPv() * 0.5);
							calculateModel.setCarryNode("l");
							calculateModel.setCarryPv(calculateModel.getLeftPv() - calculatePv);
						}
					}else {
						// Let's say RightPV = 40,000 and LeftPV = 2,00,000
						if((calculateModel.getRightPv() * 2) == calculateModel.getLeftPv()) {
							calculatePv = calculateModel.getRightPv();
						}else if((calculateModel.getRightPv() * 2) < calculateModel.getLeftPv()) {
							 calculatePv = calculateModel.getRightPv();
							 calculateModel.setCarryNode("l");
							 calculateModel.setCarryPv(calculateModel.getLeftPv() - (calculateModel.getRightPv() * 2));
						}else {
							calculatePv = (int) (calculateModel.getLeftPv() * 0.5);
							calculateModel.setCarryNode("r");
							calculateModel.setCarryPv(calculateModel.getRightPv() - calculatePv);
						}
					}
					
					//line no 396
					calculateModel.setTreeIncentive(calculatePv * 0.1);
					orgTreeIncentive = calculateModel.getTreeIncentive();
					invalidPayOutMessage = "1:2 rule is applied";
					
				}
			}else {
				if(calculateModel.getLeftPv() != calculateModel.getRightPv()) {
					if(calculateModel.getLeftPv() > calculateModel.getRightPv()) {
						calculateModel.setCarryPv(calculateModel.getLeftPv() - calculateModel.getRightPv());
						calculateModel.setTreeIncentive(calculateModel.getRightPv() * 0.1);
						calculateModel.setCarryNode("l");
					}else {
						calculateModel.setCarryPv(calculateModel.getRightPv() - calculateModel.getLeftPv());
						calculateModel.setTreeIncentive(calculateModel.getLeftPv() * 0.1);
						calculateModel.setCarryNode("r");
					}
				}else {
					calculateModel.setTreeIncentive(calculateModel.getLeftPv() * 0.1);
				}
				
				orgTreeIncentive = calculateModel.getTreeIncentive();
				
				/**
				 * Rule No 8: Minimum capping(of first three orders) required is 2000
				 */
				
				List<Date> uniqueDates = myMemberPackageRepo.uniqueDate(referData.getReferId(),preEndDate);
				//String cappingDates = "";
				List<Date> cappingDates = new ArrayList<Date>();
				if(!(uniqueDates.size() < 1)) {
					
					
//					for(Date uniqueDate : uniqueDates) {
//						if(!cappingDates.isEmpty()) {
//							cappingDates = cappingDates+","+uniqueDates;
//						}else {
//							cappingDates = ","+uniqueDates;
//						}
//					}
					
					
					Integer capping = myMemberPackageRepo.capping(referData.getReferId(), uniqueDates);
					//Integer capping = myMemberPackageRepo.capping(referId, cappingDates);
					
					if(capping!=null) {
						// Minimum capping required is 2000
						if(capping >= 2000) {
							calculateModel.setCappingAmount(capping);
						}else{
							calculateModel.setCappingAmount(0);
							invalidPayOutMessage = "Capping amount is less than 2000";
						}
					}else{
						calculateModel.setCappingAmount(0);
					}
					
				}else{
					calculateModel.setCappingAmount(0);
				}
				
				if(calculateModel.getTreeIncentive() > calculateModel.getCappingAmount()) {
					double carryAmount = calculateModel.getTreeIncentive() - calculateModel.getCappingAmount();
					calculateModel.setTreeIncentive(calculateModel.getCappingAmount());
					invalidPayOutMessage = "Incentive amount is greater than capping";
				}
				calculateModel.setIncentive(calculateModel.getIncentive());
				//work 22-11-2020
				MyPayoutDaily myDailyPayOutObj = new MyPayoutDaily();
				myDailyPayOutObj.setId(0);
				myDailyPayOutObj.setReferId(String.valueOf(referData.getReferId()));
				myDailyPayOutObj.setCurrentLeftPV(calculateModel.getLeftPv());
				myDailyPayOutObj.setCurrentRightPV(calculateModel.getRightPv());
				myDailyPayOutObj.setCurrentCarryPV(calculateModel.getCarryPv());
				myDailyPayOutObj.setCurrentCarryNode(calculateModel.getCarryNode());
				myDailyPayOutObj.setCapping(calculateModel.getCappingAmount());
				myDailyPayOutObj.setTreeIncentive(calculateModel.getTreeIncentive());
				myDailyPayOutObj.setIncentive(calculateModel.getIncentive());
				myDailyPayOutObj.setLastPayoutCarryPV(calculateModel.getLastCarryPv());
				myDailyPayOutObj.setLastPayoutCarryNode(Double.valueOf(calculateModel.getLastCarryNode()));
				myDailyPayOutObj.setDateTime(new Timestamp(startDate.getTime()));
				myDailyPayOutObj.setPaid(referData.getIsPaid());
				myDailyPayOutObj.setActualDate(preOnlyDate);
				myDailyPayOutObj.setUnpaidReason(referData.getUnPaidReason());
				myDailyPayOutObj.setInvalidPayoutMessage(invalidPayOutMessage);
				myDailyPayOutObj.setCarryAmount(calculateModel.getCarryAmount());
				myDailyPayOutObj.setCurrentPoweringPv(myDailyPayOutObj.getCurrentPoweringPv());
				myDailyPayOutObj.setPoweringNode(calculateModel.getPowerLegNode());
				myDailyPayOutObj.setOrgTreeIncentive(calculateModel.getOrgTreeIncentive());
				myDailyPayOutObj.setLeftPlpv(calculateModel.getOrgLeftP1Pv());
				myDailyPayOutObj.setRightPlpv(calculateModel.getOrgRightP1Pv());
				myDailyPayOutObj.setOrgLeftPv(calculateModel.getOrgLeftPv());
				myDailyPayOutObj.setOrgRightPv(calculateModel.getOrgRightPv());
				MyPayoutDaily savedInstance = myPayOutDailyRepo.save(myDailyPayOutObj);
				
				if(calculateModel.getIncentive() > 0) {
					myPayOutChildRepo.updatePayChild(preOnlyDate, referData.getReferId());
				}
				
			}
			
			
		}
		
		
		return true;
		
	}
	
	
	public boolean calculateDirectPayouts() {
		List<DirectPayOutModel> directPayOutList = myPayOutChildRepo.directPayOut(preOnlyDate);
		if(directPayOutList.size() > 0) {
			for(DirectPayOutModel directPayOut: directPayOutList) {
				String invalidMessage = "";
				double directIncentive = 0;
				double incentive = 0;
				Integer sponsorId = directPayOut.getSponsored_id();
				Integer directCapping = getDirectCapping(sponsorId);
				boolean isPaid = checkIfMemberIsPaid(sponsorId);
				if(directPayOut.getPv() > 0) {
					directIncentive = directPayOut.getPv() * 0.10;
				}
				
				incentive = directIncentive;
				if(isPaid) {
					invalidMessage = "Member is not paid";
				}
				
				DateTime date = DateTime.now();
				MyDirectPayout myDirectPayOut = new MyDirectPayout();
				myDirectPayOut.setSponsorId(sponsorId);
				myDirectPayOut.setPurchase(directPayOut.getPurchase());
				myDirectPayOut.setPurchasePv(directPayOut.getPv());
				myDirectPayOut.setDirectIncentive(directIncentive);
				myDirectPayOut.setIncentive(incentive);
				myDirectPayOut.setCapping(directCapping);
				myDirectPayOut.setPayoutDate(startDate);
				myDirectPayOut.setActualDate(preOnlyDate);
				myDirectPayOut.setIsPaid(isPaid == false?0:1);
				myDirectPayOut.setInvalidMessage(invalidMessage);
				
				myDirectPayoutRepo.save(myDirectPayOut);
				
				
			}
		}
		
		return true;
	}
	
	
	
	public Integer getDirectCapping(Integer referId) {
		Integer directCap = myMemberPackageRepo.directCapping(referId);
		return directCap;
	}
	
	
	
	// STARTed work 25-11-2020 line 580
	
	public boolean checkIfNewMemberQualified() {
		List<checkIfNewMemberQualifiedModel> queryResult = myPayOutDailyRepo.checkIfNewMemberQualified(preOnlyDate, onlyDate);
		for(checkIfNewMemberQualifiedModel newMemberQualiFied : queryResult) {
			boolean isPaid = false;
			List<Integer> leftNwReferIdList = myRegRepo.getLeftNwReferId(newMemberQualiFied.getRefer_id());
			for(Integer lefftNwReferId : leftNwReferIdList) {
				leftMembers.add(String.valueOf(lefftNwReferId));
			}
			
			List<Integer> rightNwReferIdList = myRegRepo.getRightNwReferId(newMemberQualiFied.getRefer_id());
			for(Integer rightNwReferId : rightNwReferIdList) {
				rightMembers.add(String.valueOf(rightNwReferId));
			}
			
			if(!(leftMembers.size()<1) && !(rightMembers.size()<1)) {
				Integer directMemberCount = myRegRepo.directMembers(newMemberQualiFied.getRefer_id(), preOnlyDate);
				if(checkIfMemberIsPaid(newMemberQualiFied.getRefer_id())) {
					isPaid = true;
				}
				//Work is in progress 26-11-2020 624
			}
			
			
			if(isPaid) {
				prePayResultModel prePayResult = myPayOutDailyRepo.prePayResult(newMemberQualiFied.getRefer_id());
				double sumOfDirectIncentive = myDirectPayoutRepo.prePayDirect(newMemberQualiFied.getRefer_id());
				if(prePayResult!=null) {
					double treeIncentive = 0;
					double incentive = 0;
					if(prePayResult.getTree_incentive()>0) {
						treeIncentive = prePayResult.getTree_incentive();
					}
					
					incentive = prePayResult.getIncentive();
					double directIncentive = 0;
					if(sumOfDirectIncentive > 0) {
						directIncentive = sumOfDirectIncentive;
					}
					
					if(incentive > 0 || directIncentive >0) {
						System.out.println("ID "+newMemberQualiFied.getRefer_id()+" "+"INC "+incentive+" "+"DIR "+directIncentive);
					} 
					
				}
			}
		}
		
		return true;
	}
	
	//work done 27-11-2020 122 need to make getReferId method
	
}
