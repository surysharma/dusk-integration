package com.hedgebenefits.web.controllers.admin.company;


import com.hedgebenefits.utils.View;
import com.hedgebenefits.web.controllers.admin.company.home.CompanyHomeController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class CompanyHomeControllerTest {
    private CompanyHomeController companyHomeController = new CompanyHomeController();

    @Test
    public void should_render_login_view() {
        // when
        ModelAndView modelAndView = companyHomeController.renderHomeView();

        // then
        Assertions.assertThat(modelAndView.getViewName()).isEqualTo(View.company.value());
    }
}
