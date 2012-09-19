package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.domain.AdminSector;
import com.hedgebenefits.domain.Sector;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = "/register")
    public ModelAndView registerView() {
        ModelAndView modelAndView = new ModelAndView(REGISTRATION_VIEW);
        return modelAndView.addObject("admin", new Admin());
    }

    @ModelAttribute(value = "sectors")
    public List<Sector> populateSectors(){
        List<Sector> sectors = new ArrayList();
        Sector sector1= new Sector();
        sector1.setId(21L);
        sector1.setSectorName("Agriculture");

        Sector sector2= new Sector();
        sector2.setId(22L);
        sector2.setSectorName("Health");

        Sector sector3= new Sector();
        sector3.setId(23L);
        sector3.setSectorName("IT");

        Sector sector4= new Sector();
        sector4.setId(24L);
        sector4.setSectorName("Finance");

        sectors.add(sector1);
        sectors.add(sector2);
        sectors.add(sector3);
        sectors.add(sector4);


        return sectors;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("admin") Admin admin, BindingResult bindingResult,
                                 SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("admin", admin);
        redirectAttributes.addFlashAttribute("isRedirected", true);//In case the redirection does not happen this will never be set!!!
        if (bindingResult.hasErrors()) {
            return REGISTER_ADMIN.getViewName();
            
        }
        sessionStatus.setComplete();
        return "redirect:list";
    }

    @RequestMapping(value = "/list")
    public ModelAndView listRegisteredAdmins() {
        return new ModelAndView(LIST_ADMINS.getViewName());  //To change body of created methods use File | Settings | File Templates.
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(AdminSector.class, new AdminSectorPropertyEditor());

    }
}
