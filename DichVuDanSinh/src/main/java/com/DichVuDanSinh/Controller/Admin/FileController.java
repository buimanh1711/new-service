package com.DichVuDanSinh.Controller.Admin;

import com.DichVuDanSinh.DTO.ServiceDTO;
import com.DichVuDanSinh.Entities.ServiceEntity;
import com.DichVuDanSinh.Services.impl.ServiceService;
import com.DichVuDanSinh.Utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
public class FileController {


    @Autowired
    private ServiceService serviceService;

    @PostMapping("/uploadFile/{id}")
    public RedirectView saveUser(ServiceEntity serviceEntity,
                                 @PathVariable String id , @RequestParam("file") MultipartFile file) throws IOException {

        ServiceDTO serviceDTO = serviceService.findOne(Long.parseLong(id));

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        serviceDTO.setThumbnail(fileName);
        serviceService.updateImage(fileName, Long.parseLong(id));

        String uploadDir = "user-photos/";

        FileUploadUtil.saveFile(uploadDir, fileName, file);

        return new RedirectView("/", true);
    }


}
