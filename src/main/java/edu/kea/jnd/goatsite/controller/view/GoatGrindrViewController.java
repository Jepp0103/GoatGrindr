package edu.kea.jnd.goatsite.controller.view;

import edu.kea.jnd.goatsite.model.Goat;
import edu.kea.jnd.goatsite.repository.GoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    /*

     @PostMapping(value = "/updategoat")
    public String updateTheGoat(@ModelAttribute Goat goat) {
        goatRepository.updateInfo(goat.getGender(),goat.getName(),goat.getPassword(),goat.getShortDescription(),goat.getLongDescription());
        return "updateGoat.html";
    }

    */

    @GetMapping(value = "/creategoat")
    public String createGoatAccount() {
        return "createGoat.html";
    }

    @GetMapping(value = "/goatHasBeenCreated")
    public String backToMain(){
        return "goatHasBeenCreated.html";
    }

    @GetMapping(value = "/updategoat")
    public String changeIdentity(){
        return "updateGoat.html";
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

    @RequestMapping(value = "/updateGoat.html", method = RequestMethod.GET)
    public String goatprofile(Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User user){
        model.addAttribute("goats", goatRepository.findGoatByUsername(user.getUsername()));
        return "updateGoat.html";
    }

    @PostMapping("/updatingTheGoat")
    public String goatprofile(@ModelAttribute Goat goat){
        Goat goatUpdater = goatRepository.findGoatByUsername(goat.getUsername());
        goatUpdater.setName(goat.getName());
        goatUpdater.setPassword(goat.getPassword());
        goatUpdater.setShortDescription(goat.getShortDescription());
        goatUpdater.setLongDescription(goat.getLongDescription());
        goatRepository.save(goatUpdater);
        System.out.println(goatUpdater);
        return "index.html";
    }

}
