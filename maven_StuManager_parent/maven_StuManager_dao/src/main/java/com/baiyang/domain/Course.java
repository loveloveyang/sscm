package com.baiyang.domain;

import java.util.Set;

public class Course {
    private Integer cno;
    private String cname;
    private String cclassroom;
    private double ccredit;

    private Set<Student> student;


    // Constructors

    /**
     * default constructor
     */
    public Course() {
    }

    /**
     * minimal constructor
     */
    public Course(String cname) {
        this.cname = cname;
    }

    /**
     * full constructor
     */
    public Course(String cname, double ccredit, String cclassroom) {
        this.cname = cname;
        this.ccredit = ccredit;
        this.cclassroom = cclassroom;
    }

    public Course(int cNo, String cname, double Ccredit, String cclassroom) {
        this.cno = cNo;
        this.cname = cname;
        this.ccredit = Ccredit;
        this.cclassroom = cclassroom;
    }


    // Property accessors

    public Integer getCno() {
        return this.cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getCcredit() {
        return this.ccredit;
    }

    public void setCcredit(double ccredit) {
        this.ccredit = ccredit;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "Course [cno=" + cno + ", cname=" + cname + ", cclassroom=" + cclassroom + ", ccredit=" + ccredit
                + ", student=" + student + "]";
    }

    public String getCclassroom() {
        return cclassroom;
    }

    public void setCclassroom(String cclassroom) {
        this.cclassroom = cclassroom;
    }


}
