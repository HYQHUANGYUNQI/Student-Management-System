package com.example.demo.entity;

public class SelectedCourse {
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getSel_year() {
        return sel_year;
    }

    public void setSel_year(int sel_year) {
        this.sel_year = sel_year;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private  String sid;
    private  String cid;
    private  int sel_year;
    private  int score;

}
