package edu.kea.jnd.goatsite.controller.api;

import edu.kea.jnd.goatsite.model.Like;
import edu.kea.jnd.goatsite.repository.LikeRepository;
import edu.kea.jnd.goatsite.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class LikeApiController {

    @Autowired
    private LikeRepository likeRepository;
    private MatchRepository matchRepository;

  /*  @GetMapping("/likes")
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
*/
    @PostMapping("/likes")
    public Like createLike(@Valid @RequestBody Like like) {
        System.out.println(like);
        return likeRepository.save(like);
    }

/*    @PostMapping("/likes")
    public Like createLikesToMatch(@Valid @RequestBody Like like) {
        System.out.println(like);
        return matchRepository.save(like);
    }*/
}
