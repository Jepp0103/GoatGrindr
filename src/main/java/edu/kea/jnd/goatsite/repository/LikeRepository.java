package edu.kea.jnd.goatsite.repository;

import edu.kea.jnd.goatsite.model.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
    Iterable<Like> findAllByGoatLiker(long goatLiker);
}
