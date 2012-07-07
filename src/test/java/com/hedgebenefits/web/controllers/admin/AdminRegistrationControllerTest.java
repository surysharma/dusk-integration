package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.hedgebenefits.matchers.AdminModelAndViewMatcher.adminModelAndView;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class AdminRegistrationControllerTest {

    private AdminRegistrationController adminRegistrationController = new AdminRegistrationController();
    private static String REGISTRATION_VIEW = "registration";

    @Mock
    RedirectAttributes redirectAttributes;
    @Mock
    BindingResult bindingResult;
    @Mock
    SessionStatus sessionStatus;

    @Test
    public void shouldRenderAdminRegistrationView() {
        // when
        ModelAndView modelAndView = adminRegistrationController.registerView();

        // then
        ModelAndView expectedModelAndView = new ModelAndView(REGISTRATION_VIEW);
        expectedModelAndView.getModel().put("admin", new Admin());
        assertThat(modelAndView, is(adminModelAndView(expectedModelAndView)));
    }

 

    @Test
    public void shouldListRegisteredAdmins() {
        //given

        //when
        ModelAndView listModelAndView = adminRegistrationController.listRegisteredAdmins();

        //then
        assertThat(listModelAndView.getViewName(), is(ADMIN_VIEWS.LIST_ADMINS.getViewName()));
    }
}
