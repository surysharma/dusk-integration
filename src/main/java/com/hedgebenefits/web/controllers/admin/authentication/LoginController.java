package com.hedgebenefits.web.controllers.admin.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.hedgebenefits.utils.ModelConstants.AUTHENTICATION_FAIL;
import static com.hedgebenefits.utils.View.login;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView renderLogin() {
        return new ModelAndView(login.value());
    }

    @RequestMapping("/loginfailed")
    public String authenticationFailed(ModelMap modelMap) {
        modelMap.addAttribute(AUTHENTICATION_FAIL.value(), true);
        return login.value();
    }
}
