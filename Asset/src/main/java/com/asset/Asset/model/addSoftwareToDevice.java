package com.asset.Asset.model;

import jakarta.persistence.*;

@Entity
@Table(name = "devicesoftware")
public class addSoftwareToDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "deviceid")
    private Integer deviceId;

    @Column(name="softwareid")
    private Integer softwareId;
    public addSoftwareToDevice() {}
    public addSoftwareToDevice(Integer deviceId, Integer softwareId) {
        this.deviceId = deviceId;
        this.softwareId = softwareId;
    }
    public Integer getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
    public Integer getSoftwareId() {
        return softwareId;
    }
    public void setSoftwareId(Integer softwareId) {
        this.softwareId = softwareId;
    }
}
