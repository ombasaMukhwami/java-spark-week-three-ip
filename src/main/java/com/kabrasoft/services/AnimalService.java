package com.kabrasoft.services;

import com.kabrasoft.models.Animal;

public interface AnimalService {
    boolean createAnimal(Animal animal);
    Animal findAnimalById(int animalId);
}
