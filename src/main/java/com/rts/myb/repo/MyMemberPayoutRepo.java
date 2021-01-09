package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyMemberPayout;

@Repository
public interface MyMemberPayoutRepo extends JpaRepository<MyMemberPayout, Integer> {

}
