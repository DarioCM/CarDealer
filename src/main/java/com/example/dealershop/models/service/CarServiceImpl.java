package com.example.dealershop.models.service;

import com.example.dealershop.models.dao.ICarDao;
import com.example.dealershop.models.entity.Car;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private ICarDao carDao;

    @Override
    @Transactional
    public Car addCar(Car car) {
        return carDao.save(car);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> getCars() {
        return (List<Car>) carDao.findAll();
    }

    @Override
    @Transactional
    public void deleteCar(Long id) {
        carDao.deleteById(id);
    }

}
