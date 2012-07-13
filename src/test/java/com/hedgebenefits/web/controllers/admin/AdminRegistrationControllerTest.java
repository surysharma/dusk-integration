package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.validators.AdminValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.hedgebenefits.builders.AdminBuilder.adminBuilder;
import static com.hedgebenefits.matchers.AdminModelAndViewMatcher.adminModelAndView;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class AdminRegistrationControllerTest {

    private static String REGISTRATION_VIEW = "registration";
    @Mock
    RedirectAttributes redirectAttributes;

    @Mock
    BindingResult bindingResult;
    @Mock
    SessionStatus sessionStatus;
    @Mock
    private AdminValidator adminValidator;
    
    @InjectMocks
    private AdminRegistrationController adminRegistrationController = new AdminRegistrationController();

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

        //Given
        Admin admin = adminBuilder().build();
        //And
        given(bindingResult.hasErrors()).willReturn(false);

        //when
        String redirectedView = adminRegistrationController.register(admin, bindingResult, sessionStatus, redirectAttributes);

        //then
        assertThat(redirectedView, is("redirect:list"));
        //and
        verify(sessionStatus).setComplete();
    }

    @Test
    public void shouldReturnRegistrationViewIfError() {
        //given
        given(bindingResult.hasErrors()).willReturn(true);
        //And
        //And
        Admin admin = adminBuilder().build();

        //when
        String registeredView = adminRegistrationController.register(admin, bindingResult, sessionStatus, redirectAttributes);

        //then
        assertThat(registeredView, is(ADMIN_VIEWS.REGISTER_ADMIN.getViewName()));
        //And
        verify(redirectAttributes).addFlashAttribute("admin", admin);
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
