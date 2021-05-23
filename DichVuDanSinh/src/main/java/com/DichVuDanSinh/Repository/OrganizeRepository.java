package com.DichVuDanSinh.Repository;

import com.DichVuDanSinh.Entities.OrganizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizeRepository extends JpaRepository<OrganizeEntity, Long> {

    @Query(value = "SELECT * FROM chuyen_muc WHERE ten = ?1", nativeQuery = true)
    OrganizeEntity findByname(String name);
}
