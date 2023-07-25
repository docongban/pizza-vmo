package com.docongban.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.docongban.entity.OrderAccount;

@Repository
public interface OrderAccountRepository extends JpaRepository<OrderAccount, Integer> {

	@Query(value = "SELECT MAX(Id) FROM order_account", nativeQuery = true)
	public int getMaxId();
	
	@Modifying
	@Query(value = "UPDATE order_account SET order_status = 1 WHERE id = ?1 ", nativeQuery = true)
	public void updateStatus(int id);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE order_account SET evulate_status = 1 WHERE id = ?1")
	void updateStatusEvulate(int orderAccountId);

	@Query(nativeQuery = true, value = "select * from order_account oa order by oa.order_date asc")
	List<OrderAccount> findAllSortAsc();
	
	@Query(value = "SELECT * FROM order_account oa where account_id=?1 order by oa.order_date asc", nativeQuery = true)
	List<OrderAccount> findOrderAccountByAccountId(int accountId);

	@Query(nativeQuery = true, value = "select DATE_FORMAT(DATE(oa.order_date), '%d-%m-%Y') as date, sum(od.product_price * od.order_quantity) as turnover from order_detail od \n" +
			"join order_account oa on od.order_account_id=oa.id \n" +
			"where YEAR(CURDATE()) = YEAR(oa.order_date) and MONTH(oa.order_date) = ?1 \n" +
			"group by date order by date asc")
	List<Object[]> getByMonth(String month);

	@Query(nativeQuery = true, value = "select DATE_FORMAT(DATE(oa.order_date), '%d-%m-%Y') as date,  sum(oa.total), sum(oa.total_after_discount) from order_account oa\n" +
			"where YEAR(CURDATE()) = YEAR(oa.order_date) and MONTH(oa.order_date) = ?1 \n" +
			"group by date order by date asc")
	List<Object[]> getAllByMonth(String month);

	@Query(nativeQuery = true, value = "select MONTH(oa.order_date),sum(oa.total),sum(oa.total_after_discount) from order_account oa\n" +
			"where YEAR(CURDATE()) = YEAR(oa.order_date)\n" +
			"group by MONTH(oa.order_date)")
	List<Object[]> getAllTotalByMonth();

	Optional<OrderAccount> findById(Integer id);
}
