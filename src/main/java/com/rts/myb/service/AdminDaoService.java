package com.rts.myb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rts.myb.domain.MyRole;
import com.rts.myb.model.MyRoleDto;
import com.rts.myb.repo.MyRoleRepo;

@Component
public class AdminDaoService {

	@Autowired
	MyRoleRepo myRoleRepo;
	
	//Create Role
	public MyRoleDto createRole(MyRoleDto myRoleDto) {
		MyRole myRole = new MyRole();
		myRole.setRole(myRoleDto.getRole());
		
		myRole = myRoleRepo.save(myRole);
		myRoleDto.setRoleId(myRole.getRoleId());
		
		return myRoleDto;
		
		
	}
	
	
}
