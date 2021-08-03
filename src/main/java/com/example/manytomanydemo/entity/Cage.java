package com.example.manytomanydemo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cage_id")
    private Integer id;
    @Column(name = "cage_no")
    private int cageNo;
    private String location;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Animal animal;

    public Cage() {
    }

    public Cage(int cageNo, String location) {
        this.cageNo = cageNo;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCageNo() {
        return cageNo;
    }

    public void setCageNo(int cageNo) {
        this.cageNo = cageNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Cage{" +
                "id=" + id +
                ", cageNo=" + cageNo +
                ", location='" + location + '\'' +
                '}';
    }
}
