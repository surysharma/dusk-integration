package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.Company;
import com.hedgebenefits.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 30/05/2012
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyRegistrationController {

    private static String REGISTRATION_VIEW = "registration";

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/register")
    public ModelAndView registerView() {
        return new ModelAndView(REGISTRATION_VIEW).addObject("company", new Company());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("company") Company company, BindingResult bindingResult,
                                 SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {
        companyService.register(company);
        return "redirect:list";
    }

    @RequestMapping(value = "/list")
    public ModelAndView listRegisteredCompanies() {
        List<Company> companies = companyService.listAllCompanies();
        return new ModelAndView("list").addObject("companies", companies);  //To change body of created methods use File | Settings | File Templates.
    }

    @InitBinder
    public void bind(WebDataBinder webDataBinder) {

    }
}
