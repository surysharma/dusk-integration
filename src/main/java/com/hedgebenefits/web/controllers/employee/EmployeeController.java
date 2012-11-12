package com.hedgebenefits.web.controllers.employee;


import com.hedgebenefits.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

//    @RequestMapping(value = "/employee/{id}")
    public ModelAndView getEmployee(@PathVariable String id){
        ModelAndView mav = new ModelAndView("employee_details");
        Employee employee = new Employee.EmployeeBuilder()
                .id(1L)
                .name("jeff")
                .niNumber("SN10KTL")
                .build();
        mav.addObject("employee", employee);
        return mav;
    }

    @RequestMapping(value = "/employee/{id}")
    @ResponseBody
    public ModelAndView getEmployee1(@PathVariable String id){
        ModelAndView mav = new ModelAndView("employee_details");
        Employee employee = new Employee.EmployeeBuilder()
                .id(1L)
                .name("jeff")
                .niNumber("SN10KTL")
                .build();
        mav.addObject("employee", employee);
        return mav;
    }
}
