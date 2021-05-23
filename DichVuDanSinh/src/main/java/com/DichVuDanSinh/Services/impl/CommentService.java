package com.DichVuDanSinh.Services.impl;

import com.DichVuDanSinh.DTO.CommentDTO;
import com.DichVuDanSinh.Entities.CommentEntity;
import com.DichVuDanSinh.Entities.ServiceEntity;
import com.DichVuDanSinh.Repository.CommentRepository;
import com.DichVuDanSinh.Repository.ServiceRepository;
import com.DichVuDanSinh.Services.ICommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CommentService implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<CommentDTO> findAll() {
        List<CommentEntity> entities = commentRepository.findAll();
        List<CommentDTO> result = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (CommentEntity item :
                entities) {
            CommentDTO dto = new CommentDTO();
            result.add(mapper.map(item, dto.getClass()));
        }
        return result;
    }

    @Override
    public CommentDTO findOne(Long id) {
        CommentEntity entity = commentRepository.findById(id).get();
        CommentDTO dto = new CommentDTO();
        ModelMapper mapper = new ModelMapper();
        return mapper.map(entity, dto.getClass());
    }

    @Override
    public CommentDTO save(CommentDTO model) {
        ModelMapper mapper = new ModelMapper();
        CommentEntity commentEntity = new CommentEntity();
        if (model.getId() != null) {
            CommentEntity oldComment = commentRepository.findById(model.getId()).get();
            commentEntity.setId(oldComment.getId());
            commentEntity = mapper.map(model, commentEntity.getClass());
        } else {
            commentEntity = mapper.map(model, commentEntity.getClass());
        }
        Long serviceId = Long.parseLong(model.getServiceId());
        ServiceEntity serviceEntity = serviceRepository.findById(serviceId).get();
        commentEntity.setServiceEntity(serviceEntity);
        commentEntity = commentRepository.save(commentEntity);
        return this.findOne(commentEntity.getId());
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id :
                ids) {
            commentRepository.deleteById(id);
        }
    }

    @Override
    public int getCount() {
        return (int) commentRepository.count();
    }
}
