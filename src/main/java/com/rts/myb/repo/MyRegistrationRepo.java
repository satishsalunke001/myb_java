package com.rts.myb.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyRegistration;

@Repository
public interface MyRegistrationRepo extends JpaRepository<MyRegistration, String> {

	Optional<MyRegistration> findById(String id);

	List<MyRegistration> findByPan(String panNo);
	MyRegistration findByEmailAddress(String emailAddress);

	MyRegistration findByReferId(Integer referId); //To be used in getLeaderbyReferId for weeklyPayout

	@Query("select n from MyRegistration n where n.isFreezed = ?1")
	List<MyRegistration> getActInActMembers(Integer flag);

	@Query(value = "SELECT * FROM my_registration WHERE doc_name IS NULL OR doc_name =''", nativeQuery = true)
	List<MyRegistration> getAbsentKycList();
	
	@Query(value = "SELECT DISTINCT mr.refer_id, mr.name, mr.last_name, SUM(mp.total_PV) AS total_PV, mr.sponsor_by, mr.sponsor_id, mr.mobile_number, mr.date_entered  FROM my_registration mr, my_member_package mp WHERE mp.power_leg=0 AND mr.refer_id = mp.refer_id AND mp.payment_status = 1 GROUP BY mr.refer_id", nativeQuery = true)
	List<PaidUnPaidListModel> paidMemberList();
	
	@Query(value = "SELECT *  FROM  my_registration WHERE is_freezed = 1 AND  date_entered  <= DATE_ADD(date_entered, INTERVAL 30 Day)", nativeQuery = true)
	List<MyRegistration> thirtyDayInActiveMemberList();
	
	@Query(value = "SELECT *  FROM  my_registration WHERE is_freezed = 1 AND  date_entered  <= DATE_ADD(date_entered, INTERVAL 60 Day)", nativeQuery = true)
	List<MyRegistration> sixtyDayInActiveMemberList();
	
	@Query(value = "SELECT *  FROM  my_registration WHERE is_freezed = 1 AND  date_entered  <= DATE_ADD(date_entered, INTERVAL 90 Day)", nativeQuery = true)
	List<MyRegistration> ninetyDayInActiveMemberList();
	
	
	@Query(value = "SELECT * FROM my_registration WHERE is_transfer = 1", nativeQuery = true)
	List<MyRegistration> getTransferIdsList();
	
	
	@Query(value = "SELECT * FROM my_registration WHERE is_leader = 1", nativeQuery = true)
	List<MyRegistration> getLeaderList();
	
	@Query(value = "SELECT * FROM my_registration WHERE refer_id = :refer_id AND is_freezed=0", nativeQuery = true)
	MyRegistration checkReferId(@Param("refer_id") int refer_id);
	
	
	@Query(value = "SELECT refer_id FROM my_registration WHERE sponsor_id = :sponsor_id AND left_node = 1 AND invalid = 0", nativeQuery = true)
	List<Integer> getLeftNwReferId(@Param("sponsor_id") int sponsor_id);
	
	@Query(value = "SELECT refer_id FROM my_registration WHERE sponsor_id = :sponsor_id AND right_node = 1 AND invalid = 0", nativeQuery = true)
	List<Integer> getRightNwReferId(@Param("sponsor_id") int sponsor_id);

	@Query(value = "SELECT DISTINCT mr.refer_id, mr.name, mr.last_name, SUM(mp.total_PV) AS total_PV, mr.sponsor_by, mr.sponsor_id, mr.mobile_number, mr.date_entered  FROM my_registration mr, my_member_package mp WHERE mp.power_leg != 0 AND mr.refer_id=mp.refer_id AND mp.payment_status = 1 GROUP BY mr.refer_id", nativeQuery = true)
	List<PaidUnPaidListModel> unPaidMemberList();
	
	@Query(value = "SELECT refer_id FROM my_registration WHERE sponsor_id = :sponsor_id AND left_node = 1 AND invalid = 0", nativeQuery = true)
	List<Integer> getLeftNwReferIds(@Param("sponsor_id") int sponsor_id);
	
	@Query(value = "SELECT refer_id FROM my_registration WHERE sponsor_id = :sponsor_id AND right_node = 1 AND invalid = 0", nativeQuery = true)
	List<Integer> getRightNwReferIds(@Param("sponsor_id") int sponsor_id);
	
	@Query(value = "SELECT COUNT(DISTINCT mreg.id) AS direct_count FROM my_registration mreg, my_member_package mmp WHERE mreg.sponsor_by = :refer_id AND mreg.invalid = 0 AND mreg.refer_id = mmp.refer_id AND mmp.payment_status = 1 AND mmp.deleted = 0", nativeQuery = true)
	Integer directCount(@Param("refer_id") int refer_id);
	
	
	@Query(value = "SELECT COUNT(DISTINCT mreg.id) AS direct_count FROM my_registration mreg, my_member_package mmp WHERE mreg.sponsor_by = :refer_id AND mreg.invalid = 0 AND mreg.refer_id = mmp.refer_id AND mmp.payment_status = 1 AND mmp.deleted = 0 AND DATE(mmp.date_entered) <= :date", nativeQuery = true)
	Integer directMembers(@Param("refer_id") int refer_id,@Param("date") Date date);
	

	public static interface PaidUnPaidListModel {

		String getRefer_id();

		String getName();

		String getLast_name();

		double getTotal_pv();

		Integer getSponsor_by();

		Integer getSponsor_id();

		String getMobile_number();

		Date getDate_entered();
	}

}
