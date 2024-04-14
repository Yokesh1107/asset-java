package com.asset.Asset.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendors {

    @Column(name="vendorname")
    private String vendorName;

    @Id
    @Column(name="vendorid")
    private Integer vendorId;
    public Vendors() {

    }
    public Vendors(Integer vendorId, String vendorName) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
    }
    public Integer getVendorId() {
        return vendorId;
    }
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }
    public String getVendorName() {
        return vendorName;
    }
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

}
