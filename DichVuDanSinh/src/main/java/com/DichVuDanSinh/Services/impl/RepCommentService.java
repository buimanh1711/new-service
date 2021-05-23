package com.DichVuDanSinh.Services.impl;

import com.DichVuDanSinh.DTO.RepCommentDTO;
import com.DichVuDanSinh.Entities.CommentEntity;
import com.DichVuDanSinh.Entities.RepCommentEntity;
import com.DichVuDanSinh.Repository.CommentRepository;
import com.DichVuDanSinh.Repository.RepCommentRepository;
import com.DichVuDanSinh.Services.IRepCommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RepCommentService implements IRepCommentService {

    ModelMapper mapper = new ModelMapper();
    @Autowired
    private RepCommentRepository repCommentRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<RepCommentDTO> findByCommentId(Long id) {
        List<RepCommentEntity> entities = repCommentRepository.findByCommentId(id);
        List<RepCommentDTO> result = new ArrayList<>();
        for (RepCommentEntity item :
                entities) {
            RepCommentDTO dto = new RepCommentDTO();
            result.add(mapper.map(item, dto.getClass()));
        }
        return result;
    }

    @Override
    public RepCommentDTO save(RepCommentDTO model) {
        RepCommentEntity repCommentEntity = new RepCommentEntity();
        if (model.getId() != null) {
            RepCommentEntity oldReComment = repCommentRepository.findById(model.getId()).get();
            repCommentEntity.setId(oldReComment.getId());
            repCommentEntity = mapper.map(model, repCommentEntity.getClass());
        } else {
            repCommentEntity = mapper.map(model, repCommentEntity.getClass());
        }
        Long commentId = Long.parseLong(model.getCommentId());
        CommentEntity commentEntity = commentRepository.findById(commentId).get();
        repCommentEntity.setCommentId(commentEntity);
        repCommentEntity = repCommentRepository.save(repCommentEntity);
        return this.findOne(repCommentEntity.getId());
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id :
                ids) {
            repCommentRepository.deleteById(id);
        }
    }

    @Override
    public RepCommentDTO findOne(Long id) {
        RepCommentEntity entity = repCommentRepository.findById(id).get();
        RepCommentDTO dto = new RepCommentDTO();
        return mapper.map(entity, dto.getClass());
    }
}
