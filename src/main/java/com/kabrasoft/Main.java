package com.kabrasoft;

import com.kabrasoft.configs.DbConfig;
import com.kabrasoft.constants.Species;
import com.kabrasoft.models.Animal;
import com.kabrasoft.models.Ranger;
import com.kabrasoft.models.Sighting;
import com.kabrasoft.services.AnimalService;
import com.kabrasoft.services.RangerService;
import com.kabrasoft.services.SightingService;
import com.kabrasoft.services.impl.AnimalServiceImpl;
import com.kabrasoft.services.impl.RangerServiceImpl;
import com.kabrasoft.services.impl.SightingServiceImpl;
import com.kabrasoft.utils.Helper;
import org.sql2o.Sql2o;

import java.util.HashMap;

import static spark.Spark.staticFileLocation;
import static spark.Spark.get;
import static spark.Spark.post;


public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        Sql2o sql2o = DbConfig.getDatabaseProduction();
        AnimalService animalService = new AnimalServiceImpl(sql2o);
        SightingService sightingService = new SightingServiceImpl(sql2o);
        RangerService rangerService = new RangerServiceImpl(sql2o);
        get("/", (req, res) -> {
            return Helper.render(new HashMap<>(), "index.hbs");
        });
        get("/wildlife/add", (req, res) -> {
            return Helper.render(new HashMap<>(), "wildlife-details.hbs");
        });
        get("/animal/add", (req, res) -> {
            return Helper.render(new HashMap<>(), "animal-details.hbs");
        });

        post("/create-sighting", (req, res) -> {
            String id = req.queryParams("id");
            String location = req.queryParams("location");
            Integer ranger = Integer.parseInt(req.queryParams("range_id"));

            try {
                if (id == null || id.length() == 0
                        || location == null || location.length() == 0 || ranger == null) {
                    throw new IllegalArgumentException("invalid input all fields have to be provided");
                }
                int latestId = Integer.valueOf(id);
                Animal animal = animalService.findAnimalById(latestId);
                Sighting sightings = new Sighting(animal.getId(), location, ranger);

                //save sighting
                sightingService.createSighting(sightings);

            } catch (Exception e) {

                System.out.print(e.getMessage());
            }

            res.redirect("/");
            return null;
        });

        post("/create-animal", (req, res) -> {
            Species category = Helper.getSpecies(req.queryParams("category"));
            String name = req.queryParams("name");
            String health = req.queryParams("health");
            String age = req.queryParams("age");

            try {
                if (name.length() == 0 || health == null || health.length() == 0 || age == null || age.length() == 0) {
                    System.out.print(category);
                    System.out.print(name);
                    System.out.print(health);
                    System.out.print(age);
                    throw new IllegalArgumentException("invalid input all fields have to be provided");
                }

                Animal animals = new Animal(category, name, health, age);
                animalService.createAnimal(animals);

            } catch (Exception e) {

                System.out.print(e.getMessage());
            }

            res.redirect("/");
            return null;
        });
    }
}