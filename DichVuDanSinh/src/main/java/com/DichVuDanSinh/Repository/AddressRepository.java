package com.DichVuDanSinh.Repository;

import com.DichVuDanSinh.Entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query(value = "SELECT * FROM dia_chi where thanh_pho=?1 and quan=?2 and phuong=?3 and pho = ?4", nativeQuery = true)
    AddressEntity checkExistsAddress(String city, String district, String ward, String street);
}
