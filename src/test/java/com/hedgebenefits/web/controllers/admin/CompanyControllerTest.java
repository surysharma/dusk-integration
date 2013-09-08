package com.hedgebenefits.web.controllers.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import static com.hedgebenefits.utils.View.company;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CompanyControllerTest {

    private CompanyController companyController = new CompanyController();

    @Test
    public void should_render_login_view() {
        // given
        // when
        ModelAndView modelAndView = companyController.renderLoginView();

        // then
        assertThat(modelAndView.getViewName()).isEqualTo(company.value());

    }
}
