package com.DichVuDanSinh.Repository;

import com.DichVuDanSinh.Entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    @Query(value = "SELECT * FROM binh_luan WHERE ma_dich_vu = ?1", nativeQuery = true)
    List<CommentEntity> findAddByServiceId(Long id);

    List<CommentEntity> findAll();

    @Query(value = "SELECT COUNT(id) FROM binh_luan WHERE ma_dich_vu = ?1", nativeQuery = true)
    Integer countByServiceId(Long id);

}
