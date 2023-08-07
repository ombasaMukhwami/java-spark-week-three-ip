package config;

import org.sql2o.Sql2o;

public class DbConfigTest {
    public static Sql2o getDatabaseTest(){
        return new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "postgres", "root");
    }
}
