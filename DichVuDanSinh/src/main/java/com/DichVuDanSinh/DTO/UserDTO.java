package com.DichVuDanSinh.DTO;

import java.util.Date;

public class UserDTO extends BaseDTO<UserDTO> {

    private String userName;

    private String passWord;

    private String email;

    private Date createdDate;

    public UserDTO() {

    }

    public UserDTO(String userName, String passWord, String email, Date createdDate) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
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

}
