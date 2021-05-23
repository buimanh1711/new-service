package com.DichVuDanSinh.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DiaChi")
public class AddressEntity extends BaseEntity {

    @OneToMany(mappedBy = "addressEntity")
    private final List<OrganizeEntity> organizeEntities = new ArrayList<>();

    @Column(name = "ThanhPho")
    private String City;
    @Column(name = "Quan")
    private String District;
    @Column(name = "Phuong")
    private String Ward;
    @Column(name = "Pho")
    private String Street;

    public AddressEntity() {
    }

    public AddressEntity(String city, String district, String ward, String street) {
        City = city;
        District = district;
        Ward = ward;
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getWard() {
        return Ward;
    }

    public void setWard(String ward) {
        Ward = ward;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public List<OrganizeEntity> getOrganizeEntities() {
        return organizeEntities;
    }
}

