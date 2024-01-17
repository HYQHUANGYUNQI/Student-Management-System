package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class pageController {

    @RequestMapping(value = "/user")
    public String user (){
        return "user";
    }

    @RequestMapping(value = "/student")
    public String student() {
        return "student";
    }

    @RequestMapping(value = "/search")
    public String search() {
        return "search";
    }

    @RequestMapping(value = "/searchscore")
    public String searchscore() {
        return "searchscore";
    }

    @RequestMapping(value = "/course")
    public String course() {
        return "course";
    }

    @RequestMapping(value = "/selectedcourse")
    public String selected() {
        return "selectedcourse";
    }
}
