package com.rts.myb.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyPayoutDaily;
import com.rts.myb.domain.MyPayoutRun;

@Repository
public interface MyPayOutDailyRepo extends JpaRepository<MyPayoutDaily, Integer> {

	@Query(value = "SELECT * from my_payout_daily where DATE(date_time) = :date LIMIT 1", nativeQuery = true)
	MyPayoutDaily checkPayOutEntry(@Param("date") Date date);
	
	
	@Query(value = "SELECT * FROM my_payout_daily WHERE refer_id = :referId ORDER BY id DESC LIMIT 1", nativeQuery = true)
	MyPayoutDaily checkPreCarryAmount(@Param("referId") Integer referId);
	

	@Query(value = "SELECT * FROM my_payout_daily WHERE refer_id = :referId AND current_powerleg_pv > 0 ORDER BY id DESC LIMIT 1", nativeQuery = true)
	MyPayoutDaily prePowerLeg(@Param("referId") Integer referId);
	
	
	@Query(value = "SELECT * FROM my_payout_daily WHERE org_tree_incentive > 0 AND refer_id = :referId LIMIT 1", nativeQuery = true)
	MyPayoutDaily prePayOut(@Param("referId")  Integer referId);
	
	
	@Query(value = "SELECT * FROM my_payout_daily WHERE refer_id = :referId AND current_powerleg_pv > 0 ORDER BY id DESC LIMIT 1", nativeQuery = true)
	MyPayoutDaily checkPrePayOut(@Param("referId")  Integer referId);
	
	
	
	@Query(value = "SELECT DISTINCT mpd.refer_id,\" \r\n" + 
			"					.\" (SELECT COUNT(id) AS total_count FROM my_member_package WHERE refer_id = mpd.refer_id AND deleted = 0 AND payment_status = 1 AND DATE(date_entered) <= :preDate) AS order_count\"\r\n" + 
			"					.\" FROM my_payout_daily mpd\"\r\n" + 
			"					.\" WHERE DATE(mpd.date_time) <= :onlyDate AND (mpd.unpaid_reason IS NOT NULL OR mpd.unpaid_reason = '') \"\r\n" + 
			"					.\" AND mpd.refer_id NOT IN (SELECT DISTINCT refer_id FROM my_payout_daily WHERE is_paid = 1 AND DATE(date_time) != :onlyDate)\"\r\n" + 
			"					.\" AND mpd.refer_id NOT IN (SELECT DISTINCT refer_id FROM my_payout_daily WHERE DATE(date_time) = :onlyDate\" \r\n" + 
			"					.\" AND (unpaid_reason IS NOT NULL OR unpaid_reason = '')) HAVING order_count > 0", nativeQuery = true)
	List<checkIfNewMemberQualifiedModel> checkIfNewMemberQualified(@Param("preDate")  Date preDate,@Param("onlyDate")  Date onlyDate);
	public static interface checkIfNewMemberQualifiedModel {

		Integer getRefer_id();

		Integer getOrder_count();

		
	}
	
	@Query(value = "SELECT SUM(tree_incentive) AS tree_incentive, SUM(incentive) AS incentive FROM my_payout_daily WHERE refer_id = :referId", nativeQuery = true)
	prePayResultModel prePayResult(@Param("referId")  Integer referId);
	
	public static interface prePayResultModel{
		double getTree_incentive();
		double getIncentive();
	}
}
