package com.example.dealershop.models.dao;

import com.example.dealershop.models.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface IPurchaseDao extends CrudRepository<Purchase, Long> {
}
