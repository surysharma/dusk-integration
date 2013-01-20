package com.hedgebenefits.daos.impl;

import com.hedgebenefits.domain.BulkNotification;
import com.hedgebenefits.domain.PDFMessageType;
import com.hedgebenefits.domain.PdfMessage;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.hedgebenefits.domain.PdfMessage.PdfMessageBuilder.pdfMessageBuilder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(locations = "file:/projects/dusk-integration/src/main/webapp/WEB-INF/hedgebenefits-servlet.xml")
public class EntityAssosiationsMappingIntegrationTest {
    @Autowired
    private SessionFactory sessionFactory;




    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void shouldSavePdfMessage() throws Exception {
        //Given
        PdfMessage pdfMessage = pdfMessageBuilder()
                .messageBody("some pdf message")
                .messsageType(PDFMessageType.RIGHT_TO_JOIN)
                .build();
        BulkNotification bulkNotification = BulkNotification.getInstance("notification message", pdfMessage);
//        bulkNotification.getPdfMessage().setBulkNotification(bulkNotification);
        //When
        save(pdfMessage);
        save(bulkNotification);

        flush();

        //Then
        Long id = pdfMessage.getId();
        assertThat(id, notNullValue());
        pdfMessage = (PdfMessage) sessionFactory.getCurrentSession().load(PdfMessage.class, id);
        assertThat(pdfMessage.getMessageType(), is(PDFMessageType.RIGHT_TO_JOIN));
    }

    private <T> void save(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    private void flush(){
        sessionFactory.getCurrentSession().flush();
    }


}
