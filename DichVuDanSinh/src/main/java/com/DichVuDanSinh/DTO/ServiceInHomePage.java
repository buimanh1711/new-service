package com.DichVuDanSinh.DTO;

import java.util.ArrayList;
import java.util.List;

public class ServiceInHomePage {
    private String organize;
    private Long organizeId;
    private List<ServiceDTO> serviceDTOS = new ArrayList<>();


    public ServiceInHomePage() {
    }

    public ServiceInHomePage(String organize, Long organizeId, List<ServiceDTO> serviceDTOS) {
        this.organize = organize;
        this.organizeId = organizeId;
        this.serviceDTOS = serviceDTOS;
    }

    public Long getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Long organizeId) {
        this.organizeId = organizeId;
    }

    public String getOrganize() {
        return organize;
    }

    public void setOrganize(String organize) {
        this.organize = organize;
    }

    public List<ServiceDTO> getServiceDTOS() {
        return serviceDTOS;
    }

    public void setServiceDTOS(List<ServiceDTO> serviceDTOS) {
        this.serviceDTOS = serviceDTOS;
    }
}
