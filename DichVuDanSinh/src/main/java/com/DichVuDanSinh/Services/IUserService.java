package com.DichVuDanSinh.Services;

import com.DichVuDanSinh.DTO.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
}
