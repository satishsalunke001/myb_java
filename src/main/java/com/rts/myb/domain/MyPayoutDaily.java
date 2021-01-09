package com.rts.myb.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_payout_daily")
public class MyPayoutDaily {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer payoutId;
	private String referId;
	private double leftNodePV;
	private Integer leftNodeCount;
	private double  rightNodePV;
	private Integer rightNodeCount;
	private boolean lastPayoutFullCarry = false;
	private double lastLeftPV;
	private double lastRightPV;
	private double lastPayoutCarryNode;
	private double lastPayoutCarryPV;
	private double capping;
	private double treeIncentive;
	private double directIncentive;
	private double incentive;
	private boolean currentFullCarry = false;
	private double currentLeftPV;
	private double currentRightPV;
	private String currentCarryNode = "0";
	private double currentCarryPV = Double.valueOf("0.00");
	private boolean incentiveLoad = false;
	private Timestamp DateTime;
	private boolean isPaid = false;
	private Date actualDate;
	@Column(name="current_powerleg_pv")
	private double currentPoweringPv;
	@Column(name="powerleg_node")
	private String poweringNode;
	private String unpaidReason;
	private String invalidPayoutMessage;
	private double carryAmount;
	private double directCapping;
	private double orgDirectIncentive;
	private double orgTreeIncentive;
	private double leftPlpv;
	private double rightPlpv;
	private double orgLeftPv;
	private double orgRightPv;
	private String comment;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPayoutId() {
		return payoutId;
	}
	public void setPayoutId(Integer payoutId) {
		this.payoutId = payoutId;
	}
	public String getReferId() {
		return referId;
	}
	public void setReferId(String referId) {
		this.referId = referId;
	}
	public double getLeftNodePV() {
		return leftNodePV;
	}
	public void setLeftNodePV(double leftNodePV) {
		this.leftNodePV = leftNodePV;
	}
	public Integer getLeftNodeCount() {
		return leftNodeCount;
	}
	public void setLeftNodeCount(Integer leftNodeCount) {
		this.leftNodeCount = leftNodeCount;
	}
	public double getRightNodePV() {
		return rightNodePV;
	}
	public void setRightNodePV(double rightNodePV) {
		this.rightNodePV = rightNodePV;
	}
	public Integer getRightNodeCount() {
		return rightNodeCount;
	}
	public void setRightNodeCount(Integer rightNodeCount) {
		this.rightNodeCount = rightNodeCount;
	}
	public boolean isLastPayoutFullCarry() {
		return lastPayoutFullCarry;
	}
	public void setLastPayoutFullCarry(boolean lastPayoutFullCarry) {
		this.lastPayoutFullCarry = lastPayoutFullCarry;
	}
	public double getLastLeftPV() {
		return lastLeftPV;
	}
	public void setLastLeftPV(double lastLeftPV) {
		this.lastLeftPV = lastLeftPV;
	}
	public double getLastRightPV() {
		return lastRightPV;
	}
	public void setLastRightPV(double lastRightPV) {
		this.lastRightPV = lastRightPV;
	}
	public double getLastPayoutCarryNode() {
		return lastPayoutCarryNode;
	}
	public void setLastPayoutCarryNode(double lastPayoutCarryNode) {
		this.lastPayoutCarryNode = lastPayoutCarryNode;
	}
	public double getLastPayoutCarryPV() {
		return lastPayoutCarryPV;
	}
	public void setLastPayoutCarryPV(double lastPayoutCarryPV) {
		this.lastPayoutCarryPV = lastPayoutCarryPV;
	}
	public double getCapping() {
		return capping;
	}
	public void setCapping(double capping) {
		this.capping = capping;
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
	public boolean isCurrentFullCarry() {
		return currentFullCarry;
	}
	public void setCurrentFullCarry(boolean currentFullCarry) {
		this.currentFullCarry = currentFullCarry;
	}
	public double getCurrentLeftPV() {
		return currentLeftPV;
	}
	public void setCurrentLeftPV(double currentLeftPV) {
		this.currentLeftPV = currentLeftPV;
	}
	public double getCurrentRightPV() {
		return currentRightPV;
	}
	public void setCurrentRightPV(double currentRightPV) {
		this.currentRightPV = currentRightPV;
	}
	public String getCurrentCarryNode() {
		return currentCarryNode;
	}
	public void setCurrentCarryNode(String currentCarryNode) {
		this.currentCarryNode = currentCarryNode;
	}
	public double getCurrentCarryPV() {
		return currentCarryPV;
	}
	public void setCurrentCarryPV(double currentCarryPV) {
		this.currentCarryPV = currentCarryPV;
	}
	public boolean isIncentiveLoad() {
		return incentiveLoad;
	}
	public void setIncentiveLoad(boolean incentiveLoad) {
		this.incentiveLoad = incentiveLoad;
	}
	public Timestamp getDateTime() {
		return DateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		DateTime = dateTime;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public Date getActualDate() {
		return actualDate;
	}
	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}
	public double getCurrentPoweringPv() {
		return currentPoweringPv;
	}
	public void setCurrentPoweringPv(double currentPoweringPv) {
		this.currentPoweringPv = currentPoweringPv;
	}
	public String getPoweringNode() {
		return poweringNode;
	}
	public void setPoweringNode(String poweringNode) {
		this.poweringNode = poweringNode;
	}
	public String getUnpaidReason() {
		return unpaidReason;
	}
	public void setUnpaidReason(String unpaidReason) {
		this.unpaidReason = unpaidReason;
	}
	public String getInvalidPayoutMessage() {
		return invalidPayoutMessage;
	}
	public void setInvalidPayoutMessage(String invalidPayoutMessage) {
		this.invalidPayoutMessage = invalidPayoutMessage;
	}
	public double getCarryAmount() {
		return carryAmount;
	}
	public void setCarryAmount(double carryAmount) {
		this.carryAmount = carryAmount;
	}
	public double getDirectCapping() {
		return directCapping;
	}
	public void setDirectCapping(double directCapping) {
		this.directCapping = directCapping;
	}
	public double getOrgDirectIncentive() {
		return orgDirectIncentive;
	}
	public void setOrgDirectIncentive(double orgDirectIncentive) {
		this.orgDirectIncentive = orgDirectIncentive;
	}
	public double getOrgTreeIncentive() {
		return orgTreeIncentive;
	}
	public void setOrgTreeIncentive(double orgTreeIncentive) {
		this.orgTreeIncentive = orgTreeIncentive;
	}
	public double getLeftPlpv() {
		return leftPlpv;
	}
	public void setLeftPlpv(double leftPlpv) {
		this.leftPlpv = leftPlpv;
	}
	public double getRightPlpv() {
		return rightPlpv;
	}
	public void setRightPlpv(double rightPlpv) {
		this.rightPlpv = rightPlpv;
	}
	public double getOrgLeftPv() {
		return orgLeftPv;
	}
	public void setOrgLeftPv(double orgLeftPv) {
		this.orgLeftPv = orgLeftPv;
	}
	public double getOrgRightPv() {
		return orgRightPv;
	}
	public void setOrgRightPv(double orgRightPv) {
		this.orgRightPv = orgRightPv;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
