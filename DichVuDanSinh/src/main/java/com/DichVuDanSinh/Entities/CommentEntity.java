package com.DichVuDanSinh.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BinhLuan")
public class CommentEntity extends BaseEntity {

    @Column(name = "NoiDung")
    private String ContentComment;
    @Column(name = "MaNguoiBinhLuan")
    private Long UserId;
    @Column(name = "DanhGia")
    private String rate;

    @OneToMany(mappedBy = "CommentId")
    private List<RepCommentEntity> repCommentEntities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "MaDichVu")
    private ServiceEntity serviceEntity;

    public CommentEntity() {
    }

    public CommentEntity(String contentComment, Long userId, String rate) {
        ContentComment = contentComment;
        UserId = userId;
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getContentComment() {
        return ContentComment;
    }

    public void setContentComment(String contentComment) {
        ContentComment = contentComment;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public List<RepCommentEntity> getRepCommentEntities() {
        return repCommentEntities;
    }

    public void setRepCommentEntities(List<RepCommentEntity> repCommentEntities) {
        this.repCommentEntities = repCommentEntities;
    }

    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }
}
