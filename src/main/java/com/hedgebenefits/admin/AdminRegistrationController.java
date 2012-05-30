package com.hedgebenefits.admin;

import com.hedgebenefits.domain.Admin;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 30/05/2012
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */

public class AdminRegistrationController {

    public ModelAndView registerView() {
        return new ModelAndView("register").addObject("admin", new Admin());  //To change body of created methods use File | Settings | File Templates.
    }
}
