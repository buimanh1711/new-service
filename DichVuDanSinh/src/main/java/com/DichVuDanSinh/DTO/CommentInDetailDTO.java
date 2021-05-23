package com.DichVuDanSinh.DTO;

import java.util.List;

public class CommentInDetailDTO {
    private Long commentId;
    private String createdBy;
    private String contentComment;
    private List<String> repComment;


    public CommentInDetailDTO() {
    }

    public CommentInDetailDTO(Long commentId, String createdBy, String contentComment) {
        this.commentId = commentId;
        this.createdBy = createdBy;
        this.contentComment = contentComment;
    }

    public List<String> getRepComment() {
        return repComment;
    }

    public void setRepComment(List<String> repComment) {
        this.repComment = repComment;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getContentComment() {
        return contentComment;
    }

    public void setContentComment(String contentComment) {
        this.contentComment = contentComment;
    }

}
