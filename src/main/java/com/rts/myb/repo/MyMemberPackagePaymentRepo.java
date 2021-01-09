package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyMemberPackagePayment;

@Repository
public interface MyMemberPackagePaymentRepo extends JpaRepository<MyMemberPackagePayment, Integer> {

}
