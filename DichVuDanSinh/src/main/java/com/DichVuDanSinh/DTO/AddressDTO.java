package com.DichVuDanSinh.DTO;

public class AddressDTO extends BaseDTO<AddressDTO> {
    private String City;
    private String District;
    private String Ward;
    private String Street;

    public AddressDTO() {
    }

    public AddressDTO(String city, String district, String ward, String street) {
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
}
