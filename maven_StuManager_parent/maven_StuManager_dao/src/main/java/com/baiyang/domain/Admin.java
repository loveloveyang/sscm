package com.baiyang.domain;

public class Admin {
    private Integer ano;
    private String aname;
    private String apassword;
    private String asex;

    public Admin(Integer ano, String aname, String apassword, String asex) {
        this.ano = ano;
        this.aname = aname;
        this.apassword = apassword;
        this.asex = asex;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public String getAsex() {
        return asex;
    }

    public void setAsex(String asex) {
        this.asex = asex;
    }
}
