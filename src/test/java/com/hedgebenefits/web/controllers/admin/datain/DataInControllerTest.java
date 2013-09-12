package com.hedgebenefits.web.controllers.admin.datain;

import com.hedgebenefits.web.controllers.admin.company.datain.DataInController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import static com.hedgebenefits.utils.View.datain;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DataInControllerTest {

    private DataInController dataInController = new DataInController();

    @Test
    public void should_render_dataIn_view() {
        // given
        // when
        ModelAndView modelAndView = dataInController.dataInView();

        // then
        assertThat(modelAndView.getViewName()).isEqualTo(datain.value());
    }
}
