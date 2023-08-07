package com.kabrasoft.services;

import com.kabrasoft.models.Animal;

import java.util.List;

public interface AnimalService {
    boolean createAnimal(Animal animal);
    Animal findAnimalById(int animalId);
    List<Animal> findAll();
    boolean delete(int id);
}
