package com.example.dealershop.models.dao;

import com.example.dealershop.models.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface ICarDao extends CrudRepository<Car, Long> {
}
