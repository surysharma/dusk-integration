package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 30/05/2012
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/admin")
@SessionAttributes(value = "admin")
public class AdminRegistrationController {

    private static String REGISTRATION_VIEW = "registration";

    @RequestMapping(value = "/register")
    public ModelAndView registerView() {
        return new ModelAndView(REGISTRATION_VIEW).addObject("admin", new Admin());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("admin") Admin admin, BindingResult bindingResult, SessionStatus sessionStatus) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView(REGISTRATION_VIEW);
            
        }
        sessionStatus.setComplete();
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        return modelAndView;
    }
}
