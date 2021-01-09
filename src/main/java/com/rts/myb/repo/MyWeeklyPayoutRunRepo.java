package com.rts.myb.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyWeeklyPayoutRun;

@Repository
public interface MyWeeklyPayoutRunRepo extends JpaRepository<MyWeeklyPayoutRun, Integer>{

	@Query(value = "SELECT * from my_weeklypayout_run where status=0", nativeQuery = true)
	List<MyWeeklyPayoutRun> getWeeklyPayoutByStatusZero();
	
	
	@Query(value = "SELECT * from my_weeklypayout_run where payout_end_date >=:date", nativeQuery = true)
	List<MyWeeklyPayoutRun> checkPayoutEntry(@Param("date") Date date);		
	
	
	@Query(value = "SELECT id, payout_end_date from my_weeklypayout_run order by id DESC Limit 1", nativeQuery = true)
    MyWeeklyPayoutRun setPreviousPayoutID();
	
	
	
	
	@Query(value = "SELECT CONCAT(mr.name, ' ', mr.last_name) AS MemberName, mpd.refer_id AS MemberId, SUM(mpd.tree_incentive) AS TreeIncentive, SUM(mpd.direct_incentive) AS direct_incentive, SUM(mpd.incentive) AS Incentive, mr.bank_name AS bank_name, mr.account_number AS account_number,mr.ifsc_code AS ifsc_code, mr.pan_no AS pan_no, CONCAT('https://s3.ap-south-1.amazonaws.com/mybooster/KYC/', '' ,mr.doc_name) as KYC FROM my_payout_main mpd, my_registration mr, my_payout_run mwr WHERE  mpd.payout_id = mwr.id AND DATE(mwr.payout_start_date) >= :startDate AND DATE(mwr.payout_end_date) <= :endDate AND mpd.refer_id = mr.refer_id GROUP BY mpd.refer_id HAVING Incentive > 0", nativeQuery = true)
	List<WeeklyPayoutModel> weeklyPayoutDetail(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	public static interface WeeklyPayoutModel {

		String getMemberName();
		Integer getMemberId();

		Double getTreeIncentive();

	    Double getDirect_incentive();

		Double getIncentive();

		String getBank_name();

		String getAccount_number();

		String getIfsc_code();

		String getPan_no();

		String getKYC();

	}//work done onlu queries 18-12-2020
}
