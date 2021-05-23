package com.DichVuDanSinh.Services.impl;

import com.DichVuDanSinh.DTO.UserDTO;
import com.DichVuDanSinh.Entities.UserEntity;
import com.DichVuDanSinh.Repository.UserRepository;
import com.DichVuDanSinh.Services.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
     private UserRepository userRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> entityList = userRepository.findAll();
        List<UserDTO> results = new ArrayList<>();
        for (UserEntity item :
                entityList) {
            UserDTO dto = new UserDTO();
            results.add(mapper.map(item, dto.getClass()));
        }
        return results;
    }
}
