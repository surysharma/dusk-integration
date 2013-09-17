package com.hedgebenefits.web.controllers.admin.datain;

import com.hedgebenefits.services.DataInService;
import com.hedgebenefits.utils.ModelConstants;
import com.hedgebenefits.utils.View;
import com.hedgebenefits.web.controllers.admin.company.datain.DataInController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

import static com.hedgebenefits.utils.View.datain;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DataInControllerTest {

    @Mock
    private DataInService dataInService;

    @InjectMocks
    private DataInController dataInController = new DataInController(dataInService);

    @Test
    public void should_render_dataIn_view() {
        // given
        // when
        ModelAndView modelAndView = dataInController.dataInView();

        // then
        assertThat(modelAndView.getViewName()).isEqualTo(datain.value());
    }

    @Test
    public void should_redirect_with_error_message_when_file_not_found() throws IOException {
        // given
        MultipartFile multipartFile = Mockito.mock(MultipartFile.class);
        given(multipartFile.getSize()).willReturn(0L);

        // when
        ModelAndView modelAndView = dataInController.performUpload(multipartFile);

        // then
        assertThat(modelAndView.getViewName()).isEqualTo(View.datain.value());
        assertThat(modelAndView.getModelMap().get(ModelConstants.ERROR_FLAG.getName())).isEqualTo(ModelConstants.ERROR_FLAG);
    }

    @Test
    public void should_perform_upload() throws IOException {
        // given
        MultipartFile multipartFile = Mockito.mock(MultipartFile.class);
        given(multipartFile.getSize()).willReturn(2L);
        byte[] bytes = {'a', 'b'};
        given(multipartFile.getBytes()).willReturn(bytes);
        given(multipartFile.getName()).willReturn("someFileName");

        // when
        ModelAndView modelAndView = dataInController.performUpload(multipartFile);

        // then
        assertThat(modelAndView.getViewName()).isEqualTo(View.uploadStatus.value());
        // and
        ArgumentCaptor<File> captor = ArgumentCaptor.forClass(File.class);
        verify(dataInService).upload(captor.capture());
        File file = captor.getValue();
        // and
        assertThat(modelAndView.getModel().get("upload_location")).isNotNull().isEqualTo(file.getAbsolutePath());
    }
}
