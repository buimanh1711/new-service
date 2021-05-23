package com.DichVuDanSinh.DTO;

import java.util.Date;
import java.util.List;

public class ServiceDTO extends BaseDTO<ServiceDTO>{
    private String Name;
    private Integer IsActive;
    private Date EndDate;
    private String Description;
    private String Thumbnail;
    private String OrganizeName;
    private String OrganizeId;
    private Long CommentId;
    private Date createdDate;

    public ServiceDTO() {
    }

    public ServiceDTO(String name, Integer isActive, Date endDate, String description, String thumbnail, String organizeName, String organizeId, Long commentId, Date createdDate) {
        Name = name;
        IsActive = isActive;
        EndDate = endDate;
        Description = description;
        Thumbnail = thumbnail;
        OrganizeName = organizeName;
        OrganizeId = organizeId;
        CommentId = commentId;
        this.createdDate = createdDate;
    }

    public String getOrganizeId() {
        return OrganizeId;
    }

    public void setOrganizeId(String organizeId) {
        OrganizeId = organizeId;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }



    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
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

    public String getOrganizeName() {
        return OrganizeName;
    }
    public void setOrganizeName(String organizeName) {
        OrganizeName = organizeName;
    }

    public Long getCommentId() {
        return CommentId;
    }

    public void setCommentId(Long commentId) {
        CommentId = commentId;
    }
}
