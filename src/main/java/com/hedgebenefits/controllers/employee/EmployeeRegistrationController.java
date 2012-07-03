package com.hedgebenefits.controllers.employee;

import com.hedgebenefits.domain.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 30/05/2012
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class EmployeeRegistrationController {

    @RequestMapping(value = "/register/add")
    public ModelAndView registerView() {
        return new ModelAndView("registration").addObject("admin", new Admin());  //To change body of created methods use File | Settings | File Templates.
    }
}
