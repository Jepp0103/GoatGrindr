package edu.kea.jnd.goatsite.controller.api;
import edu.kea.jnd.goatsite.model.Dislike;
import edu.kea.jnd.goatsite.model.Goat;
import edu.kea.jnd.goatsite.model.Like;
import edu.kea.jnd.goatsite.repository.DislikeRepository;
import edu.kea.jnd.goatsite.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController //Returnere data
@RequestMapping(value = "/api")
public class DislikeApiController {

    @Autowired
    private DislikeRepository dislikeRepository;

    @GetMapping("/dislikes")
    public Iterable<Dislike> getLikes(){
        return dislikeRepository.findAll();
    }

    @GetMapping("/dislikes/{id}")
    public Object getLikeById(@PathVariable long id){
        System.out.println(id);
        return dislikeRepository.findById(id).orElse(null);
    }

    @GetMapping("/dislikes/findbygoatdisliker")
    public Iterable<Dislike> getLikeByGoatDisliker(@RequestParam(value = "goatDisliker") long goatDisliker) {
        return dislikeRepository.findAllByGoatDisliker(goatDisliker);
    }

    @PostMapping("/dislikes")
    public Dislike createDislike(@Valid @RequestBody Dislike dislike){
        return dislikeRepository.save(dislike);
    }
}
