package edu.kea.jnd.goatsite.controller.view;

import edu.kea.jnd.goatsite.model.Goat;
import edu.kea.jnd.goatsite.repository.GoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;


@Controller
public class GoatGrindrViewController {

    @Autowired
    GoatRepository goatRepository;
    List<Goat> goats;

    @GetMapping(value = "/goatgrindr")
    public String findAllDatabaseObjects(Model model) {
        goats = (List<Goat>) goatRepository.findAll();
        model.addAttribute("goats", goats);
        return "index.html";
    }

    //Viser ikke carosel når man viser navn endnu... denne metode er ikke brugbar pt.
    @GetMapping(value = "/goatgrindr/name")
    public String tryTheTestPath(Model model, @RequestParam(value = "name") String visitorName) {
        model.addAttribute("name", visitorName);
        return "index.html";
    }

}
