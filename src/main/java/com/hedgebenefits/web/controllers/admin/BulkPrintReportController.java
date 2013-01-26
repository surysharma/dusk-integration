package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.presentable.BulkPrintReportView;
import com.hedgebenefits.services.bulkprint.BulkPrintReportService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 26/01/2013
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/admin/bulkprint")
public class BulkPrintReportController {

    private BulkPrintReportService bulkPrintReportService;

    @Autowired
    public BulkPrintReportController(BulkPrintReportService bulkPrintReportService) {
        //To change body of created methods use File | Settings | File Templates.
        this.bulkPrintReportService = bulkPrintReportService;
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public ModelAndView viewReport() {
        return new ModelAndView("/admin/bulkprint/report");  //To change body of created methods use File | Settings | File Templates.
    }

    @RequestMapping(value = "/report/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public BulkPrintReportView getFilteredContents(Long id, LocalDate fromDate, LocalDate toDate) {
        return bulkPrintReportService.getBulkPrintReportView(id, fromDate, toDate);  //To change body of created methods use File | Settings | File Templates.
    }

//    @RequestMapping(value = "/report/filter", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String getFilteredContents1(Long id, LocalDate fromDate, LocalDate toDate) {
//        return "Hello world!!!";  //To change body of created methods use File | Settings | File Templates.
//    }
}
