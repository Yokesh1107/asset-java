package com.asset.Asset.repository;

import com.asset.Asset.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
    @Query("select s from Students s where s.studentName=:name")
    Optional<List<Students>>findByName(@Param("name") String name);

    @Query("select s from Students s join Devices d on s.studentId=d.studentid join addSoftwareToDevice ds on d.deviceId=ds.deviceId where ds.softwareId=:id")
    List<Students>findBySoftwareId(@Param("id") int id);

    @Query("select s from Students s join Devices d on d.studentid=s.studentId where d.deviceId=:id")
    List<Students>findByDeviceId(@Param("id") int id);


}
