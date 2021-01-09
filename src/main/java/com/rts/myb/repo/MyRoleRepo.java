package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyRole;



@Repository
public interface MyRoleRepo extends JpaRepository<MyRole, Integer> {

}
