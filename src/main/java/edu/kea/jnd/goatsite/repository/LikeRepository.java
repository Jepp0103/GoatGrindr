package edu.kea.jnd.goatsite.repository;

import edu.kea.jnd.goatsite.model.Goat;
import edu.kea.jnd.goatsite.model.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
    Iterable<Like> findAllByGoatLiker(Long goatLiker);

    @Query(value = "SELECT goat_liked_id FROM likes l WHERE l.goat_liker_id = ?", nativeQuery = true)
    Iterable<Long> findAllLikedGoats(Long goatId);

    @Query(value = "SELECT DISTINCT C.username AS username_A, D.username AS username_B, C.name AS name_A, D.name AS name_B FROM likes AS A INNER JOIN likes AS B ON A.goat_liker_id = B.goat_liked_id JOIN goats AS C ON A.goat_liker_id = C.id JOIN goats as D ON B.goat_liker_id = D.id WHERE A.goat_liker_id = B.goat_liked_id AND B.goat_liker_id = A.goat_liked_id AND a.goat_liker_id < b.goat_liker_id", nativeQuery = true)
    List<String> findAllMatches();
}
