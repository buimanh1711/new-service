package com.DichVuDanSinh.Services;

import com.DichVuDanSinh.DTO.CommentDTO;

import java.util.List;

public interface ICommentService {
    List<CommentDTO> findAll();

    CommentDTO findOne(Long id);

    CommentDTO save(CommentDTO model);

    void delete(Long[] ids);

    int getCount();
}
