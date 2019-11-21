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

    @PostMapping("/likes")
    public Like createLike(@Valid @RequestBody Like like) {
        return likeRepository.save(like);
    }

}
