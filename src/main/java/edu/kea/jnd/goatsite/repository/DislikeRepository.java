package edu.kea.jnd.goatsite.repository;

import edu.kea.jnd.goatsite.model.Dislike;
import org.springframework.data.repository.CrudRepository;

public interface DislikeRepository extends CrudRepository<Dislike, Long> {
    Iterable<Dislike> findAllByGoatDisliker(long goatDisliker);
}


