package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyAdminUsers;

@Repository
public interface MyAdminUsersRepo extends JpaRepository<MyAdminUsers, Integer>{

}
