package com.asset.Asset.repository;

import com.asset.Asset.model.Softwares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SoftwareRepository extends JpaRepository<Softwares,Integer> {
    @Query("SELECT s FROM Softwares s WHERE s.softwareName = :name")
    Optional<Softwares> findByName(@Param("name") String name);

    @Query("select s from Softwares s where s.vendorId=:id")
    List<Softwares> findVendorId(@Param("id") Integer id);

    @Query("select s from Softwares s inner join addSoftwareToDevice ds on s.softwareId=ds.softwareId where ds.deviceId=:id")
    List<Softwares> findByDeviceId(@Param("id") Integer id);

    @Query("select s from Softwares s join addSoftwareToDevice ds on s.softwareId=ds.softwareId join Devices d on ds.deviceId=d.deviceId where d.studentid=:id")
    List<Softwares> findByStudentId(@Param("id") Integer id);

    @Query("select s from Softwares s")
    List<Softwares> findAllSoftwares();


}
