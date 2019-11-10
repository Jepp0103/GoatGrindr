package edu.kea.jnd.goatsite.repository;
<<<<<<< HEAD
import edu.kea.jnd.goatsite.model.Goat;
import edu.kea.jnd.goatsite.model.Match;
import org.springframework.data.jpa.repository.Query;
=======

import edu.kea.jnd.goatsite.model.Match;
>>>>>>> a0f2aa8e72608f50baae8996d1a3a3d2af2475f7
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface MatchRepository extends CrudRepository<Match, Long> {
    Iterable<Match> findAllByGoat1Id(Long goat1Id);
    Iterable<Match> findAllByGoat2Id(Long goat2Id);

    @Query(value = "SELECT * FROM matches m WHERE m.goat1Id = ?1" +
                   " AND SELECT * FROM matches m WHERE m.goat2Id = ?1", nativeQuery = true)
    Iterable<Match> findAllByGoatId(Long id);

    /*@Query(value = "SELECT * FROM Goats g WHERE g.id < 2", nativeQuery = true)
    Iterable<Goat> findTheOldTimers();*/
=======
public interface MatchRepository {

    public interface DislikeRepository extends CrudRepository<Match, Long> {
        Iterable<Match> findAllMatches(long goatMatches);
    }
>>>>>>> a0f2aa8e72608f50baae8996d1a3a3d2af2475f7

}
