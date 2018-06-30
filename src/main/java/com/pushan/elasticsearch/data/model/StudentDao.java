/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pushan.elasticsearch.data.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Pushan
 */
@Entity
@Table(name = "student")
public class StudentDao
        implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int rollNo;
    private float marks;
    private String department;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public StudentDao() {
    }

    public StudentDao(String name, int rollNo, float marks, String department) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        this.department = department;
    }

    /**
     * Get the value of department
     *
     * @return the value of department
     */
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    /**
     * Set the value of department
     *
     * @param department new value of department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Get the value of marks
     *
     * @return the value of marks
     */
    @Column(name = "marks")
    public float getMarks() {
        return marks;
    }

    /**
     * Set the value of marks
     *
     * @param marks new value of marks
     */
    public void setMarks(float marks) {
        this.marks = marks;
    }

    /**
     * Get the value of rollNo
     *
     * @return the value of rollNo
     */
    @Column(name = "rollNo")
    public int getRollNo() {
        return rollNo;
    }

    /**
     * Set the value of rollNo
     *
     * @param rollNo new value of rollNo
     */
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    @Column(name = "name")
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", rollNo=" + rollNo + ", marks=" + marks + ", department=" + department + ", id=" + id + '}';
    }
}
