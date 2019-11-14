package edu.kea.jnd.goatsite.controller.view;

import edu.kea.jnd.goatsite.model.Goat;
import edu.kea.jnd.goatsite.repository.GoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;


@Controller
public class GoatGrindrViewController {

    @Autowired
    GoatRepository goatRepository;
    List<Goat> goats;

    @PostMapping(value = "/creategoat")
    public String createTheCreature(@ModelAttribute Goat goat){
        //goatRepository.createGoat(goat.getDob(), );
        if(goat.getName().length() > 0 && goat.getLongDescription().length() > 0
                && goat.getShortDescription().length() > 0 && goat.getPassword().length() > 0
                && goat.getUsername().length() > 0) {
            goatRepository.save(goat);
            return "loginPage.html";
        }
            return "createGoat.html";
    }

    @GetMapping(value = "/")
    public String getLoginPage(){
        return "loginPage.html";
    }

    /*
    @GetMapping(value = "/goatgrindr")
    public String findAllDatabaseObjects(Model model) {
        goats = (List<Goat>) goatRepository.findAll();
        model.addAttribute("goats", goats);
        return "index.html";
    }
     */

    //Viser ikke carosel når man viser navn endnu... denne metode er ikke brugbar pt.
    @GetMapping(value = "/goatgrindr")
    public String findGoatByHardcodedName(Model model) {

        Random random = new Random();
        int value = goatRepository.findMaxValue();

        int randomGoat = random.nextInt(value);

        Goat goat = goatRepository.findRandomGoat(randomGoat+1);
        model.addAttribute("name", goat.getName());
        model.addAttribute("dob", goat.getDob());
        model.addAttribute("shortDescription", goat.getShortDescription());
        model.addAttribute("longDescription", goat.getLongDescription());
        model.addAttribute("gender", goat.getGender());
        return "index.html";
    }

    @GetMapping(value = "/creategoat")
    public String createGoatAccount(){
        return "createGoat.html";
    }

    //to do post mapping på create goat som skal interagere med html fil.

}
