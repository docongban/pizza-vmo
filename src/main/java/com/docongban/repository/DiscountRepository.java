package com.docongban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docongban.entity.Discount;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

    @Query(nativeQuery = true, value = "select * from discount d order by d.value asc")
    List<Discount> getAllSort();
}
