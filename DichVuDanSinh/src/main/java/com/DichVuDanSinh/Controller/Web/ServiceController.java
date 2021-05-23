package com.DichVuDanSinh.Controller.Web;

import com.DichVuDanSinh.DTO.*;
import com.DichVuDanSinh.Entities.CommentEntity;
import com.DichVuDanSinh.Entities.RepCommentEntity;
import com.DichVuDanSinh.Entities.ServiceEntity;
import com.DichVuDanSinh.Repository.CommentRepository;
import com.DichVuDanSinh.Repository.RepCommentRepository;
import com.DichVuDanSinh.Repository.ServiceRepository;
import com.DichVuDanSinh.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController(value = "apiForService")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RepCommentRepository repCommentRepository;


    //Đăng một bình luận
    @PostMapping(value = "/service")
    public ResponseEntity<?>  saveCmt(@RequestBody CommentDTO model){
        Long  userId = userRepository.findByemail(model.getUserName()).getId();
        Long serviceId = Long.parseLong(model.getServiceId());
        ServiceEntity serviceEntity = serviceRepository.findById(serviceId).get();
        CommentEntity commentEntity = new CommentEntity(model.getContent(), userId, model.getRate());
        commentEntity.setServiceEntity(serviceEntity);
        commentRepository.save(commentEntity);
        return ResponseEntity.ok(new MessageResponseDTO("/service/"+serviceId));

    }

    @PostMapping(value = "/comment")
    public ModelAndView saveRep(@RequestParam("commentId") String commentId1, @RequestParam("serviceId") String serviceId1, @RequestParam("contentRepComment") String contentRepComment1 ){
        Long commentId = Long.parseLong(commentId1);
        Long serviceId = Long.parseLong(serviceId1);
        CommentEntity commentEntity = commentRepository.findById(commentId).get();
        RepCommentEntity repCommentEntity = new RepCommentEntity(contentRepComment1,serviceId);
        repCommentEntity.setCommentId(commentEntity);
        repCommentRepository.save(repCommentEntity);
        return new ModelAndView("redirect:/service/"+ serviceId);
    }
}
