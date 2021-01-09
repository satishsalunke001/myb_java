package com.rts.myb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_payout_weekly")
public class MyPayoutWeekly {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int weeklyId;
	private String referId;
	private String rtgsNum;
	private String name;
	private String leader;
	private double treeIncentive;
	private double directIncentive;
	private double incentive;
	private double tds;
	private double processFee;
	private double totalAmount;
	private String bankName;
	private String accNum;
	private String ifscCode;
	private String panNum;
	private String kyc;
	private Integer isPaid = 0;
	private Date releaseDate;
	private Integer isLeaderPayout = 0;
	private String leaderId;
	private String leaderName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getWeeklyId() {
		return weeklyId;
	}
	public void setWeeklyId(int weeklyId) {
		this.weeklyId = weeklyId;
	}
	public String getReferId() {
		return referId;
	}
	public void setReferId(String referId) {
		this.referId = referId;
	}
	public String getRtgsNum() {
		return rtgsNum;
	}
	public void setRtgsNum(String rtgsNum) {
		this.rtgsNum = rtgsNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public double getTreeIncentive() {
		return treeIncentive;
	}
	public void setTreeIncentive(double treeIncentive) {
		this.treeIncentive = treeIncentive;
	}
	public double getDirectIncentive() {
		return directIncentive;
	}
	public void setDirectIncentive(double directIncentive) {
		this.directIncentive = directIncentive;
	}
	public double getIncentive() {
		return incentive;
	}
	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}
	public double getTds() {
		return tds;
	}
	public void setTds(double tds) {
		this.tds = tds;
	}
	public double getProcessFee() {
		return processFee;
	}
	public void setProcessFee(double processFee) {
		this.processFee = processFee;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getPanNum() {
		return panNum;
	}
	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}
	public String getKyc() {
		return kyc;
	}
	public void setKyc(String kyc) {
		this.kyc = kyc;
	}
	public Integer getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(Integer isPaid) {
		this.isPaid = isPaid;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getIsLeaderPayout() {
		return isLeaderPayout;
	}
	public void setIsLeaderPayout(Integer isLeaderPayout) {
		this.isLeaderPayout = isLeaderPayout;
	}
	public String getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	
	
}
