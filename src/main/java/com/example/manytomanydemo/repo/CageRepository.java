package com.example.manytomanydemo.repo;

import com.example.manytomanydemo.entity.Cage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageRepository extends JpaRepository<Cage,Integer> {
}
