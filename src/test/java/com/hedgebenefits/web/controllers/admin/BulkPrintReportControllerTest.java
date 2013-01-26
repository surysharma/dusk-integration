package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.presentable.BulkPrintReportView;
import com.hedgebenefits.services.bulkprint.BulkPrintReportService;
import org.apache.commons.lang.math.RandomUtils;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 26/01/2013
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class BulkPrintReportControllerTest {

    @Mock
    private BulkPrintReportService bulkPrintReportService;

    private BulkPrintReportController bulkPrintReportController;

    @Before
    public void setup(){
        bulkPrintReportController = new BulkPrintReportController(bulkPrintReportService);
    }

    @Test
    public void shouldRenderReport() {
        //when
        ModelAndView mAndView = bulkPrintReportController.viewReport();
        //then
        assertThat(mAndView.getViewName(), is("/admin/bulkprint/report"));
    }

    @Test
    public void shouldRenderReportWithFilteredContents() {
        //Given
        Long id = RandomUtils.nextLong();
        LocalDate fromDate = new LocalDate();
        LocalDate toDate = fromDate.plusDays(5);
        BulkPrintReportView bulkPrintReportView1 = BulkPrintReportView.getInstance();
        given(bulkPrintReportService.getBulkPrintReportView(id, fromDate, toDate)).willReturn(bulkPrintReportView1);

        //when
        BulkPrintReportView bulkPrintReportView = bulkPrintReportController.getFilteredContents(id, fromDate, toDate);
        //then
        assertThat(bulkPrintReportView.getReportRows().size(), is(3));
    }

}
