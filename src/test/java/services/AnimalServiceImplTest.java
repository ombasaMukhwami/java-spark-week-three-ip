package services;


import com.kabrasoft.models.Animal;
import com.kabrasoft.services.AnimalService;
import com.kabrasoft.services.impl.AnimalServiceImpl;
import config.DbConfigTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class AnimalServiceImplTest {
    private AnimalService animalService;
    Animal savedAnimal;
    @BeforeEach
    void setUp() {
        Sql2o sql2o = DbConfigTest.getDatabaseTest();
        animalService = new AnimalServiceImpl(sql2o);
        savedAnimal = new Animal(1, "elephant", "healthy", "young");
        animalService.createAnimal(savedAnimal);
    }



    @Test
    @DisplayName(value = "Create animal")
    void create_Animal_Test() {

        Animal animal = animalService.findAnimalById(1);

        assertEquals(savedAnimal.getName(), animal.getName());
        assertNotEquals(savedAnimal.getAnimalTypeId(), animal.getAnimalTypeId());
    }


    @Test
    @DisplayName(value = "Find animal by Id")
    void findAnimalByIdTest() {
        Animal animals1 = animalService.findAnimalById(savedAnimal.getId());

        assertEquals(savedAnimal.getName(), animals1.getName());
        assertNotEquals(savedAnimal.getHealth(), animals1.getHealth());
    }


    @AfterEach
    void tearDown() {
        animalService.delete(savedAnimal.getId());
    }
}
