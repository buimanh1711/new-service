package com.DichVuDanSinh.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "DichVu")
public class ServiceEntity extends BaseEntity {

    @Column(name = "Ten")
    private String Name;
    @Column(name = "HoatDong")
    private Integer IsActive;
    @Column(name = "NgayKetthuc")
    private Date EndDate;
    @Column(name = "MoTa")
    private String Description;
    @Column(name = "Anh")
    private String Thumbnail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaChuyenMuc")
    private OrganizeEntity organizeEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceEntity")
    private List<CommentEntity> commentEntities = new ArrayList<>();

    public ServiceEntity() {
    }

    public ServiceEntity(String name, Integer isActive, Date endDate, String description, String thumbnail, OrganizeEntity organizeEntity, List<CommentEntity> commentEntities) {
        Name = name;
        IsActive = isActive;
        EndDate = endDate;
        Description = description;
        Thumbnail = thumbnail;
        this.organizeEntity = organizeEntity;
        this.commentEntities = commentEntities;
    }

    @Transient
    public String getThumbnail() {
        return "/user-photos/" + Thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }

    public OrganizeEntity getOrganizeEntity() {
        return organizeEntity;
    }

    public void setOrganizeEntity(OrganizeEntity organizeEntity) {
        this.organizeEntity = organizeEntity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getIsActive() {
        return IsActive;
    }

    public void setIsActive(Integer isActive) {
        IsActive = isActive;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }
}
