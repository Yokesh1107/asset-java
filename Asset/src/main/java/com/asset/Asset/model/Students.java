package com.asset.Asset.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Students {
    @Id
    @Column(name = "studentid")
    private Integer studentId;

    @Column(name = "studentname")
    private String studentName;

    public Students() {

    }
    public Students(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
