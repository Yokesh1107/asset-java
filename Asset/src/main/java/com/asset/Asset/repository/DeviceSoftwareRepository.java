package com.asset.Asset.repository;

import com.asset.Asset.model.addSoftwareToDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DeviceSoftwareRepository extends JpaRepository<addSoftwareToDevice, Integer> {
    @Query("select d from addSoftwareToDevice d where d.deviceId=:did and d.softwareId=:sid")
    Optional<addSoftwareToDevice> checkExists(@Param("did") int deviceId, @Param("sid") int softwareId);

}
