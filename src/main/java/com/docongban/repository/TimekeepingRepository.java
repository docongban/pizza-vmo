package com.docongban.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.docongban.entity.Timekeeping;

@Repository
public interface TimekeepingRepository extends JpaRepository<Timekeeping, Integer>{
	
	@Query(value = "SELECT * FROM timekeeping WHERE account_id = ?1", nativeQuery = true)
	List<Timekeeping> findByAccountId(Integer accountId);

	@Query(nativeQuery = true,value = "select * from timekeeping t\n" +
			"where YEAR(CURDATE()) = YEAR(t.date) and MONTH(t.date) = ?1")
	List<Timekeeping> getByMonth(String month);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM timekeeping WHERE account_id = ?1", nativeQuery = true)
	void deleteByAccountId(Integer accountId);
}
