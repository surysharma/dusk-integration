package com.hedgebenefits.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.hedgebenefits.utils.View.company;

@Controller
@RequestMapping("/admin")
public class CompanyController {


    //TODO: Why @RequestMapping is not resolving enum constants
    // URIConstant.ROOT.value()  + URIConstant.COMPANY_HOME.value();
    @RequestMapping("/companies")
    public ModelAndView renderLoginView() {
        return new ModelAndView(company.value());
    }
}
