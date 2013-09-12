package com.hedgebenefits.web.controllers.home;

import com.hedgebenefits.web.controllers.HomeController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static com.hedgebenefits.utils.View.home;

public class HomeControllerTest {


    private HomeController homeController = new HomeController();

    @Test
    public void should_render_home_view() {
        // when
        ModelAndView modelAndView = homeController.renderHomeView();

        // then
        Assertions.assertThat(modelAndView.getViewName()).isEqualTo(home.value());
    }
}
