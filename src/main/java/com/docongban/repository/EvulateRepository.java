package com.docongban.repository;

import com.docongban.entity.Evulate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvulateRepository extends JpaRepository<Evulate, Integer> {
    Evulate findByOrderAccountId(Integer id);

    @Query(nativeQuery = true,value = "(select (count(*)/(select count(*) from evulate))*100 from evulate e where e.food_rate=0) \n" +
            "union all (select (count(*)/(select count(*) from evulate))*100 from evulate e where e.food_rate=1)\n" +
            "union all (select (count(*)/(select count(*) from evulate))*100 from evulate e where e.food_rate=2)\n" +
            "union all (select (count(*)/(select count(*) from evulate))*100 from evulate e where e.service_rate=0) \n" +
            "union all (select (count(*)/(select count(*) from evulate))*100 from evulate e where e.service_rate=1)\n" +
            "union all (select (count(*)/(select count(*) from evulate))*100 from evulate e where e.service_rate=2)")
    List<Double> getPercent();
}
