package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyMemberRewardClaim;

@Repository
public interface MyMemberRewardClaimRepo extends JpaRepository<MyMemberRewardClaim, Integer>{

}
