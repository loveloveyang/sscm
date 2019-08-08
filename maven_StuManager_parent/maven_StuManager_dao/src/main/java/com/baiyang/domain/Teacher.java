package com.baiyang.domain;

import java.util.Set;

public class Teacher {

    private Integer tno;
    private String tname;
    private String tpassword;
    private String tsex;
    private String ttelephone;
    private String tcollege;
    private String temail;
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

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTtelephone() {
        return ttelephone;
    }

    public void setTtelephone(String ttelephone) {
        this.ttelephone = ttelephone;
    }

    public String getTcollege() {
        return tcollege;
    }

    public void setTcollege(String tcollege) {
        this.tcollege = tcollege;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "tno=" + tno +
                ", tname='" + tname + '\'' +
                ", tpassword='" + tpassword + '\'' +
                ", tsex='" + tsex + '\'' +
                ", ttelephone='" + ttelephone + '\'' +
                ", tcollege='" + tcollege + '\'' +
                ", ttemail='" + temail + '\'' +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}
