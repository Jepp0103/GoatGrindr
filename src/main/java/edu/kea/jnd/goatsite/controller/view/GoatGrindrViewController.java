package edu.kea.jnd.goatsite.controller.view;

import edu.kea.jnd.goatsite.model.CurrentUser;
import edu.kea.jnd.goatsite.model.Goat;
import edu.kea.jnd.goatsite.repository.GoatRepository;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;


@Controller
public class GoatGrindrViewController {
    Goat randomGoatLiked;
    Authentication authentication;
    Goat currentUser;

    @Autowired
    GoatRepository goatRepository;

    @RequestMapping("/carousel.js")
    public String findParticipators(Model model) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = goatRepository.findGoatByUsername(authentication.getName());
        model.addAttribute("randomGoatLiked", randomGoatLiked);
        model.addAttribute("goatUser", currentUser);
        return "../static/carousel.js";
    }

    @GetMapping(value = "/")
    public String getToStartPage() {
        return "loginPage.html";
    }

    @GetMapping(value = "/login")
    public String getToLogin(){
        return "loginPage.html";
    }

    @GetMapping(value = "/goatgrindr")
    public String findRandomGoat(Model model) {
        Random random = new Random();
        int value = goatRepository.findMaxValue();
        int randomNumber = random.nextInt(value);
        randomGoatLiked = goatRepository.findRandomGoat(randomNumber + 1);
        model.addAttribute("name", randomGoatLiked.getName());
        model.addAttribute("dob", randomGoatLiked.getDob());
        model.addAttribute("shortDescription", randomGoatLiked.getShortDescription());
        model.addAttribute("longDescription", randomGoatLiked.getLongDescription());
        model.addAttribute("gender", randomGoatLiked.getGender());
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
