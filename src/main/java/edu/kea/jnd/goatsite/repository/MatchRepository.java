package edu.kea.jnd.goatsite.repository;

import edu.kea.jnd.goatsite.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository {

    public interface DislikeRepository extends CrudRepository<Match, Long> {
        Iterable<Match> findAllMatches(long goatMatches);
    }

}
