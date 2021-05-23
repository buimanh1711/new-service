package com.DichVuDanSinh.Services.impl;

import com.DichVuDanSinh.DTO.AddressDTO;
import com.DichVuDanSinh.Entities.AddressEntity;
import com.DichVuDanSinh.Repository.AddressRepository;
import com.DichVuDanSinh.Services.IAddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public List<AddressDTO> findAll() {
        List<AddressEntity> addressEntities = addressRepository.findAll();
        List<AddressDTO> result = new ArrayList<>();
        for (AddressEntity item :
                addressEntities) {
            AddressDTO dto = new AddressDTO();
            result.add(mapper.map(item, dto.getClass()));
        }
        return result;
    }

    @Override
    public AddressDTO findOne(Long id) {
        AddressEntity addressEntity = addressRepository.findById(id).get();
        AddressDTO addressDTO = new AddressDTO();
        return mapper.map(addressEntity, addressDTO.getClass());
    }

    @Override
    public AddressDTO checkAddress(String city, String district, String ward, String street) {
        AddressEntity addressEntity = addressRepository.checkExistsAddress(city, district, ward, street);
        AddressDTO addressDTO = new AddressDTO();
        return mapper.map(addressEntity, addressDTO.getClass());
    }
}
