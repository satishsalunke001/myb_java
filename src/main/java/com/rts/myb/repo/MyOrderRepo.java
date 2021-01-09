package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyOrder;

@Repository
public interface MyOrderRepo extends JpaRepository<MyOrder, String>{

}
