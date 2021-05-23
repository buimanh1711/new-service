package com.DichVuDanSinh.DTO;

public class RoleDTO extends BaseDTO<RoleDTO> {
    private String code;
    private String name;

    public RoleDTO() {
    }

    public RoleDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

