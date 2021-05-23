package com.DichVuDanSinh.Services;

import com.DichVuDanSinh.DTO.ServiceDTO;
import com.DichVuDanSinh.Entities.ServiceEntity;

import java.util.List;

public interface IServiceService {
    List<ServiceDTO> findAll();

    ServiceDTO save(ServiceDTO model);

    ServiceDTO findOne(Long id);

    void delete(Long ids);

    int TotalService();

    void updateImage(String index, Long id);

    List<ServiceDTO> findByOrganizeId(Long id);

    List<ServiceDTO> findByOrganizeId1(Long id);

    List<ServiceDTO> findByName(String name);
}
