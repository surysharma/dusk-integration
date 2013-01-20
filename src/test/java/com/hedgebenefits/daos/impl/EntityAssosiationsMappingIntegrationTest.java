package com.hedgebenefits.daos.impl;

import com.hedgebenefits.domain.Address;
import com.hedgebenefits.domain.User;
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

import static com.hedgebenefits.domain.User.UserBuilder.UserBuilder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(locations = "file:/projects/dusk-integration/src/main/webapp/WEB-INF/hedgebenefits-servlet.xml")
public class EntityAssosiationsMappingIntegrationTest extends AbstractDaoSupport{
    @Autowired
    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void shouldSavePdfMessage() throws Exception {
        //Given
        Address address = Address.getInstance("someAddress", "N128DG", "London");
        User user = UserBuilder()
                .firstName("someFirstName")
                .lastName("someLastName")
                .address(address)
                .build();

        address.setUser(user);
        //When
        save(address);
        flush();

        //Then
        Long id = user.getId();
        assertThat(id, notNullValue());
        user = (User) load(User.class, id);
        assertThat(user.getFirstName(), is("someFirstName"));

    }



    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
