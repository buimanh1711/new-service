package com.DichVuDanSinh.DTO;

import java.util.Date;

public class OrganizeDTO extends BaseDTO<OrganizeDTO>{
    private String name;
    private Date Founding;
    private String LeadContact;
    private Long AddressId;
    private String City;
    private String District;
    private String Ward;
    private String Street;
    private Date createdDate;

    public OrganizeDTO() {
    }

    public OrganizeDTO(String name, Date founding, String leadContact, Long addressId, String city, String district, String ward, String street, Date createdDate) {
        this.name = name;
        Founding = founding;
        LeadContact = leadContact;
        AddressId = addressId;
        City = city;
        District = district;
        Ward = ward;
        Street = street;
        this.createdDate = createdDate;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public Long getAddressId() {
        return AddressId;
    }

    public void setAddressId(Long addressId) {
        AddressId = addressId;
    }
}
