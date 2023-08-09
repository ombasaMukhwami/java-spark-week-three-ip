package com.kabrasoft.services.impl;

import com.kabrasoft.models.Ranger;
import com.kabrasoft.services.RangerService;
import lombok.extern.slf4j.Slf4j;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Slf4j
public class RangerServiceImpl implements RangerService {

    private Connection connection;

    public RangerServiceImpl(Sql2o sql2o) {
        connection = sql2o.open();
    }

    @Override
    public boolean createRanger(Ranger ranger) {
        return false;
    }

    @Override
    public Ranger findById(int id) {
        try {

            Ranger ranger = connection.createQuery("SELECT * FROM rangers WHERE id = :id;")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranger.class);

            return ranger;
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }

        return null;
    }

    @Override
    public Ranger findByName(String name) {
        try {

            Ranger ranger = connection.createQuery("SELECT * FROM rangers WHERE name = :name;")
                    .addParameter("name", name)
                    .executeAndFetchFirst(Ranger.class);

            return ranger;
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }

        return null;
    }

    @Override
    public List<Ranger> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            String query = "DELETE FROM rangers WHERE id = :id;";
            connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }
}
