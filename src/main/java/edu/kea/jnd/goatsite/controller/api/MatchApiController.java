package edu.kea.jnd.goatsite.controller.api;

import edu.kea.jnd.goatsite.model.Like;
import edu.kea.jnd.goatsite.model.Match;

import edu.kea.jnd.goatsite.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class MatchApiController {
    Like like;

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/matches")
    public Iterable<Match> getMatches(){
        return matchRepository.findAll();
    }


    @PostMapping("/matches")
    public Match createMatch(@Valid @RequestBody Match match) {
        return matchRepository.save(match);
    }
}
