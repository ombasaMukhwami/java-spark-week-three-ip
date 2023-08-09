package services;

import com.kabrasoft.models.Sighting;
import com.kabrasoft.services.SightingService;
import com.kabrasoft.services.impl.SightingServiceImpl;
import config.DbConfigTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

public class SightingServiceImplTest {

    SightingService sightingService;
    Sighting savedSighting;
    List<Sighting> savedSightingList;
    @BeforeEach
    void setUp() {
        Sql2o sql2o = DbConfigTest.getDatabaseTest();
        sightingService = new SightingServiceImpl(sql2o);
        savedSightingList = new ArrayList<>();
        savedSightingList.add(new Sighting(1, "Zone A", 1));
        savedSightingList.add(new Sighting(2, "Near the River", 1));
        savedSightingList.add(new Sighting(3, "NE Quadrant", 1));
        savedSightingList.forEach(sighting-> sightingService.createSighting(sighting));
        savedSighting = savedSightingList.get(0);
    }


    @AfterEach
    void tearDown() {
        savedSightingList.forEach(sighting-> sightingService.delete(sighting.getId()));
    }
}
