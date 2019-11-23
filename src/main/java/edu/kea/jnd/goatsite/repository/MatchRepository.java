package edu.kea.jnd.goatsite.repository;

import edu.kea.jnd.goatsite.model.Match;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {
    Iterable<Match> findAllByGoat1Id(Long goat1Id);
    Iterable<Match> findAllByGoat2Id(Long goat2Id);

    @Query(value = "SELECT * FROM matches m WHERE m.goat1Id = ?1" +
                   " AND SELECT * FROM matches m WHERE m.goat2Id = ?1", nativeQuery = true)
    Iterable<Match> findAllByGoatId(Long id);



}
