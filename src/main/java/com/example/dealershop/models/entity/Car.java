package com.example.dealershop.models.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "cars")
public class Car implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String model;
   private String brand;
   private Integer year;
   private Double price;

   @OneToMany(mappedBy = "car")
   private List<Purchase> purchases;

   public Car(Long id, String model, String brand, Integer year, Double price) {
      this.id = id;
      this.model = model;
      this.brand = brand;
      this.year = year;
      this.price = price;
   }

   public Car() {

   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public String getBrand() {
      return brand;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public Integer getYear() {
      return year;
   }

   public void setYear(Integer year) {
      this.year = year;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }
}
