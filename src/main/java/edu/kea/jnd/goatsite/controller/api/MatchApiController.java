package edu.kea.jnd.goatsite.controller.api;

<<<<<<< HEAD
import edu.kea.jnd.goatsite.model.Match;
=======

>>>>>>> a0f2aa8e72608f50baae8996d1a3a3d2af2475f7
import edu.kea.jnd.goatsite.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
=======
>>>>>>> a0f2aa8e72608f50baae8996d1a3a3d2af2475f7
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MatchApiController {

    @Autowired
<<<<<<< HEAD
    private MatchRepository matchRepository;

    @GetMapping("/matches")
    public Iterable<Match> getMatches(){
        return matchRepository.findAll();
    }

    @GetMapping("/matches/findallbygoatid")
    public Iterable<Match> getMatchesByGoatId(@RequestParam(value = "id") Long id){
        return matchRepository.findAllByGoatId(id);
    }
=======
    MatchRepository matchRepository;

    //@GetMapping

>>>>>>> a0f2aa8e72608f50baae8996d1a3a3d2af2475f7
}
