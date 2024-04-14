package com.asset.Asset.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "softwares")
public class Softwares {

    @Column(name = "softwarename")
    private String softwareName;

    @Column(name = "vendorid")
    private Integer vendorId;

    @Id
    @Column(name = "softwareid")
    private int softwareId;

    public Softwares(String softwareName, Integer vendorId, int softwareId) {
        this.softwareName = softwareName;
        this.vendorId = vendorId;
        this.softwareId = softwareId;

    }
    public Softwares() {

    }

    public String getSoftwareName() {
        return softwareName;
    }
    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }
    public Integer getVendorId() {
        return vendorId;
    }
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }
    public int getSoftwareId() {
        return softwareId;
    }
    public  void setSoftwareId(int softwareId) {
        this.softwareId = softwareId;
    }

}
