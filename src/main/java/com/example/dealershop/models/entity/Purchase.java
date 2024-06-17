package com.example.dealershop.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

//compra
@Entity
@Table(name = "purchases")
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Temporal(TemporalType.DATE)
    private Date date;
    private Double finalPrice;

    public Purchase() {
    }

    public Purchase(Long id, Car car, Date date, Double finalPrice) {
        this.id = id;
        this.car = car;
        this.date = date;
        this.finalPrice = finalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
