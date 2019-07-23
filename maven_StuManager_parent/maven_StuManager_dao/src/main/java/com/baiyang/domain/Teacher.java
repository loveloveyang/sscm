package com.baiyang.domain;

import java.util.Set;

public class Teacher {

    private Integer tno;
    private String tname;
    private String tpassword;
    private Course course;
    private Set<Student> student;

    // Constructors

    /**
     * default constructor
     */
    public Teacher() {
    }


    /**
     * full constructor
     */
    public Teacher(String tname, String tpassword) {
        this.tname = tname;
        this.tpassword = tpassword;
    }

    public Teacher(int tNo, String tname, String tpassword) {
        this.tno = tNo;
        this.tname = tname;
        this.tpassword = tpassword;
    }


    // Property accessors

    public Integer getTno() {
        return this.tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public String getTname() {
        return this.tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpassword() {
        return this.tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }


    public Course getCourse() {
        return course;
    }


    public void setCourse(Course course) {
        this.course = course;
    }


    public Set<Student> getStudent() {
        return student;
    }


    public void setStudent(Set<Student> student) {
        this.student = student;
    }

}
