package com.kabrasoft.services.impl;

import com.kabrasoft.models.Sighting;
import com.kabrasoft.services.SightingService;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class SightingServiceImpl implements SightingService {
    private  Connection connection;

    public SightingServiceImpl(Sql2o sql2o) {
        connection = sql2o.open();
    }

    public boolean  createSighting(Sighting sightings) {
        try {
            String query = "INSERT INTO sightings ( animal_id ,location, ranger_name) VALUES (:animalId,:location, :rangerName);";
            connection.createQuery(query)
                    .addParameter("animalId", sightings.getAnimalId())
                    .addParameter("location", sightings.getLocation())
                    .addParameter("rangerName",sightings.getRangerName())
                    .executeUpdate();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
