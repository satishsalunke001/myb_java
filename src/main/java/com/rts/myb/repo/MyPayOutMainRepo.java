package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyPayoutMain;

@Repository
public interface MyPayOutMainRepo extends JpaRepository<MyPayoutMain, Integer> {

	@Query(value = "SELECT * FROM my_payout_main WHERE incentive > 0 AND refer_id = :refer_id LIMIT 1", nativeQuery = true)
	MyPayoutMain getMyPayOutMain(@Param("refer_id") int refer_id);
}
