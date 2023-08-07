package com.kabrasoft.configs;

import org.sql2o.Sql2o;

public class DbConfig {
    public static Sql2o getDatabaseProduction(){
        return new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "postgres", "root");
    }
}
