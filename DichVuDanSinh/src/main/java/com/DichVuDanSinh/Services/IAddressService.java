package com.DichVuDanSinh.Services;

import com.DichVuDanSinh.DTO.AddressDTO;

import java.util.List;

public interface IAddressService {
    List<AddressDTO> findAll();

    AddressDTO findOne(Long id);

    AddressDTO checkAddress(String city, String district, String ward, String street);
}
