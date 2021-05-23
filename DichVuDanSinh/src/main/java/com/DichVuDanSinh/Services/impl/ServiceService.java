package com.DichVuDanSinh.Services.impl;

import com.DichVuDanSinh.DTO.ServiceDTO;
import com.DichVuDanSinh.Entities.OrganizeEntity;
import com.DichVuDanSinh.Entities.ServiceEntity;
import com.DichVuDanSinh.Repository.CommentRepository;
import com.DichVuDanSinh.Repository.OrganizeRepository;
import com.DichVuDanSinh.Repository.ServiceRepository;
import com.DichVuDanSinh.Services.IServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private OrganizeRepository organizeRepository;
    @Autowired
    private CommentRepository commentRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public List<ServiceDTO> findAll() {
        List<ServiceEntity> entities = serviceRepository.findAll();
        List<ServiceDTO> result = new ArrayList<>();
        for (ServiceEntity item :
                entities) {
            ServiceDTO dto = new ServiceDTO();
            result.add(mapper.map(item, dto.getClass()));
        }
        return result;
    }

    @Override
    public ServiceDTO save(ServiceDTO model) {
        ServiceEntity serviceEntity = new ServiceEntity();
        if (model.getId() != null) {
            ServiceEntity oldServiceEntity = serviceRepository.findById(model.getId()).get();
            serviceEntity.setId(oldServiceEntity.getId());
            serviceEntity = mapper.map(model, serviceEntity.getClass());
            serviceEntity.setThumbnail(oldServiceEntity.getThumbnail1());
            if (model.getDescription() == ""){
                serviceEntity.setDescription(oldServiceEntity.getDescription());
            }
        } else {
            serviceEntity = mapper.map(model, serviceEntity.getClass());
        }
        OrganizeEntity organizeEntity = organizeRepository.findByname(model.getOrganizeName());
        serviceEntity.setOrganizeEntity(organizeEntity);
        serviceEntity = serviceRepository.save(serviceEntity);
        return this.findOne(serviceEntity.getId());
    }

    @Override
    public ServiceDTO findOne(Long id) {
        ServiceEntity entity = serviceRepository.findById(id).get();
        ServiceDTO dto = new ServiceDTO();
        return mapper.map(entity, dto.getClass());
    }

    @Override
    public void delete(Long ids) {
        serviceRepository.deleteById(ids);
    }

    @Override
    public int TotalService() {
        return (int) serviceRepository.count();
    }

    @Override
    public void updateImage(String index,Long id) {
        serviceRepository.UpdateImage(index, id);
    }

    @Override
    public List<ServiceDTO> findByOrganizeId(Long id) {
        List<ServiceEntity> entityList = serviceRepository.findByOrganizeId(id);
        List<ServiceDTO> results = new ArrayList<>();
        for (ServiceEntity item :
                entityList) {
            ServiceDTO dto = new ServiceDTO();
            results.add(mapper.map(item, dto.getClass()));
        }
        return results;
    }

    @Override
    public List<ServiceDTO> findByOrganizeId1(Long id) {
        List<ServiceEntity> entityList = serviceRepository.findByOrganizeId1(id);
        List<ServiceDTO> results = new ArrayList<>();
        for (ServiceEntity item :
                entityList) {
            ServiceDTO dto = new ServiceDTO();
            results.add(mapper.map(item, dto.getClass()));
        }
        return results;
    }


    @Override
    public List<ServiceDTO> findByName(String name) {
        List<ServiceEntity> entityList = serviceRepository.findByname(name);
        List<ServiceDTO> results = new ArrayList<>();
        for (ServiceEntity item :
                entityList) {
            ServiceDTO dto = new ServiceDTO();
            results.add(mapper.map(item, dto.getClass()));
        }
        return results;
    }
}
