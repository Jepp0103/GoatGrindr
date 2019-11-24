package edu.kea.jnd.goatsite.controller.view;

import edu.kea.jnd.goatsite.model.Goat;
import edu.kea.jnd.goatsite.repository.GoatRepository;
import edu.kea.jnd.goatsite.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Random;

import static edu.kea.jnd.goatsite.model.Gender.FEMALE;
import static edu.kea.jnd.goatsite.model.Gender.MALE;


@Controller
public class ViewController {
    Goat randomGoatLiked;
    Authentication authentication;
    Goat currentUser;

    @Autowired
    GoatRepository goatRepository;

    @Autowired
    LikeRepository likeRepository;

    @RequestMapping("/carousel.js")
    public String findParticipators(Model model) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = goatRepository.findGoatByUsername(authentication.getName());
        model.addAttribute("randomGoatLiked", randomGoatLiked);
        model.addAttribute("goatUser", currentUser);
        return "../static/carousel.js";
    }

    @GetMapping(value = "/matches")
    public String getMatches(Model model) {
        List<String> matches = likeRepository.findAllMatches();
        model.addAttribute("matches", matches.toString());
        System.out.println("Matches: " + likeRepository.findAllMatches());
        return "match.html";
    }

    @GetMapping(value = "/")
    public String getToStartPage() {
        return "loginPage.html";
    }

    @GetMapping(value = "/login")
    public String getToLogin() {
        return "loginPage.html";
    }

    @GetMapping(value = "/goatgrindr")
    public String findRandomGoat(Model model) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = goatRepository.findGoatByUsername(authentication.getName());
        likeRepository.findAllLikedGoats(currentUser.getId());
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

    @GetMapping(value = "/creategoat")
    public String createGoatAccount() {
        return "createGoat.html";
    }

    @GetMapping(value = "/goatHasBeenCreated")
    public String backToMain() {
        return "goatHasBeenCreated.html";
    }

    @GetMapping(value = "/updategoat")
    public String getUpdateGoat(Model model) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = goatRepository.findGoatByUsername(authentication.getName());
        model.addAttribute("dob", currentUser.getDob());
        model.addAttribute("gender", currentUser.getGender());
        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("password", currentUser.getPassword());
        model.addAttribute("name", currentUser.getName());
        model.addAttribute("shortDescription", currentUser.getShortDescription());
        model.addAttribute("longDescription", currentUser.getLongDescription());
        return "updateGoat.html";
    }

    @PostMapping(value = "/creategoat")
    public String createTheGoat(@ModelAttribute Goat goat) {
        if (goat.getName().length() > 0
                && goat.getDob() != null
                && goat.getPassword().length() > 0
                && goat.getUsername().length() > 0
                && goat.getUsername().contains("@")
                && goat.getUsername().contains("mail")
                && goat.getGender() == MALE
                || goat.getGender() == FEMALE) {
            goatRepository.save(goat);
            return "goatHasBeenCreated.html";
        }
        return "createGoat.html";
    }

    @PostMapping("/updateGoat")
    public String updateGoatProfile(@ModelAttribute Goat goat) {
        if (goat.getName().length() > 0
                && goat.getDob() != null
                && goat.getPassword().length() > 0
                && goat.getUsername().length() > 0
                && goat.getUsername().contains("@")
                && goat.getUsername().contains("mail")
                && goat.getGender() == MALE
                || goat.getGender() == FEMALE) {
            authentication = SecurityContextHolder.getContext().getAuthentication();
            currentUser = goatRepository.findGoatByUsername(authentication.getName());
            currentUser.setDob(goat.getDob());
            currentUser.setGender(goat.getGender());
            currentUser.setName(goat.getName());
            currentUser.setUsername(goat.getUsername());
            currentUser.setPassword(goat.getPassword());
            currentUser.setShortDescription(goat.getShortDescription());
            currentUser.setLongDescription(goat.getLongDescription());
        }

        goatRepository.save(currentUser);

        System.out.println(currentUser.toString());
        return "loginPage.html";
    }

}
