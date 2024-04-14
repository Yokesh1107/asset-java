package com.asset.Asset.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="devices")
public class Devices {
    @Id
    @Column(name = "deviceid")
    private Integer deviceId;

    @Column(name="devicename")
    private String deviceName;

    @Column(name = "studentid")
    private Integer studentid;

    public Devices(){

    }
    public Devices(Integer deviceId, String deviceName, Integer studentid) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.studentid = studentid;
    }
    public Integer getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public Integer getStudentid() {
        return studentid;
    }
    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }
}
