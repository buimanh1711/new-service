package com.DichVuDanSinh.Controller.Web;

import com.DichVuDanSinh.DTO.*;
import com.DichVuDanSinh.Entities.CommentEntity;
import com.DichVuDanSinh.Entities.RepCommentEntity;
import com.DichVuDanSinh.Entities.ServiceEntity;
import com.DichVuDanSinh.Repository.CommentRepository;
import com.DichVuDanSinh.Repository.RepCommentRepository;
import com.DichVuDanSinh.Repository.ServiceRepository;
import com.DichVuDanSinh.Services.impl.AddressService;
import com.DichVuDanSinh.Services.impl.OrganizeService;
import com.DichVuDanSinh.Services.impl.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController(value = "apiForUser")
public class HomeController {

    @Autowired
    private ServiceService serviceService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrganizeService organizeService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private RepCommentRepository repCommentRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    //Tìm kiếm dịch vụ
    @GetMapping(value = "/search")
    public ModelAndView searchService(@RequestParam(value = "name", required = false) String name){
        List<ServiceEntity> results = serviceRepository.findByname(name);
        String index ="web/search";
        ModelAndView mav = new ModelAndView(index);
        mav.addObject("services", results);
        return mav;
    }


    // danh sach don vi
    @GetMapping(value = "/organize")
    public ModelAndView showOrganize(){
        ModelAndView mav = new ModelAndView("web/showOrganizes");
        mav.addObject("organizes", organizeService.findAll());
        return mav;
    }


    @GetMapping(value = "/service/list")
    public ModelAndView showListByOrganize(@RequestParam("id") String id){
        ModelAndView mav = new ModelAndView("/web/showListSerivdeOfOrganize");
        Long ids = Long.parseLong(id);
        OrganizeDTO organizeDTO = organizeService.findOne(ids);
        List<ServiceDTO> serviceDTOS = serviceService.findByOrganizeId1(organizeDTO.getId());
        ServiceInHomePage serviceInHomePage = new ServiceInHomePage(organizeDTO.getName(),organizeDTO.getId(), serviceDTOS);
        mav.addObject("services", serviceInHomePage);
        return mav;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/web/index");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            mav.addObject("userName", username);
        } else {
            String username = principal.toString();
            mav.addObject("userName", username);
        }

        List<ServiceInHomePage> results = new ArrayList<>();
        List<OrganizeDTO> organizeDTOList = organizeService.findAll();
        mav.addObject("organizes", organizeDTOList);
        for (OrganizeDTO item :
                organizeDTOList) {
            List<ServiceDTO> serviceDTOS = serviceService.findByOrganizeId(item.getId());
            ServiceInHomePage serviceInHomePage = new ServiceInHomePage(item.getName(), item.getId(), serviceDTOS);
            results.add(serviceInHomePage);
        }
        mav.addObject("services", results);
        return mav;
    }

    //Danh sách service theo id organize.
    @GetMapping(value = "/service")
    public ModelAndView showServiceByServiceID(@RequestParam("id") String id) {
        String index = "";
        ModelAndView mav = new ModelAndView(index);
        Long idService = Long.parseLong(id);
        List<ServiceDTO> services = serviceService.findByOrganizeId1(idService);
        mav.addObject("services",services);
        return mav;
    }

    // chi tiêt một dịch vụ
    @GetMapping(value = "/service/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView("web/detail");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            mav.addObject("userName", username);
        } else {
            String username = principal.toString();
            mav.addObject("userName", username);
        }
        Long idService = Long.parseLong(id);
        ServiceDTO serviceDTO = serviceService.findOne(idService);
        OrganizeDTO organizeDTO = organizeService.findOne(Long.parseLong(serviceDTO.getOrganizeId()));
        AddressDTO addressDTO = addressService.findOne(organizeDTO.getAddressId());
        mav.addObject("serviceDetail", serviceDTO);
        mav.addObject("organize", organizeDTO);
        mav.addObject("address", addressDTO);
        mav.addObject("organizes", organizeService.findAll());

        //load cmt ra màn hình.
        List<CommentInDetailDTO> results = new ArrayList<>();
        List<CommentEntity> commentEntities = commentRepository.findAddByServiceId(idService);
        for (CommentEntity item :
                commentEntities) {
            List<RepCommentEntity> repCommentEntities = repCommentRepository.findByCommentId(item.getId());
            List<String> repcmts = new ArrayList<>();
            for (RepCommentEntity item1 :
                    repCommentEntities) {
                repcmts.add(item1.getContentRepComment());
            }
            CommentInDetailDTO commentInDetailDTO = new CommentInDetailDTO(item.getId(), item.getCreatedBy(), item.getContentComment());
            commentInDetailDTO.setRepComment(repcmts);
            results.add(commentInDetailDTO);
        }
        mav.addObject("comments", results);

        // tính số sao đánh giá.
        List<CommentEntity> commentEntities1 = commentRepository.findAddByServiceId(idService);
        Long sumRate = 0L;

        for (CommentEntity item :
                commentEntities1) {
            Long tmp = Long.parseLong(item.getRate());
            sumRate += tmp;
        }
        Integer count = commentRepository.countByServiceId(idService);
        Long rating = 5L;
        if (count > 0) {
            rating = sumRate / count;
        }
        mav.addObject("rating", rating);
        return mav;
    }

}
