package com.DichVuDanSinh.Repository;

import com.DichVuDanSinh.Entities.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE dich_vu SET anh = ?1 WHERE id = ?2", nativeQuery = true)
    void UpdateImage(String index,Long id);

    @Query(value = "SELECT * FROM dich_vu WHERE ma_chuyen_muc =?1 LIMIT 4", nativeQuery = true)
    List<ServiceEntity> findByOrganizeId(Long id);

    @Query(value = "SELECT * FROM dich_vu WHERE ma_chuyen_muc =?1", nativeQuery = true)
    List<ServiceEntity> findByOrganizeId1(Long id);

    @Query(value = "SELECT * FROM dich_vu WHERE dich_vu.ten like %?1% ", nativeQuery = true)
    List<ServiceEntity> findByname(String name);
}
