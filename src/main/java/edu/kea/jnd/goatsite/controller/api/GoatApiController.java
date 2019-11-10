package edu.kea.jnd.goatsite.controller.api;

import edu.kea.jnd.goatsite.model.Gender;
import edu.kea.jnd.goatsite.repository.GoatRepository;
import edu.kea.jnd.goatsite.model.Goat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class GoatApiController {

    @Autowired
    private GoatRepository goatRepository;

    @GetMapping("/goats")
    public Iterable<Goat> getGoats() {
        return goatRepository.findAll();
    }

    @GetMapping("/goats/{id}")
    public Object getGoatById(@PathVariable long id) {
        return goatRepository.findById(id).orElse(null);
    }

    @GetMapping("/goats/findbyname")
    public Iterable<Goat> getGoatByName(@RequestParam(value = "name") String name) {
        return goatRepository.findAllByName(name);
    }

    //Gøres både i GoatRepository interface, GoatAPIController og tjekker Gender enum.
    @GetMapping("/goats/findbygender")
    public Iterable<Goat> getGoatByGender(@RequestParam(value = "gender") Gender gender) {
        System.out.println(gender);
        return goatRepository.findAllByGender(gender);
    }

    //Old timers where id < 2
    @GetMapping("/goats/oldtimers")
    public Iterable<Goat> getOldTimers(){
        return goatRepository.findTheOldTimers();
    }

    @PostMapping("/goats")
    public Goat createGoat(@Valid @RequestBody Goat goat) {
        return goatRepository.save(goat);
    }


}