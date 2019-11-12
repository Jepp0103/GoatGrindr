package edu.kea.jnd.goatsite.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GoatGrindrViewController {

    @GetMapping(value = "/goatgrindr")
    public String findGoatGrindrPage() {
        return "index.html";
    }

    //Viser ikke carosel når man viser navn endnu...
    @GetMapping(value = "/goatgrindr/name")
    public String tryTheTestPath(Model model, @RequestParam(value = "name") String visitorName) {
        model.addAttribute("name", visitorName);
        return "index.html";
    }

}
