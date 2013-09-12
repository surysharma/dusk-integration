package com.hedgebenefits.web.controllers.admin.company.datain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.hedgebenefits.utils.View.datain;

@Controller
@RequestMapping("/admin")
public class DataInController {

    //TODO: Why @RequestMapping is not resolving enum constants
    @RequestMapping("/company/datain")
    public ModelAndView dataInView() {
        return new ModelAndView(datain.value());
    }
}
