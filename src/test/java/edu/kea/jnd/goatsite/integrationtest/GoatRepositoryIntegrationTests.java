package edu.kea.jnd.goatsite.integrationtest;
import edu.kea.jnd.goatsite.model.Goat;


import edu.kea.jnd.goatsite.repository.GoatRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class GoatRepositoryIntegrationTests {
    Iterable<Goat> goats;

    @Autowired
    GoatRepository goatRepository;

    @Test
    public void CanWeGetAllGoats(){
        goats =  goatRepository.findAll();
    }

    @Test
    public void canWeCreateAndGetGoat() {
        //create goat
        Goat goat = new Goat();
        goat.setName("Jeppe");
        goat.setDob(new Date());

        // add a goat to H2
        goatRepository.save(goat);

        // get the goat by its name
        goatRepository.findFirstByName(goat.getName());

        // assert that we found the goat by its name
        // assertThat(found.getName("Jeppe"));



    }

}