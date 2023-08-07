package services;

import com.kabrasoft.models.Sighting;
import com.kabrasoft.services.SightingService;
import com.kabrasoft.services.impl.SightingServiceImpl;
import config.DbConfigTest;
import org.junit.jupiter.api.BeforeEach;
import org.sql2o.Sql2o;

public class SightingServiceImplTest {

    SightingService sightingService;
    Sighting savedSighting;
    @BeforeEach
    void setUp() {
        Sql2o sql2o = DbConfigTest.getDatabaseTest();
        sightingService = new SightingServiceImpl(sql2o);
        savedSighting = new Sighting(1, "kakamega forest", "ombasa");
    }



}
