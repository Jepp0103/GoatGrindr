package edu.kea.jnd.goatsite.controller.api;

import edu.kea.jnd.goatsite.model.Like;
import edu.kea.jnd.goatsite.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class LikeApiController {
    @Autowired
    private LikeRepository likeRepository;

    @GetMapping("/likes")
    public Iterable<Like> getLikes() {
        return likeRepository.findAll();
    }

    @GetMapping("/likes/{id}")
    public Object getLikeById(@PathVariable long id) {
        System.out.println(id);
        return likeRepository.findById(id).orElse(null);
    }

    @GetMapping("/likes/findbygoatliker")
    public Iterable<Like> getLikeByGoatLike(@RequestParam(value = "goatLiker") long goatLiker) {
        System.out.println(goatLiker);
        return likeRepository.findAllByGoatLiker(goatLiker);
    }

    @PostMapping("/likes")
    public Like createLike(@Valid @RequestBody Like like) {
        return likeRepository.save(like);
    }

 /*   @DeleteMapping("/likes")
    public Like deleteLike(@Valid @RequestBody Like like) {
        likeRepository.delete(like);
        return like;
    }*/
}
