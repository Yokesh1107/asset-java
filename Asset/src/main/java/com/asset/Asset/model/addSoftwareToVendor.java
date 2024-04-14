package com.asset.Asset.model;

public class addSoftwareToVendor {
    private int softwareId;
    private int vendorId;
    public addSoftwareToVendor(int softwareId, int vendorId) {
        this.softwareId = softwareId;
        this.vendorId = vendorId;
    }
    public addSoftwareToVendor() {}
    public int getSoftwareId() {
        return softwareId;
    }
    public void setSoftwareId(int softwareId) {
        this.softwareId = softwareId;
    }
    public int getVendorId() {
        return vendorId;
    }
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }
}
