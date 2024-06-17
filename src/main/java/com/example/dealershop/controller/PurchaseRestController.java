package com.example.dealershop.controller;

import com.example.dealershop.models.entity.Purchase;
import com.example.dealershop.models.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/api")
public class PurchaseRestController {

    private IPurchaseService purchaseService;

    @Autowired
    public PurchaseRestController(IPurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/purchase")
    @ResponseStatus(HttpStatus.CREATED)
    public Purchase create(@Valid @RequestBody Purchase purchase){
        return purchaseService.addPurchase(purchase);
    }


}
