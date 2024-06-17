package com.example.dealershop.controller;

import com.example.dealershop.models.entity.Car;
import com.example.dealershop.models.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class CarRestController {

    private ICarService carService;

    @Autowired
    public CarRestController(ICarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public Car create(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping("/cars")
    public List<Car> index() {
        return carService.getCars();
    }

    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        carService.deleteCar(id);
    }

}
