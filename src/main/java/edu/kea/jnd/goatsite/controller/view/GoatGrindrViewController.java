package edu.kea.jnd.goatsite.controller.view;

import edu.kea.jnd.goatsite.model.Goat;
import edu.kea.jnd.goatsite.repository.GoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;


@Controller
public class GoatGrindrViewController {
    Goat goat;

    @Autowired
    GoatRepository goatRepository;

    @GetMapping(value = "/")
    public String getToStartPage() {
        return "loginPage.html";
    }

    @GetMapping(value = "/login")
    public String getToLogin(){
        return "loginPage.html";
    }

    @GetMapping(value = "/logout")
    public String getToLogout(){
        return "logoutPage.html";
    }

    @GetMapping(value = "/goatgrindr")
    public String findGoatObject(Model model) {
        Random random = new Random();
        int value = goatRepository.findMaxValue();
        int randomGoat = random.nextInt(value);
        goat = goatRepository.findRandomGoat(randomGoat + 1);
        model.addAttribute("name", goat.getName());
        model.addAttribute("dob", goat.getDob());
        model.addAttribute("shortDescription", goat.getShortDescription());
        model.addAttribute("longDescription", goat.getLongDescription());
        model.addAttribute("gender", goat.getGender());
        return "index.html";
    }


    @PostMapping(value = "/creategoat")
    public String createTheGoat(@ModelAttribute Goat goat) {
        if (goat.getName().length() > 0
                && goat.getDob() != null
                && goat.getPassword().length() > 0
                && goat.getUsername().length() > 0
                && goat.getUsername().contains("@")
                && goat.getUsername().contains("mail")) {
            goatRepository.save(goat);
            return "goatHasBeenCreated.html";
        }
        return "createGoat.html";
    }



    @GetMapping(value = "/creategoat")
    public String createGoatAccount() {
        return "createGoat.html";
    }

    @GetMapping(value = "/goatHasBeenCreated")
    public String backToMain(){
        return "goatHasBeenCreated.html";
    }

}
