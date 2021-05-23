package com.DichVuDanSinh.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ChuyenMuc")
public class OrganizeEntity extends BaseEntity {

    @Column(name = "Ten")
    private String name;

    @Column(name = "NgayTaoDichVu")
    private Date Founding;

    @Column(name = "NguoiDungDau")
    private String LeadContact;

    @ManyToOne
    @JoinColumn(name = "MaDiaChi")
    private AddressEntity addressEntity;

    @OneToMany(mappedBy = "organizeEntity")
    private List<ServiceEntity> serviceEntities = new ArrayList<>();

    public OrganizeEntity() {
    }

    public OrganizeEntity(String name, Date founding, String leadContact, AddressEntity addressEntity, List<ServiceEntity> serviceEntities) {
        this.name = name;
        Founding = founding;
        LeadContact = leadContact;
        this.addressEntity = addressEntity;
        this.serviceEntities = serviceEntities;
    }

    public List<ServiceEntity> getServiceEntities() {
        return serviceEntities;
    }

    public void setServiceEntities(List<ServiceEntity> serviceEntities) {
        this.serviceEntities = serviceEntities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFounding() {
        return Founding;
    }

    public void setFounding(Date founding) {
        Founding = founding;
    }

    public String getLeadContact() {
        return LeadContact;
    }

    public void setLeadContact(String leadContact) {
        LeadContact = leadContact;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}

