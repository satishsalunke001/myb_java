package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyDirectPayout;

@Repository
public interface MyDirectPayoutRepo extends JpaRepository<MyDirectPayout, Integer> {

	@Query(value = "SELECT SUM(incentive) AS direct_incentive FROM my_direct_payout WHERE sponsored_id = :referId", nativeQuery = true)
	Integer prePayDirect(@Param("referId") Integer referId);
}
