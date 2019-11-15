package edu.kea.jnd.goatsite.repository;

import edu.kea.jnd.goatsite.model.Gender;
import edu.kea.jnd.goatsite.model.Goat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoatRepository extends CrudRepository<Goat, Long> {
    Iterable<Goat> findAllByName(String name);
    Goat findFirstByName(String name);

   /* Goat findByPassword(String password);
    Goat findByMail(String mail);*/

    Iterable<Goat> findAllByGender(Gender gender);

    @Query(value = "SELECT password FROM goats WHERE username =?" , nativeQuery = true)
    Iterable<Goat> findGoatByUserNameAndPassword(String username);


    @Query(value = "SELECT * FROM Goats g WHERE g.id < 2", nativeQuery = true)
    Iterable<Goat> findTheOldTimers();

    @Query(value = "SELECT * FROM goats g WHERE g.id = ?", nativeQuery = true)
    Goat findRandomGoat(int id);

    @Query(value = "SELECT MAX(id) FROM goats", nativeQuery = true)
    int findMaxValue();


}

