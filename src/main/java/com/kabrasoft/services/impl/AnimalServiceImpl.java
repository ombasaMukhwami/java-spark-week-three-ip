package com.kabrasoft.services.impl;

import com.kabrasoft.models.Animal;
import com.kabrasoft.services.AnimalService;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class AnimalServiceImpl implements AnimalService {
    private  Connection connection;

    public AnimalServiceImpl(Sql2o sql2o) {
        connection = sql2o.open();
    }

    public  boolean  createAnimal(Animal animals) {
        try {
            String query = "INSERT INTO animals ( type ,name, health, age) VALUES (:type,:name, :health, :age);";
            connection.createQuery(query)
                    .addParameter("type", animals.getAnimalTypeId())
                    .addParameter("name", animals.getName())
                    .addParameter("health",animals.getHealth())
                    .addParameter("age",animals.getAge())
                    .executeUpdate();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }


    public  Animal findAnimalById(int animalId) {
        try {
            String queryAnimals= "SELECT * FROM animals WHERE id = :id;";
            Animal animals = connection.createQuery(queryAnimals)
                    .addParameter("id", animalId)
                    .executeAndFetchFirst(Animal.class);
//
            return animals;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return  null;
        }
    }
}
