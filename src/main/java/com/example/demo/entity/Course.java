package com.example.demo.entity;

public class Course {
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit_char) {
        this.credit = credit_char;
    }

    public String getSuit_grade() {
        return suit_grade;
    }

    public void setSuit_grade(String suit_grade) {
        this.suit_grade = suit_grade;
    }

    public String getCanc_year() {
        return canc_year;
    }

    public void setCanc_year(String canc_year) {
        this.canc_year = canc_year;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    private  String cid;
    private String cname;
    private  String tname;
    private  String credit;
    private  String suit_grade;
    private String canc_year;


}
