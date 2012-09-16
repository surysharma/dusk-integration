package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.Company;
import com.hedgebenefits.services.CompanyService;
import com.hedgebenefits.validators.AdminValidator;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static com.hedgebenefits.builders.AdminBuilder.adminBuilder;
import static com.hedgebenefits.matchers.AdminModelAndViewMatcher.adminModelAndView;
import static com.hedgebenefits.web.controllers.admin.AdminRegistrationControllerTest.AdminMatcher.equalsExpected;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@Ignore
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
    @Mock
    private CompanyService companyService;
    
    @InjectMocks
    private CompanyRegistrationController adminRegistrationController = new CompanyRegistrationController();

    @Test
    public void shouldRenderAdminRegistrationView() {
        // when
        ModelAndView modelAndView = adminRegistrationController.registerView();

        // then
        ModelAndView expectedModelAndView = new ModelAndView(REGISTRATION_VIEW);
        expectedModelAndView.getModel().put("company", new Company());
        assertThat(modelAndView, is(adminModelAndView(expectedModelAndView)));
    }

    @Test
    public void shouldRegisterAndReturnToListView() {

        //Given
        Company company = adminBuilder().build();
        //And
        given(bindingResult.hasErrors()).willReturn(false);

        //when
        String redirectedView = adminRegistrationController.register(company, bindingResult, sessionStatus, redirectAttributes);

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
        Company company = adminBuilder().build();

        //when
        String registeredView = adminRegistrationController.register(company, bindingResult, sessionStatus, redirectAttributes);

        //then
        //And
        verify(redirectAttributes).addFlashAttribute("company", company);
    }

    @Test
    public void shouldListRegisteredAdmins() {
        //given

        //when
        ModelAndView listModelAndView = adminRegistrationController.listRegisteredCompanies();

        //then
        //and
        Set<Company> companies = newHashSet();
        assertThat(listModelAndView.getModelMap().get("companies"), equalsExpected(companies));
    }


    static class AdminMatcher extends TypeSafeMatcher<Company> {


        private static Set<Company> expectedCompanies;

        public static Matcher<Object> equalsExpected(Set<Company> expectedCompanies) {
            AdminMatcher.expectedCompanies = expectedCompanies;
            return null;  //To change body of created methods use File | Settings | File Templates.
        }

        @Override
        public boolean matchesSafely(Company company) {

            return false;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void describeTo(Description description) {


        }
    }
}
