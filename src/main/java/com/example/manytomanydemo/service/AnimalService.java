package com.example.manytomanydemo.service;

import com.example.manytomanydemo.entity.Animal;
import com.example.manytomanydemo.entity.Cage;
import com.example.manytomanydemo.entity.Category;
import com.example.manytomanydemo.repo.AnimalRepository;
import com.example.manytomanydemo.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void saveAnimalCategory() {
        Animal animal1 = new Animal("Tiger", 2);
        Animal animal2 = new Animal("Bear", 3);
        Animal animal3 = new Animal("Snake", 2);

        Category c1 = new Category("Mammals");
        Category c2 = new Category("Reptiles");

        animal1.setCategory(c1);
        animal2.setCategory(c1);
        animal3.setCategory(c2);

        categoryRepository.save(c1);
        categoryRepository.save(c2);

        animalRepository.save(animal1);
        animalRepository.save(animal2);
        animalRepository.save(animal3);

    }
}
