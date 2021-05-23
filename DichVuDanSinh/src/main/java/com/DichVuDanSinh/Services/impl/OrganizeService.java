package com.DichVuDanSinh.Services.impl;

import com.DichVuDanSinh.DTO.OrganizeDTO;
import com.DichVuDanSinh.Entities.AddressEntity;
import com.DichVuDanSinh.Entities.OrganizeEntity;
import com.DichVuDanSinh.Repository.AddressRepository;
import com.DichVuDanSinh.Repository.OrganizeRepository;
import com.DichVuDanSinh.Services.IOrganizeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizeService implements IOrganizeService {

    @Autowired
    private OrganizeRepository organizeRepository;
    @Autowired
    private AddressRepository addressRepository;


    @Override
    public List<OrganizeDTO> findAll() {
        ModelMapper mapper = new ModelMapper();
        List<OrganizeEntity> entities = organizeRepository.findAll();
        List<OrganizeDTO> result = new ArrayList<>();
        for (OrganizeEntity item :
                entities) {
            OrganizeDTO dto = new OrganizeDTO();
            result.add(mapper.map(item, dto.getClass()));
        }
        return result;
    }

    @Override
    public OrganizeDTO save(OrganizeDTO model) {
        ModelMapper mapper = new ModelMapper();
        OrganizeEntity organizeEntity = new OrganizeEntity();
        if (model.getId() != null) {
            OrganizeEntity oldOrganizeEntity = new OrganizeEntity();
            organizeEntity.setId(oldOrganizeEntity.getId());
            organizeEntity = mapper.map(model, organizeEntity.getClass());
        } else {
            organizeEntity = mapper.map(model, organizeEntity.getClass());
        }
        AddressEntity addressEntity = addressRepository.checkExistsAddress(model.getCity(), model.getDistrict(), model.getWard(), model.getStreet());
        organizeEntity.setAddressEntity(addressEntity);
        organizeEntity = organizeRepository.save(organizeEntity);
        return this.findOne(organizeEntity.getId());
    }

    @Override
    public void delete(Long id) {
        organizeRepository.deleteById(id);
    }

    @Override
    public OrganizeDTO findOne(Long id) {
        ModelMapper mapper = new ModelMapper();
        OrganizeEntity entity = organizeRepository.findById(id).get();
        OrganizeDTO dto = new OrganizeDTO();
        return mapper.map(entity, dto.getClass());
    }

    @Override
    public OrganizeDTO findByName(String name) {
        ModelMapper mapper = new ModelMapper();
        OrganizeEntity entity = organizeRepository.findByname(name);
        if (entity == null){
            return null;
        }
        OrganizeDTO dto = new OrganizeDTO();
        return mapper.map(entity, dto.getClass());
    }
}
