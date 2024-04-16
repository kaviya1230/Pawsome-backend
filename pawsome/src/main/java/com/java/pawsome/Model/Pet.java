package com.java.pawsome.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "age")
    private int age;

    @Column(name = "available")
    private boolean available;

    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
    private PetDetail petDetail;


    public Pet(String name, String breed, int age, boolean available) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.available = available;
    }
}

