package com.docongban.repository;

import java.util.List;

import com.docongban.payload.ProductSelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.docongban.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findAllByCategoryId(int id);
	List<Product> findAll();

	//search
	@Query(value = "select * from product where title like %?1% ", nativeQuery = true)
	public List<Product> searchByName(String keyword);
	
	@Query(value = "select * from product where id= ?1 ", nativeQuery = true)
	public Product findProductById(int id);

//	@Query(nativeQuery = true, value = "select od.product_title,od.product_content,od.product_thumbnail,od.product_price,count(od.product_title) as countProduct from order_detail od\n" +
//			"join order_account oa on od.order_account_id=oa.id\n" +
//			"where YEAR(CURDATE()) = YEAR(oa.order_date) and MONTH(oa.order_date) = ?1 \n" +
//			"group by  od.product_title,od.product_content,od.product_thumbnail,od.product_price\n" +
//			"order by countProduct desc " +
//			"limit ?2")
	@Query(nativeQuery = true, value = "select od.product_title,od.product_content,od.product_thumbnail,od.product_price ,sum(od.order_quantity) from order_detail od \n" +
			"join order_account oa on od.order_account_id=oa.id\n" +
			"where YEAR(CURDATE()) = YEAR(oa.order_date) and MONTH(oa.order_date) = ?1 \n" +
			"group by od.product_title,od.product_content,od.product_thumbnail,od.product_price\n" +
			"order by sum(od.order_quantity) desc\n" +
			"limit ?2")
	List<Object[]> getTop5Selling(String month,Integer top);
}
