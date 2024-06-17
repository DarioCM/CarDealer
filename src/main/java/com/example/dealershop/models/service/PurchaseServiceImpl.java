package com.example.dealershop.models.service;

import com.example.dealershop.models.dao.IPurchaseDao;
import com.example.dealershop.models.entity.Purchase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

    @Autowired
    private IPurchaseDao purchaseDao;

    @Override
    @Transactional
    public Purchase addPurchase(Purchase purchase) {
        return purchaseDao.save(purchase);
    }


}
