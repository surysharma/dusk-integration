package com.hedgebenefits.web.controllers.admin;


import com.hedgebenefits.utils.ModelConstants;
import com.hedgebenefits.web.controllers.admin.authentication.LoginController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class LoginControllerTest {

    private LoginController loginController = new LoginController();

    @Test
    public void should_render_login_view() {
        // when
        ModelAndView modelAndView = loginController.renderLogin();

        // then
        Assertions.assertThat(modelAndView.getViewName()).isEqualTo("login");
    }

    @Test
    public void should_give_error_for_invalid_username_password() {
        // given
        ModelMap modelMap = new ModelMap();

        // when
        String viewName = loginController.authenticationFailed(modelMap);

        // then
        Assertions.assertThat(viewName).isEqualTo("login");
        Assertions.assertThat(modelMap.get(ModelConstants.AUTHENTICATION_FAIL.value())).isEqualTo(true);
    }
}
