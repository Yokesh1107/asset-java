package com.asset.Asset.repository;

import com.asset.Asset.model.Devices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DevicesRepository extends JpaRepository<Devices,Integer> {
    @Query("select d from Devices d where d.deviceName=:name")
    Optional<List<Devices>> findByName(@Param("name") String name);

    @Query("select d from Devices d join addSoftwareToDevice ds on d.deviceId=ds.deviceId where ds.softwareId=:id")
    List<Devices> findBySoftwareId(@Param("id") int id);

    @Query("select d from Devices d where d.studentid=:id")
    List<Devices> findByStudentId(@Param("id") int id);

    @Query("select d from Devices d")
    List<Devices> findAllDeviceNames();

}
