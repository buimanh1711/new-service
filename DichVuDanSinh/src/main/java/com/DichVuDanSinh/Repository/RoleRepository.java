package com.DichVuDanSinh.Repository;

import com.DichVuDanSinh.Entities.RoleEntity;
import com.DichVuDanSinh.Utils.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

   RoleEntity findByName(String name);
}

