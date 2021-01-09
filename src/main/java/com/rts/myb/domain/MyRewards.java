package com.rts.myb.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_rewards")
public class MyRewards {

	@Id
	private Integer id;
	private String name;
	private String imageName;
	private double targetA;
	private double targetB;
	private double targetDirectTotal;
	private double reqA;
	private double reqB;
	private double reqTotal;
	private Integer daysLeft = 0;
	private String status = "0";
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public double getTargetA() {
		return targetA;
	}
	public void setTargetA(double targetA) {
		this.targetA = targetA;
	}
	public double getTargetB() {
		return targetB;
	}
	public void setTargetB(double targetB) {
		this.targetB = targetB;
	}
	public double getTargetDirectTotal() {
		return targetDirectTotal;
	}
	public void setTargetDirectTotal(double targetDirectTotal) {
		this.targetDirectTotal = targetDirectTotal;
	}
	public double getReqA() {
		return reqA;
	}
	public void setReqA(double reqA) {
		this.reqA = reqA;
	}
	public double getReqB() {
		return reqB;
	}
	public void setReqB(double reqB) {
		this.reqB = reqB;
	}
	public double getReqTotal() {
		return reqTotal;
	}
	public void setReqTotal(double reqTotal) {
		this.reqTotal = reqTotal;
	}
	public Integer getDaysLeft() {
		return daysLeft;
	}
	public void setDaysLeft(Integer daysLeft) {
		this.daysLeft = daysLeft;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
