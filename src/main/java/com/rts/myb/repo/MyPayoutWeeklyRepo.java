package com.rts.myb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyPayoutWeekly;

@Repository
public interface MyPayoutWeeklyRepo extends JpaRepository<MyPayoutWeekly, Integer>{

	
	@Query(value = "SELECT * FROM my_payout_weekly WHERE is_paid=1", nativeQuery = true)
	List<MyPayoutWeekly> getReleasePayOutList(); 
	
	
	@Query(value = "SELECT * FROM my_payout_weekly WHERE is_paid=0", nativeQuery = true)
	List<MyPayoutWeekly> getNotReleasePayOutList(); 
}
