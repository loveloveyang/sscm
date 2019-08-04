package com.baiyang.domain;

public class Sc {

    public Sc() {

    }
    public Sc(int sno,int cno){
        this.sno=sno;
        this.cno=cno;
    }
    private int sno;
    private int cno;

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

}
