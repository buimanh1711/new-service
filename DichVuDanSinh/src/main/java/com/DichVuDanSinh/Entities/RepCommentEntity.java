package com.DichVuDanSinh.Entities;

import javax.persistence.*;

@Entity
@Table(name = "TraLoiBinhLuan")
public class RepCommentEntity extends BaseEntity {

    @Column(name = "NoiDung")
    private String ContentRepComment;

    @Column(name = "MaDichVu")
    private Long serviceId;

    @ManyToOne
    @JoinColumn(name = "MaBinhLuan")
    private CommentEntity CommentId;

    public RepCommentEntity() {
    }

    public RepCommentEntity(String contentRepComment, Long serviceId) {
        ContentRepComment = contentRepComment;
        this.serviceId = serviceId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getContentRepComment() {
        return ContentRepComment;
    }

    public void setContentRepComment(String contentRepComment) {
        ContentRepComment = contentRepComment;
    }

    public CommentEntity getCommentId() {
        return CommentId;
    }

    public void setCommentId(CommentEntity commentId) {
        CommentId = commentId;
    }
}

