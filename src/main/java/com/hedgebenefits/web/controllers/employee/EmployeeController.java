package com.hedgebenefits.web.controllers.employee;


import com.hedgebenefits.domain.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @RequestMapping(value = "/employee/{id}")
    public ModelAndView getEmployee(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("employee_details");
        Employee employee = new Employee.EmployeeBuilder()
                .id(id)
                .name("jeffarry" + id)
                .niNumber("SN10KTL")
                .build();
        mav.addObject("employee", employee);
        return mav;


    }

   @RequestMapping(value = "/employee/add/", method = RequestMethod.POST)
    public void addEmployee(HttpEntity<Employee> employeeEntity){
       Employee employee = employeeEntity.getBody();
       System.out.println(employee.getName());
    }
//   @RequestMapping(value = "/employee/add/", method = RequestMethod.POST)
//    public void addEmployee(@RequestBody Employee employee){
//       System.out.println(employee.getName());
//    }


}
