package com.DichVuDanSinh.Controller.Admin;

import com.DichVuDanSinh.DTO.MessageResponseDTO;
import com.DichVuDanSinh.DTO.OrganizeDTO;
import com.DichVuDanSinh.DTO.ServiceDTO;
import com.DichVuDanSinh.Services.impl.OrganizeService;
import com.DichVuDanSinh.Services.impl.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController(value = "apiOfService")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private OrganizeService organizeService;

    // show dich vu
    @GetMapping(value = "/admin/service/list")
    public ModelAndView showService(){
        ModelAndView mav = new ModelAndView("Admin/services");
        mav.addObject("organizes", organizeService.findAll());
        mav.addObject("services", serviceService.findAll());
        return mav;
    }

    @GetMapping(value = "/uploadImage/{id}")
    public ModelAndView upload(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("Admin/upload");
        Long idService = Long.parseLong(id);
        ServiceDTO serviceDTO = serviceService.findOne(idService);
        mav.addObject("serviceDetail", serviceDTO);
        return mav;
    }

    // chi tiet cua mot dich vu
    @GetMapping(value = "/admin/service/detail")
    public ModelAndView findOne(@RequestParam("id") String id){
        ModelAndView mav = new ModelAndView("Admin/editService");
        Long idService = Long.parseLong(id);
        ServiceDTO serviceDTO = serviceService.findOne(idService);
        OrganizeDTO organizeDTO = organizeService.findOne(Long.parseLong(serviceDTO.getOrganizeId()));
        mav.addObject("serviceDetail", serviceDTO);
        mav.addObject("organize", organizeDTO);
        mav.addObject("organizes", organizeService.findAll());
        return mav;
    }

    @PostMapping(value ="/admin/service")
    public ResponseEntity<?> save( @RequestBody ServiceDTO model){
         ServiceDTO serviceDTO = serviceService.save(model);
         String url = "/uploadImage/"+serviceDTO.getId();
         return ResponseEntity.ok(new MessageResponseDTO(url));
    }

    // save mot dich vua
    @GetMapping(value ="/admin/service/formadd")
    public ModelAndView formAdd(){
        ModelAndView mav = new ModelAndView("Admin/addService");
        mav.addObject("organizes", organizeService.findAll());
        return mav;
    }

    @PutMapping(value = "/admin/service")
    public ResponseEntity<?> update(@RequestBody ServiceDTO model){
        serviceService.save(model);
        return ResponseEntity.ok(new MessageResponseDTO("Thanh cong !!"));
    }

    @GetMapping(value = "/admin/service/delete")
    public ModelAndView delete(@RequestParam String id){
        Long ids = Long.parseLong(id);
        serviceService.delete(ids);
        return new ModelAndView("redirect:/admin/service/list");
    }
}
