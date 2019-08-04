package com.baiyang.domain;

import java.util.Set;

public class Student {
    private Integer sno;
    private String sname;
    private String spassword;
    private String sclass;
    private String ssex;

    private double scredit=0.0;
    public static float MinScore = 7;
    public static float MaxScore = 12;
    private Set<Course> course;

    // Constructors
    public Student() {
    }

    /**
     * minimal constructor
     */
    public Student(String sname, String spassword) {
        this.sname = sname;
        this.spassword = spassword;
    }

    /**
     * full constructor
     */
    public Student(String sname, String spassword, String sclass, String ssex) {
        this.sname = sname;
        this.spassword = spassword;
        this.sclass = sclass;
        this.ssex = ssex;
    }

    public Student(int sNo, String sname, String spassword, String sclass,
                   String ssex) {
        this.sno = sNo;
        this.sname = sname;
        this.spassword = spassword;
        this.sclass = sclass;
        this.ssex = ssex;

    }

    public Student(int sNo, String sname, String spassword, String sclass,
                   String ssex, double scredit) {
        this.sno = sNo;
        this.sname = sname;
        this.spassword = spassword;
        this.sclass = sclass;
        this.ssex = ssex;
        this.scredit = scredit;
    }

    public Student(String sname, String spassword, String sclass,
                   String ssex, double scredit) {
        this.sname = sname;
        this.spassword = spassword;
        this.sclass = sclass;
        this.ssex = ssex;
        this.scredit = scredit;
    }

    /**
     * default constructor
     */

    // Property accessors
    public Integer getSno() {
        return this.sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return this.sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return this.spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getSclass() {
        return this.sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getSsex() {
        return this.ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public double getScredit() {
        return scredit;
    }

    public void setScredit(double scredit) {
        this.scredit = scredit;
    }


    @Override
    public String toString() {
        return "Student [sno=" + sno + ", sname=" + sname + ", spassword=" + spassword + ", sclass=" + sclass
                + ", ssex=" + ssex + ", scredit=" + scredit + ", course=" + course + "]";
    }

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }


}
