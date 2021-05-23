package com.DichVuDanSinh.Config;

import java.util.HashSet;

import com.DichVuDanSinh.Entities.OrganizeEntity;
import com.DichVuDanSinh.Entities.RoleEntity;
import com.DichVuDanSinh.Entities.UserEntity;
import com.DichVuDanSinh.Repository.OrganizeRepository;
import com.DichVuDanSinh.Repository.RoleRepository;
import com.DichVuDanSinh.Repository.UserRepository;
import com.DichVuDanSinh.Utils.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        // Roles
        if (roleRepository.findByName(ERole.ROLE_ADMIN.toString()) == null) {
            roleRepository.save(new RoleEntity("ROLE_ADMIN"));
        }

        if (roleRepository.findByName(ERole.ROLE_MEMBER.toString()) == null) {
            roleRepository.save(new RoleEntity("ROLE_MEMBER"));
        }

        // Admin account
        if (userRepository.findByemail("admin@gmail.com") == null) {
            UserEntity admin = new UserEntity();
            admin.setEmail("admin@gmail.com");
            admin.setPassWord(passwordEncoder.encode("123456"));
            HashSet<RoleEntity> roles = new HashSet<>();
            roles.add(roleRepository.findByName(ERole.ROLE_ADMIN.toString()));
            roles.add(roleRepository.findByName(ERole.ROLE_MEMBER.toString()));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        // Member account
        if (userRepository.findByemail("member@gmail.com") == null) {
            UserEntity user = new UserEntity();
            user.setEmail("member@gmail.com");
            user.setPassWord(passwordEncoder.encode("123456"));
            HashSet<RoleEntity> roles = new HashSet<>();
            roles.add(roleRepository.findByName(ERole.ROLE_MEMBER.toString()));
            user.setRoles(roles);
            userRepository.save(user);
        }

    }

}