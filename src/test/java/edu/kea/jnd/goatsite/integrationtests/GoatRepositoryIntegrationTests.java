package edu.kea.jnd.goatsite.integrationtests;

import edu.kea.jnd.goatsite.model.Goat;
import edu.kea.jnd.goatsite.repository.GoatRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GoatRepositoryIntegrationTests {

    @Autowired
    GoatRepository goatRepository;

    @Test
    public void canGetAllGoats() {
        Iterable<Goat> goats = goatRepository.findAll();
    }

    @Test
    public void canCreateAndGetGoatByName() {

        // create a goat
        Goat goat = new Goat();
        goat.setName("Jeppe");
        goat.setDob(new Date());

        // add a goat to H2
        goatRepository.save(goat);

        // get the goat by its name
        Goat found = goatRepository.findFirstByName(goat.getName());

        // assert that we found the goat by its name
        assertThat(found.getName()).isEqualTo("Jeppe");
    }
}