package com.hedgebenefits.admin;

import com.hedgebenefits.matchers.AdminModelAndViewMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import static com.hedgebenefits.matchers.AdminModelAndViewMatcher.adminModelAndView;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 30/05/2012
 * Time: 19:39
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class AdminRegistrationControllerTest {

    private AdminRegistrationController adminRegistrationController = new AdminRegistrationController();
    private AdminModelAndViewMatcher adminModelAndView;


    @Test
    public void shouldRenderAdminRegistrationView() {
        // when
        ModelAndView modelAndView = adminRegistrationController.registerView();

        // then
        assertThat(modelAndView, is(adminModelAndView()));
    }
}
