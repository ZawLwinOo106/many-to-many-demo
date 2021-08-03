package com.example.manytomanydemo;

import com.example.manytomanydemo.entity.Animal;
import com.example.manytomanydemo.service.AnimalFoodItemService;
import com.example.manytomanydemo.service.AnimalService;
import com.example.manytomanydemo.service.CageService;
import com.example.manytomanydemo.service.FoodItemService;
import com.example.manytomanydemo.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToManyDemoApplication implements CommandLineRunner {

    @Autowired
    private AnimalService animalService;
    @Autowired
    private CageService cageService;
    @Autowired
    private FoodItemService foodItemService;
    @Autowired
    private AnimalFoodItemService service;

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cageService.saveCageAnimal();
        animalService.saveAnimalCategory();
        foodItemService.saveFoodItemAndSupplier();
        service.save();

        JPAUtil.checkData("select * from cage");
        JPAUtil.checkData("select * from animal");
        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from food_item");
        JPAUtil.checkData("select * from supplier");
        JPAUtil.checkData("select * from animal_food_item");

    }
}
