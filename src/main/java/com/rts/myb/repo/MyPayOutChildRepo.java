package com.rts.myb.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyPayoutChild;

@Repository
public interface MyPayOutChildRepo extends JpaRepository<MyPayoutChild, Integer>{

	@Query(value = "SELECT COUNT(DISTINCT mpc.package_id) AS total_count FROM my_payout_child mpc, my_member_package mmp WHERE mpc.package_id = mmp.id AND DATE(mpc.update_time) = :date", nativeQuery = true)
	Integer checkPurchase(@Param("date") Date date);
	
	@Query(value = "SELECT SUM(mpc.pv) AS left_pv FROM my_payout_child mpc, my_member_package mmp  WHERE mpc.package_id = mmp.id AND mpc.sponsor_id = :sponsorId AND DATE(mpc.update_time) = :date AND mpc.node='l' AND mpc.power_leg = 0 AND mmp.power_leg = 0", nativeQuery = true)
    Integer calculateLeftLegAmount(@Param("date") Date date, @Param("sponsorId") Integer sponsorId);
	
	@Query(value = "SELECT sum(mpc.pv) AS right_pv FROM my_payout_child mpc, my_member_package mmp WHERE mpc.package_id = mmp.id AND mpc.sponsor_id = :sponsorId AND DATE(mpc.update_time) = :date AND mpc.node='r' AND mpc.power_leg = 0 AND mmp.power_leg = 0", nativeQuery = true)
    Integer calculateRightLegAmount(@Param("date")  Date date, @Param("sponsorId")  Integer sponsorId);
	
	@Query(value = "SELECT SUM(mpc.pv) AS left_pv FROM my_payout_child mpc, my_member_package mmp WHERE mpc.package_id = mmp.id AND mpc.sponsor_id = :sponsorId AND DATE(mpc.update_time) = :date AND mpc.node='l' AND mpc.power_leg = 1", nativeQuery = true)
    Integer calculateLeftLegPowerLegPv(@Param("date") Date date, @Param("sponsorId") Integer sponsorId);
	
	@Query(value = "SELECT SUM(mpc.pv) AS right_pv FROM my_payout_child mpc, my_member_package mmp  WHERE mpc.package_id = mmp.id AND mpc.sponsor_id = :sponsorId AND DATE(mpc.update_time) = :date AND mpc.node='r' AND mpc.power_leg = 1", nativeQuery = true)
    Integer calculateRightLegPowerLegPv(@Param("date") Date date, @Param("sponsorId") Integer sponsorId);
	
	@Query(value = "UPDATE my_payout_child mpc, my_member_package mmp SET mpc.applied = 1 WHERE mpc.package_id = mmp.id AND mpc.sponsor_id = :sponsorId AND DATE(mpc.update_time) = :date AND mpc.power_leg = 0 AND mmp.power_leg = 0", nativeQuery = true)
    void updatePayChild(@Param("date") Date date, @Param("sponsorId") Integer sponsorId);
	
	
	@Query(value = "SELECT DISTINCT mpc.sponsor_id AS refer_id FROM my_payout_child mpc, my_registration mr WHERE mr.refer_id = mpc.sponsor_id AND mr.invalid = 0 AND DATE(mpc.update_time) = :date", nativeQuery = true)
    List<Integer> sponsorIds(@Param("date") Date date);
	
	@Query(value = "SELECT mpc.sponsor_id, SUM(mpc.pv) AS pv, SUM(mpc.purchase) AS purchase FROM my_payout_child mpc, my_registration mr WHERE mpc.sponsor_id = mr.sponsor_by AND mpc.refer_id = mr.refer_id AND mr.invalid = 0 AND mpc.power_leg = 0 AND DATE(mpc.update_time) = :date GROUP BY mpc.sponsor_id", nativeQuery = true)
	List<DirectPayOutModel> directPayOut(@Param("date") Date date);
	public static interface DirectPayOutModel {

		Integer getSponsor_by();

		Integer getSponsored_id();

		double getPv();

		double getPurchase();
	}
	
}
