package com.DichVuDanSinh.Repository;

import com.DichVuDanSinh.Entities.RepCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface RepCommentRepository extends JpaRepository<RepCommentEntity, Long> {
    @Query(value = "SELECT * FROM tra_loi_binh_luan WHERE ma_binh_luan = ?1", nativeQuery = true)
    List<RepCommentEntity> findByCommentId(Long id);
}
