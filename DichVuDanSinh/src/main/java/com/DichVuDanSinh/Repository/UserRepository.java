package com.DichVuDanSinh.Repository;

import com.DichVuDanSinh.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByuserName(String username);

    Boolean existsByuserName(String username);

    Boolean existsByEmail(String email);

    UserEntity findByemail(String email);

}
