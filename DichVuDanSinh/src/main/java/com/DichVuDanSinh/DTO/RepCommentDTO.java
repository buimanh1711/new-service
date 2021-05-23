package com.DichVuDanSinh.DTO;

public class RepCommentDTO extends BaseDTO<RepCommentDTO> {
    private String CommentId;
    private String ServiceId;
    private String ContentRepComment;


    public RepCommentDTO() {
    }

    public RepCommentDTO(String commentId, String serviceId, String contentRepComment) {
        CommentId = commentId;
        ServiceId = serviceId;
        ContentRepComment = contentRepComment;
    }

    public String getCommentId() {
        return CommentId;
    }

    public void setCommentId(String commentId) {
        CommentId = commentId;
    }

    public String getServiceId() {
        return ServiceId;
    }

    public void setServiceId(String serviceId) {
        ServiceId = serviceId;
    }

    public String getContentRepComment() {
        return ContentRepComment;
    }

    public void setContentRepComment(String contentRepComment) {
        ContentRepComment = contentRepComment;
    }
}
