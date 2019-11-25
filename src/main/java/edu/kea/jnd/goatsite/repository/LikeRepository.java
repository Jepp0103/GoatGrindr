package edu.kea.jnd.goatsite.repository;

import edu.kea.jnd.goatsite.model.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
    Iterable<Like> findAllByGoatLiker(Long goatLiker);

    @Query(value = "SELECT goat_liked_id FROM likes l WHERE l.goat_liker_id = ?", nativeQuery = true)
    Iterable<Long> findAllLikedGoats(Long goatId);
}
