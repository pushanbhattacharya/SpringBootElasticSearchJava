/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pushan.elasticsearch.data.model;

import javax.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 *
 * @author Pushan
 */
@Document(indexName = "student-index",
          type = "student-type",
          shards = 1,
          replicas = 0,
          refreshInterval = "-1")
public class StudentDocument {

    @Id
    private long id;
    private String name;
    private int rollNo;
    private float marks;
    private String department;

    public StudentDocument(long registraionNo, String name, int rollNo, float marks, String department) {
        this.id = registraionNo;
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        this.department = department;
    }

    public StudentDocument() {
    }

    public long getRegistraionNo() {
        return id;
    }

    public void setRegistraionNo(long registraionNo) {
        this.id = registraionNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "StudentDocument{" + "registraionNo=" + id + ", name=" + name + ", rollNo=" + rollNo + ", marks=" + marks + ", department=" + department + '}';
    }

}
