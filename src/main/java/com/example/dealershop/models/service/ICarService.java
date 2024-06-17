package com.example.dealershop.models.service;

import com.example.dealershop.models.entity.Car;

import java.util.List;

// We would like to have a way to manage the cars the shop is selling.
// Implement a service to store, retrieve and delete car data.

public interface ICarService {

    Car addCar(Car car);

    List<Car> getCars();

    void deleteCar(Long id);


}
