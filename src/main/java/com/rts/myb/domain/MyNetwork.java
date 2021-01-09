package com.rts.myb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="my_network")
public class MyNetwork {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String referId;
	
	@Lob
	@Column(name="leftNetwork", length=512)
	private String leftNetwork;
	
	@Lob
	@Column(name="rightNetwork", length=512)
	private String rightNetwork;
	
	private Integer status;
	private Date updateTime;
	
	@Lob
	@Column(name="position", length=512)
	private String position;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReferId() {
		return referId;
	}

	public void setReferId(String referId) {
		this.referId = referId;
	}

	public String getLeftNetwork() {
		return leftNetwork;
	}

	public void setLeftNetwork(String leftNetwork) {
		this.leftNetwork = leftNetwork;
	}

	public String getRightNetwork() {
		return rightNetwork;
	}

	public void setRightNetwork(String rightNetwork) {
		this.rightNetwork = rightNetwork;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	

	
}
