package com.example.manytomanydemo.service;

import com.example.manytomanydemo.entity.Animal;
import com.example.manytomanydemo.entity.FoodItem;
import com.example.manytomanydemo.repo.AnimalRepository;
import com.example.manytomanydemo.repo.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalFoodItemService {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private FoodItemRepository foodItemRepository;

    @Transactional
    public void save(){
        Animal a1=findAnimal(1);
        Animal a2=findAnimal(2);
        Animal a3=findAnimal(5);

        FoodItem f1=findFoodItem(1);
        FoodItem f2=findFoodItem(2);

        a1.addFoodItem(f1);
        a1.addFoodItem(f2);
        a2.addFoodItem(f1);
        a2.addFoodItem(f2);
        a3.addFoodItem(f2);

        animalRepository.save(a1);
        animalRepository.save(a2);
        animalRepository.save(a3);

    }

    public Animal findAnimal(int id){
        return animalRepository.getById(id);
    }

    public FoodItem findFoodItem(int id){
        return foodItemRepository.getById(id);
    }
}
