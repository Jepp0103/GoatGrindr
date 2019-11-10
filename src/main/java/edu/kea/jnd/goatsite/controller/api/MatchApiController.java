package edu.kea.jnd.goatsite.controller.api;


import edu.kea.jnd.goatsite.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MatchApiController {

    @Autowired
    MatchRepository matchRepository;

    //@GetMapping

}
