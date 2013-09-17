package com.hedgebenefits.web.controllers.admin.company.datain;

import com.hedgebenefits.services.DataInService;
import com.hedgebenefits.utils.ModelConstants;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

import static com.hedgebenefits.utils.View.datain;
import static com.hedgebenefits.utils.View.uploadStatus;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/admin")
public class DataInController {

    private DataInService dataInService;
    private String uploadFilePath = "/tmp";

    @Autowired
    public DataInController(DataInService dataInService) {
        this.dataInService = dataInService;
    }

    //TODO: Why @RequestMapping is not resolving enum constants
    @RequestMapping("/company/datain")
    public ModelAndView dataInView() {
        return new ModelAndView(datain.value());
    }

    @RequestMapping(value = "/company/datain/upload", method = POST)
    public ModelAndView performUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        long size = multipartFile.getSize();
        if (size == 0) {
            return new ModelAndView(datain.value()).addObject(ModelConstants.ERROR_FLAG.getName(), ModelConstants.ERROR_FLAG);
        }
        File uploadFile = createFileForUpload(multipartFile);
        dataInService.upload(uploadFile);
        return new ModelAndView(uploadStatus.value()).addObject("upload_location", uploadFile.getAbsolutePath());
    }

    private File createFileForUpload(MultipartFile multipartFile) throws IOException {
        File uploadFile = new File(String.format("%s/%s", uploadFilePath, multipartFile.getName()));
        FileUtils.write(uploadFile, new String(multipartFile.getBytes()));
        return uploadFile;
    }
}
