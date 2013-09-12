package com.hedgebenefits.web.controllers.admin.registration;

import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.domain.Right;
import com.hedgebenefits.propertyeditors.RightsPropertyEditor;
import com.hedgebenefits.validators.AdminValidator;
import com.hedgebenefits.web.controllers.admin.ADMIN_RIGHTS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.hedgebenefits.web.controllers.admin.ADMIN_VIEWS.LIST_ADMINS;
import static com.hedgebenefits.web.controllers.admin.ADMIN_VIEWS.REGISTER_ADMIN;

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
        redirectAttributes.addFlashAttribute("isRedirected", true);
        validator.validate(admin, bindingResult);
        if (bindingResult.hasErrors()) {
            return REGISTER_ADMIN.getViewName();

        }
        sessionStatus.setComplete();
        return "redirect:list";
    }

    @ModelAttribute("rights")
    public Map<ADMIN_RIGHTS, String> populateRights() {
        Map<ADMIN_RIGHTS, String> rights = new LinkedHashMap<ADMIN_RIGHTS, String>();
        rights.put(ADMIN_RIGHTS.ADMIN, "administrator");
        rights.put(ADMIN_RIGHTS.COMP, "company");
        rights.put(ADMIN_RIGHTS.EMP, "Employee");

        return rights;
    }

    @RequestMapping(value = "/list")
    public ModelAndView listRegisteredAdmins() {
        return new ModelAndView(LIST_ADMINS.getViewName());
    }

    @InitBinder
    public void bind(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Right.class, "right", new RightsPropertyEditor());
    }
}
