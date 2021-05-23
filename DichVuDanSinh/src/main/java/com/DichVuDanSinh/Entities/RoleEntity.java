package com.DichVuDanSinh.Entities;


import com.DichVuDanSinh.Utils.ERole;

import javax.persistence.*;

@Entity
@Table(name = "VaiTro")
public class RoleEntity extends BaseEntity {

    @Column(length = 20, name = "Ten")
    private String name;

    public RoleEntity() {
    }

    public RoleEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
