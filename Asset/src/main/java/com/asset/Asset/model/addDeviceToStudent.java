package com.asset.Asset.model;

public class addDeviceToStudent {
    private Integer deviceId;
    private Integer studentId;
    public addDeviceToStudent(Integer deviceId, Integer studentId) {
        this.deviceId = deviceId;
        this.studentId = studentId;
    }
    public addDeviceToStudent() {}
    public Integer getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

}
