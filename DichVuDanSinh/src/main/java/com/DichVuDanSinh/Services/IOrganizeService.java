package com.DichVuDanSinh.Services;

import com.DichVuDanSinh.DTO.OrganizeDTO;

import java.util.List;

public interface IOrganizeService {

    List<OrganizeDTO> findAll();

    OrganizeDTO save(OrganizeDTO model);

    void delete(Long ids);

    OrganizeDTO findOne(Long id);

    OrganizeDTO findByName(String name);
}
