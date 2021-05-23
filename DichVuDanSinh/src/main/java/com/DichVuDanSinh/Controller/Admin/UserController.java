package com.DichVuDanSinh.Controller.Admin;

import com.DichVuDanSinh.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/admin/user/del")
    public ModelAndView delete(@RequestParam("userId") String id){
        Long ids = Long.parseLong(id);
        userRepository.deleteById(ids);
        return new ModelAndView("redirect:/admin");
    }
}
