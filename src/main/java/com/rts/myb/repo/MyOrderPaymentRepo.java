package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyOrderPayment;

@Repository
public interface MyOrderPaymentRepo extends JpaRepository<MyOrderPayment, String>{

}
