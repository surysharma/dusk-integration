package com.hedgebenefits.services.bulkprint;

import com.hedgebenefits.domain.presentable.BulkPrintReportView;
import org.joda.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 26/01/2013
 * Time: 18:37
 * To change this template use File | Settings | File Templates.
 */
public interface BulkPrintReportService {
    BulkPrintReportView getBulkPrintReportView(Long id, LocalDate fromDate, LocalDate toDate);
}
