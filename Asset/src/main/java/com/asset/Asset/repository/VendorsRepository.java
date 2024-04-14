package com.asset.Asset.repository;

import com.asset.Asset.model.Vendors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VendorsRepository extends JpaRepository<Vendors, Integer> {
    @Query("SELECT v from Vendors  v where v.vendorName=:name")
    Optional<Vendors> findByName(@Param("name") String name);

}
