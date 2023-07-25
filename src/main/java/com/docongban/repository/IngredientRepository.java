package com.docongban.repository;

import com.docongban.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {

    @Query(nativeQuery = true, value = "select * from ingredient i\n" +
            "where YEAR(CURDATE()) = YEAR(i.import_time) and MONTH(i.import_time) = ?1 \n" +
            "order by i.import_time desc")
    List<Ingredient> getByMonth(String month);

    @Query(nativeQuery = true, value = "select MONTH(i.import_time),sum(i.price) from ingredient i\n" +
            "where YEAR(CURDATE()) = YEAR(i.import_time)\n" +
            "group by MONTH(i.import_time)")
    List<Object[]> getAllByMonth();
}
