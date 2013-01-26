package com.hedgebenefits.services.bulkprint;

import com.hedgebenefits.domain.presentable.BulkPrintReportView;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 26/01/2013
 * Time: 19:31
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BulkPrintReportServiceImpl implements BulkPrintReportService{
    @Override
    public BulkPrintReportView getBulkPrintReportView(Long id, LocalDate fromDate, LocalDate toDate) {
        return BulkPrintReportView.getInstance();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
