package com.DichVuDanSinh.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NguoiDung", uniqueConstraints = {@UniqueConstraint(columnNames = "TenNguoiDung"),
        @UniqueConstraint(columnNames = "email")})
public class UserEntity extends BaseEntity {

    @Column(name = "TenNguoiDung")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "MatKhau")
    private String passWord;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "MaNguoiDung"), inverseJoinColumns = @JoinColumn(name = "MaVaiTro"))
    private Set<RoleEntity> roles = new HashSet<>();

    public UserEntity() {
    }

    public UserEntity(String userName, String email, String passWord) {
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}

