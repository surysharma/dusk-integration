package com.hedgebenefits.web.controllers;

import com.hedgebenefits.utils.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = {"/index.html", "/home"})
    public ModelAndView renderHomeView() {
        return new ModelAndView(View.home.value());
    }

}
