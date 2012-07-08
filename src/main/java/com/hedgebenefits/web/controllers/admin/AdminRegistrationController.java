package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.domain.Right;
import com.hedgebenefits.propertyeditors.RightsPropertyEditor;
import com.hedgebenefits.validators.AdminValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.hedgebenefits.web.controllers.admin.ADMIN_VIEWS.LIST_ADMINS;
import static com.hedgebenefits.web.controllers.admin.ADMIN_VIEWS.REGISTER_ADMIN;

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

    @Autowired
    private AdminValidator validator;

    @RequestMapping(value = "/register")
    public ModelAndView registerView() {
        return new ModelAndView(REGISTRATION_VIEW).addObject("admin", new Admin());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("admin") Admin admin, BindingResult bindingResult,
                                 SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("admin", admin);
        redirectAttributes.addFlashAttribute("isRedirected", true);//In case the redirection does not happen this will never be set!!!
        validator.validate(admin, bindingResult);
        if (bindingResult.hasErrors()) {
            return REGISTER_ADMIN.getViewName();
            
        }
        sessionStatus.setComplete();
        return "redirect:list";
    }

    @ModelAttribute("rights")
    public List<Right> populateRights(){
        List<Right> rights = new ArrayList<Right>();
        rights.add(new Right("administrator"));
        rights.add(new Right("company"));
        rights.add(new Right("Employee"));

        return rights;
    }
    @RequestMapping(value = "/list")
    public ModelAndView listRegisteredAdmins() {
        return new ModelAndView(LIST_ADMINS.getViewName());  //To change body of created methods use File | Settings | File Templates.
    }
}
