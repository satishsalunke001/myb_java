package com.rts.myb.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyMemberPackage;

@Repository
public interface MyMemberPackageRepo extends JpaRepository<MyMemberPackage, Integer> {

	MyMemberPackage findByReferId(String id);
	
	@Query(value = "SELECT COUNT(id) AS total_count FROM my_member_package WHERE refer_id = :referId AND deleted = 0 AND payment_status = 1", nativeQuery = true)
    Integer checkIfMemberIsPaid(@Param("referId") Integer referId);
	
	@Query(value = "SELECT DISTINCT DATE(date_entered) AS purchase_date FROM my_member_package WHERE payment_status='1' AND upload_volume='1' AND deleted='0' AND refer_id = :referId AND DATE(date_entered) <= :enteredDate ORDER BY date_modified ASC LIMIT 3", nativeQuery = true)
    List<Date> uniqueDate(@Param("referId") Integer referId, @Param("enteredDate") Date enteredDate);
	
	@Query(value = "SELECT sum(total_PV) AS capping FROM my_member_package WHERE payment_status='1' AND upload_volume='1' AND deleted='0' AND refer_id = :referId AND DATE(date_entered) IN :cappingDates", nativeQuery = true)
    Integer capping(@Param("referId") Integer referId,  @Param("cappingDates") List<Date> cappingDates);
	
	@Query(value = "SELECT SUM(total_PV) AS total_capping FROM my_member_package WHERE refer_id = ? AND deleted = 0 AND payment_status = 1", nativeQuery = true)
    Integer directCapping(@Param("referId") Integer referId);
	
	
	
}
