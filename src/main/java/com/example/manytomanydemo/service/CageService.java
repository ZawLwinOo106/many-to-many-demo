package com.example.manytomanydemo.service;

import com.example.manytomanydemo.entity.Animal;
import com.example.manytomanydemo.entity.Cage;
import com.example.manytomanydemo.repo.AnimalRepository;
import com.example.manytomanydemo.repo.CageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CageService {

    @Autowired
    private CageRepository cageRepository;
    @Autowired
    private AnimalRepository animalRepository;

    @Transactional
    public void saveCageAnimal() {
        Cage cage1 = new Cage(1, "Yangon");
        Cage cage2 = new Cage(2, "Mandalay");

        Animal animal1 = new Animal("Lion", 2);
        Animal animal2 = new Animal("Zebra", 5);

        cage1.setAnimal(animal1);
        cage2.setAnimal(animal2);

        cageRepository.save(cage1);
        cageRepository.save(cage2);


    }
}
