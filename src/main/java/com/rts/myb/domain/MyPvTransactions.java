package com.rts.myb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_pv_transactions")
public class MyPvTransactions {

	@Id
	@Column(name="id", length = 100)
	private String id;
    private String referId;
    private String transferFrom;
    private String transferTo;
    private String mode;
    private double initialPv;
    private double pv;
    private double finalPv;
    private Date dateEntered;
    private Date dateModified;
    private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReferId() {
		return referId;
	}
	public void setReferId(String referId) {
		this.referId = referId;
	}
	public String getTransferFrom() {
		return transferFrom;
	}
	public void setTransferFrom(String transferFrom) {
		this.transferFrom = transferFrom;
	}
	public String getTransferTo() {
		return transferTo;
	}
	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public double getInitialPv() {
		return initialPv;
	}
	public void setInitialPv(double initialPv) {
		this.initialPv = initialPv;
	}
	public double getPv() {
		return pv;
	}
	public void setPv(double pv) {
		this.pv = pv;
	}
	public double getFinalPv() {
		return finalPv;
	}
	public void setFinalPv(double finalPv) {
		this.finalPv = finalPv;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    

}
