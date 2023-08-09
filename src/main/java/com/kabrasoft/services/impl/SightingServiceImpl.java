package com.kabrasoft.services.impl;

import com.kabrasoft.models.Sighting;
import com.kabrasoft.services.SightingService;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class SightingServiceImpl implements SightingService {
    private  Connection connection;

    public SightingServiceImpl(Sql2o sql2o) {
        connection = sql2o.open();
    }

    public boolean  createSighting(Sighting sightings) {
        try {
            String query = "INSERT INTO sightings ( animal_id ,location, ranger_id) VALUES (:animalId,:location, :rangerId);";
            connection.createQuery(query)
                    .addParameter("animalId", sightings.getAnimalId())
                    .addParameter("location", sightings.getLocation())
                    .addParameter("rangerId",sightings.getRangerId())
                    .executeUpdate();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public List<Sighting> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {

        try {
            String query = "DELETE FROM sightings WHERE id = :id;";
            connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();

            return true;
        } catch (Exception e) {

        }
        return false;
    }
}
