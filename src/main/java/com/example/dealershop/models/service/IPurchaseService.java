package com.example.dealershop.models.service;

import com.example.dealershop.models.entity.Purchase;

import java.util.List;
import java.util.Objects;

public interface IPurchaseService {

    Purchase addPurchase(Purchase purchase);

    List<Object[]>  getSalesReport();

}
