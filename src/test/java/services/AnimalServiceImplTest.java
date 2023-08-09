package services;


import com.kabrasoft.constants.AgeStatus;
import com.kabrasoft.constants.HealthStatus;
import com.kabrasoft.models.Animal;
import com.kabrasoft.services.AnimalService;
import com.kabrasoft.services.impl.AnimalServiceImpl;
import config.DbConfigTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

import static com.kabrasoft.constants.Species.ANIMAL;
import static com.kabrasoft.constants.Species.ENDANGERED_ANIMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class AnimalServiceImplTest {
    private AnimalService animalService;
    Animal savedAnimal;
    List<Animal> savedAnimalList;
    @BeforeEach
    void setUp() {
        Sql2o sql2o = DbConfigTest.getDatabaseTest();
        animalService = new AnimalServiceImpl(sql2o);
        savedAnimalList = new ArrayList<>();
        savedAnimalList.add(new Animal(ANIMAL, "elephant", HealthStatus.HEALTHY, AgeStatus.YOUNG));
        savedAnimalList.add(new Animal(ENDANGERED_ANIMAL, "white rhino", HealthStatus.ILL, AgeStatus.ADULT));
        savedAnimalList.add(new Animal(ANIMAL, "turtle", HealthStatus.OKAY, AgeStatus.NEW_BORN));
        savedAnimalList.add(new Animal(ANIMAL, "turtle", HealthStatus.OKAY, AgeStatus.ADULT));
        savedAnimalList.add(new Animal(ANIMAL, "zebra", HealthStatus.HEALTHY, AgeStatus.ADULT));
        savedAnimalList.add(new Animal(ANIMAL, "monkey", HealthStatus.OKAY, AgeStatus.ADULT));

        savedAnimal = savedAnimalList.get(0);
        savedAnimalList.forEach(animal-> animalService.createAnimal(animal));
    }



    @Test
    @DisplayName(value = "Create animal")
    void create_Animal_Test() {

        Animal animal = animalService.findAnimalById(1);

        assertEquals(savedAnimal.getName(), animal.getName());
        assertNotEquals(savedAnimal.getSpecies(), animal.getSpecies());
    }


    @Test
    @DisplayName(value = "Find animal by Id")
    void find_Animal_ById_Test() {
        Animal animals1 = animalService.findAnimalById(savedAnimal.getId());

        assertEquals(savedAnimal.getName(), animals1.getName());
        assertNotEquals(savedAnimal.getHealth(), animals1.getHealth());
    }


    @AfterEach
    void tearDown() {
        savedAnimalList.forEach(animal-> animalService.delete(animal.getId()));
    }
}
