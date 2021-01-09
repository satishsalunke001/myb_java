package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyNetwork;

@Repository
public interface MyNetworkRepo extends JpaRepository<MyNetwork, Integer> {

}
