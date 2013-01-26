package com.hedgebenefits.domain.presentable;

import com.hedgebenefits.domain.ReportStatus;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 26/01/2013
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */
public class BulkPrintReportView {
    private static BulkPrintReportView reportView = new BulkPrintReportView();
    private List<ReportRow> reportRows;

    private BulkPrintReportView(){}

    public static BulkPrintReportView getInstance() {
        return reportView;
    }

    public List<ReportRow> getReportRows() {
        return newArrayList(new ReportRow(ReportStatus.PENDING), new ReportRow(ReportStatus.FAIL), new ReportRow(ReportStatus.SUCCESS));
    }
    
    public static class ReportRow{

        private ReportStatus reportStatus;

        public ReportRow(ReportStatus reportStatus) {
            //To change body of created methods use File | Settings | File Templates.
            this.reportStatus = reportStatus;
        }

        public ReportStatus getStatus() {
            return ReportStatus.PENDING;  //To change body of created methods use File | Settings | File Templates.
        }
    }
}
