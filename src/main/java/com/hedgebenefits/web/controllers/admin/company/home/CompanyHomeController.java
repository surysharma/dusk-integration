package com.hedgebenefits.web.controllers.admin.company.home;

import com.hedgebenefits.utils.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyHomeController {

    @RequestMapping("/admin/company")
    public ModelAndView renderHomeView() {
        return new ModelAndView(View.company.value());
    }
}
