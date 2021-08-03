package com.example.manytomanydemo.service;

import com.example.manytomanydemo.entity.FoodItem;
import com.example.manytomanydemo.entity.Supplier;
import com.example.manytomanydemo.repo.FoodItemRepository;
import com.example.manytomanydemo.repo.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    @Transactional
    public void saveFoodItemAndSupplier() {
        FoodItem foodItem1 = new FoodItem("Beef", 2);
        FoodItem foodItem2 = new FoodItem("Deer", 3);
        FoodItem foodItem3 = new FoodItem("rabbit", 5);


        Supplier supplier1 = new Supplier("Animals Food", "09-555-555", "Yangon");
        Supplier supplier2 = new Supplier("Sneak Food", "09-444-444", "Yangon");

        foodItem1.setSupplier(supplier1);
        foodItem2.setSupplier(supplier1);
        foodItem3.setSupplier(supplier2);

        supplierRepository.save(supplier1);
        supplierRepository.save(supplier2);

        foodItemRepository.save(foodItem1);
        foodItemRepository.save(foodItem2);
        foodItemRepository.save(foodItem3);

    }
}
