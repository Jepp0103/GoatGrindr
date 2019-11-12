package edu.kea.jnd.goatsite.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/view")
public class MainViewController {

    @GetMapping(value = "/test")
    public String tryTheTestPath(Model model, @RequestParam(value = "name") String visitorName){
        model.addAttribute("name", visitorName);

        List<String> qualities = Arrays.asList("Can dance", "Can run", "Can sing");
        model.addAttribute("qualities", qualities);

        return "test.html";
    }

}
