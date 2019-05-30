package com.example.demo.entity;

import java.util.Date;
import java.util.List;

public class Tie {
    private Integer tieid;

    private String tiename;

    private String tietype;

    private Date publishtime;

    private String author;

    private String tiecontent;



    public Integer getTieid() {
        return tieid;
    }

    public void setTieid(Integer tieid) {
        this.tieid = tieid;
    }

    public String getTiename() {
        return tiename;
    }

    public void setTiename(String tiename) {
        this.tiename = tiename == null ? null : tiename.trim();
    }

    public String getTietype() {
        return tietype;
    }

    public void setTietype(String tietype) {
        this.tietype = tietype == null ? null : tietype.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTiecontent() {
        return tiecontent;
    }

    public void setTiecontent(String tiecontent) {
        this.tiecontent = tiecontent == null ? null : tiecontent.trim();
    }

    @Override
    public String toString() {
        return "Tie{" +
                "tieid=" + tieid +
                ", tiename='" + tiename + '\'' +
                ", tietype='" + tietype + '\'' +
                ", publishtime=" + publishtime +
                ", author='" + author + '\'' +
                ", tiecontent='" + tiecontent + '\'' +
                '}';
    }
}