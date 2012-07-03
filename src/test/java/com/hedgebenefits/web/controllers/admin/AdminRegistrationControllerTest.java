package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import static com.hedgebenefits.builders.AdminBuilder.adminBuilder;
import static com.hedgebenefits.matchers.AdminModelAndViewMatcher.adminModelAndView;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class AdminRegistrationControllerTest {

    private AdminRegistrationController adminRegistrationController = new AdminRegistrationController();
    private static String REGISTRATION_VIEW = "registration";

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
    public void shouldRegisterAndReturnToListView() {
        //given
        BindingResult bindingResult = mock(BindingResult.class);
        // And
        SessionStatus sessionStatus = mock(SessionStatus.class);
        //And
        Admin admin = adminBuilder().build();

        //when
        ModelAndView registeredView = adminRegistrationController.register(admin, bindingResult, sessionStatus);

        //then
        assertThat(registeredView.getViewName(), is("redirect:/list"));
        //and
        verify(sessionStatus).setComplete();
    }

    @Test
    public void shouldReturnRegistrationViewIfError() {
        //given
        BindingResult bindingResult = mock(BindingResult.class);
        given(bindingResult.hasErrors()).willReturn(true);
        //And
        SessionStatus sessionStatus = mock(SessionStatus.class);
        //And
        Admin admin = adminBuilder().build();

        //when
        ModelAndView registeredView = adminRegistrationController.register(admin, bindingResult, sessionStatus);

        //then
        assertThat(registeredView.getViewName(), is(REGISTRATION_VIEW));
    }
}
