package com.rts.myb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyPayoutRun;

@Repository
public interface MyPayOutRunRepo extends JpaRepository<MyPayoutRun, Integer>{

	@Query(value = "select * from my_payout_run order by id desc", nativeQuery = true)
	List<MyPayoutRun> getPayOutList();
}
