package com.DichVuDanSinh.Controller.Admin;

import com.DichVuDanSinh.DTO.*;
import com.DichVuDanSinh.Entities.RoleEntity;
import com.DichVuDanSinh.Entities.UserEntity;
import com.DichVuDanSinh.Repository.RoleRepository;
import com.DichVuDanSinh.Repository.UserRepository;
import com.DichVuDanSinh.Services.impl.AddressService;
import com.DichVuDanSinh.Services.impl.OrganizeService;
import com.DichVuDanSinh.Services.impl.UserService;
import com.DichVuDanSinh.Utils.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController(value = "apiForAdmin")
public class HomeController {

    @Autowired
    private OrganizeService organizeService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    // Trang chu admin
    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView mav = new ModelAndView("Admin/index");
        mav.addObject("organizes", organizeService.findAll());
        List<UserDTO> users= userService.findAll();
        mav.addObject("users",users);
        return mav;
    }

    // Chi tiet cua mot to chuc hoac
    @GetMapping(value = "/admin/organizes/information")
    public ModelAndView informationOrganize(@RequestParam String id) {
        ModelAndView mav = new ModelAndView("Admin/editOrganize");
        Long idOrganize = Long.parseLong(id);
        OrganizeDTO organizeDTO = organizeService.findOne(idOrganize);
        AddressDTO addressDTO = addressService.findOne(organizeDTO.getAddressId());
        mav.addObject("infor", organizeDTO);
        mav.addObject("address", addressDTO);
        mav.addObject("organizes", organizeService.findAll());

        List<AddressDTO> addressDTOs = addressService.findAll();
        mav.addObject("addresses", addressDTOs);
        return mav;
    }

    @GetMapping(value = "/admin/organize/add")
    public ModelAndView addInformationOrganize() {
        ModelAndView mav = new ModelAndView("Admin/addOrganize");
        mav.addObject("organizes", organizeService.findAll());
        List<AddressDTO> addressDTO = addressService.findAll();
        mav.addObject("address", addressDTO);
        return mav;
    }

    // Danh sach cac to chuc
    @GetMapping(value = "/admin/organizes/list")
    public ModelAndView showListOrganize(){
        ModelAndView mav = new ModelAndView("Admin/Organizes");
        mav.addObject("organizes", organizeService.findAll());
        return mav;
    }

    // Them moi 1 to chuc
    @PostMapping(value = "/admin/organizes")
    public ResponseEntity<?> save(@RequestBody OrganizeDTO model){
        if (addressService.checkAddress(model.getCity(), model.getDistrict(), model.getWard(), model.getStreet()) != null
                && organizeService.findByName(model.getName()) != null){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Da ton tai don vi"));
        }
        organizeService.save(model);
        return ResponseEntity.ok(new MessageResponseDTO("Thanh cong !!"));
    }

    // Cap nhat mot to chuc
    @PutMapping(value = "/admin/organizes")
    public ResponseEntity<?> update(@RequestBody OrganizeDTO model){
        if (addressService.checkAddress(model.getCity(), model.getDistrict(), model.getWard(), model.getStreet()) != null
                && organizeService.findByName(model.getName()) != null){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Da ton tai don vi"));
        }
        organizeService.save(model);
        return ResponseEntity.ok(new MessageResponseDTO("Thanh cong !!"));
    }

    // Xoa mot to chuc
    @GetMapping(value = "/admin/organizes/deinformation")
    public ModelAndView delete(@RequestParam("id") String id){
        Long ids = Long.parseLong(id);
        organizeService.delete(ids);
        return new ModelAndView("redirect:/admin/organizes/list");
    }

    @GetMapping("/403")
    public ModelAndView accessDenied() {
        ModelAndView mav = new ModelAndView("403");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView mav = new ModelAndView("/login/login");
        return mav;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        ModelAndView mav = new ModelAndView("/web/homepage");
        return mav;
    }

    @PostMapping(value = "/register")
    public ModelAndView register(@RequestBody SignupRequestDTO signupRequestDTO){
        if(userRepository.existsByuserName(signupRequestDTO.getUsername())){
            ModelAndView mav = new ModelAndView("/login/login");
            return mav;
        }
        UserEntity user = new UserEntity(signupRequestDTO.getUsername(),
                signupRequestDTO.getEmail(),
                encoder.encode(signupRequestDTO.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity adminRole = roleRepository.findByName((ERole.ROLE_MEMBER).toString());
        roles.add(adminRole);
        user.setRoles(roles);
        userRepository.save(user);
        ModelAndView mav = new ModelAndView("/login/login");
        return mav;
    }
}
