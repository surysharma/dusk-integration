package com.hotels;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.context.ExternalContext;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

/**
 * Created with IntelliJ IDEA.
 * User: sureshsharma
 * Date: 14/08/2013
 * Time: 18:53
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class HotelBookingsWebFlowTests extends AbstractXmlFlowExecutionTests {
    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/hotels/booking/hotel-reservation-flow.xml");  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Test
    public void should() {
        // given
        ExternalContext mockExternalContext = new MockExternalContext();

        // when
        startFlow(mockExternalContext);

        // then
        assertCurrentStateEquals("startbooking");

        // when
        resumeFlow(mockExternalContext);

        assertCurrentStateEquals("preview");

    }
}
