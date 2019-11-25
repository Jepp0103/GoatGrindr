package edu.kea.jnd.goatsite.repository;
import edu.kea.jnd.goatsite.model.Match;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {
    Iterable<Match> findAllByGoat1Id(Long goat1Id);
    Iterable<Match> findAllByGoat2Id(Long goat2Id);

    @Query(value = "SELECT DISTINCT A.goat_liker_id A, C.name AS name_A, C.username AS username_A, B.goat_liker_id B, D.name AS name_B, D.username AS username_B FROM likes AS A INNER JOIN likes AS B ON A.goat_liker_id = B.goat_liked_id JOIN goats AS C ON A.goat_liker_id = C.id JOIN goats as D ON B.goat_liker_id = D.id WHERE A.goat_liker_id = B.goat_liked_id AND B.goat_liker_id = A.goat_liked_id AND a.goat_liker_id < b.goat_liker_id", nativeQuery = true)
    List<String> findAllMatches();
}
