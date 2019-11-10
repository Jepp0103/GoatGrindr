package edu.kea.jnd.goatsite.controller.api;

import edu.kea.jnd.goatsite.model.Match;

import edu.kea.jnd.goatsite.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MatchApiController {

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/matches")
    public Iterable<Match> getMatches(){
        return matchRepository.findAll();
    }

    @GetMapping("/matches/findallbygoatid")
    public Iterable<Match> getMatchesByGoatId(@RequestParam(value = "id") Long id){
        return matchRepository.findAllByGoatId(id);
    }

}
