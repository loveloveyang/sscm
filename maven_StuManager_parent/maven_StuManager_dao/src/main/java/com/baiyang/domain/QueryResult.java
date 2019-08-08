package com.baiyang.domain;

public class QueryResult {

    private int sno;
    private int cno;
    private String sname;
    private String sclass;
    private String ssex;
    private String cname;
    private Double ccredit;
    private String cclassroom;

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Double getScredit() {
        return scredit;
    }

    public void setScredit(Double scredit) {
        this.scredit = scredit;
    }

    private Double scredit;

    public Double getCcredit() {
        return ccredit;
    }

    public void setCcredit(Double ccredit) {
        this.ccredit = ccredit;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCclassroom() {
        return cclassroom;
    }

    public void setCclassroom(String cclassroom) {
        this.cclassroom = cclassroom;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "sno=" + sno +
                ", cno=" + cno +
                ", sname='" + sname + '\'' +
                ", sclass='" + sclass + '\'' +
                ", ssex='" + ssex + '\'' +
                ", cname='" + cname + '\'' +
                ", ccredit=" + ccredit +
                ", cclassroom='" + cclassroom + '\'' +
                ", scredit=" + scredit +
                '}';
    }
}
