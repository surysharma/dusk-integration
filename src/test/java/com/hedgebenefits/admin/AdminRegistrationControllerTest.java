package com.hedgebenefits.admin;

import com.hedgebenefits.domain.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import static com.hedgebenefits.matchers.AdminModelAndViewMatcher.adminModelAndView;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class AdminRegistrationControllerTest {

    private AdminRegistrationController adminRegistrationController = new AdminRegistrationController();

    @Test
    public void shouldRenderAdminRegistrationView() {
        // when
        ModelAndView modelAndView = adminRegistrationController.registerView();

        // then
        ModelAndView expectedModelAndView = new ModelAndView("registration");
        expectedModelAndView.getModel().put("admin", new Admin());
        assertThat(modelAndView, is(adminModelAndView(expectedModelAndView)));
    }
}
