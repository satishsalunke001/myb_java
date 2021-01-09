package com.rts.myb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_role_access")
public class MyRoleAccess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accessId;
	private String module;
	private Integer addAccess = 0;
	private Integer editAccess = 0;
	private Integer deleteAccess = 0;
	private Integer listAccess = 0;
	private Integer roleId = 0;
	public Integer getAccessId() {
		return accessId;
	}
	public void setAccessId(Integer accessId) {
		this.accessId = accessId;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public Integer getAddAccess() {
		return addAccess;
	}
	public void setAddAccess(Integer addAccess) {
		this.addAccess = addAccess;
	}
	public Integer getEditAccess() {
		return editAccess;
	}
	public void setEditAccess(Integer editAccess) {
		this.editAccess = editAccess;
	}
	public Integer getDeleteAccess() {
		return deleteAccess;
	}
	public void setDeleteAccess(Integer deleteAccess) {
		this.deleteAccess = deleteAccess;
	}
	public Integer getListAccess() {
		return listAccess;
	}
	public void setListAccess(Integer listAccess) {
		this.listAccess = listAccess;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
}
