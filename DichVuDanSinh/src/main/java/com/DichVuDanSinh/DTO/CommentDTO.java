package com.DichVuDanSinh.DTO;

public class CommentDTO extends BaseDTO<CommentDTO> {
    private String Content;
    private String userName;
    private String ServiceId;
    private String rate;

    public CommentDTO() {
    }

    public CommentDTO(String content, String userName, String serviceId, String rate) {
        Content = content;
        this.userName = userName;
        ServiceId = serviceId;
        this.rate = rate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getServiceId() {
        return ServiceId;
    }

    public void setServiceId(String serviceId) {
        ServiceId = serviceId;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}

