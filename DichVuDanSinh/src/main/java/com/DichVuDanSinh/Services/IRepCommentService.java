package com.DichVuDanSinh.Services;

import com.DichVuDanSinh.DTO.RepCommentDTO;

import java.util.List;

public interface IRepCommentService {
    List<RepCommentDTO> findByCommentId(Long id);

    RepCommentDTO save(RepCommentDTO model);

    void delete(Long[] ids);

    RepCommentDTO findOne(Long id);
}
