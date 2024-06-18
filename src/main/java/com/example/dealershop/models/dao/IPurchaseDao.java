package com.example.dealershop.models.dao;

import com.example.dealershop.models.entity.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPurchaseDao extends CrudRepository<Purchase, Long> {

    @Query("SELECT p.car.brand, MONTH(p.date), SUM(p.finalPrice) FROM Purchase p GROUP BY p.car.brand, MONTH(p.date)")
    List<Object[]> getSalesReport();

}
