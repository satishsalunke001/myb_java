package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyOtp;

@Repository
public interface MyOtpRepo extends JpaRepository<MyOtp, String>{

}
