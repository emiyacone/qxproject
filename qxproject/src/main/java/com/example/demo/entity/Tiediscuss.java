package com.example.demo.entity;

import java.util.Date;

public class Tiediscuss {
    private Integer discussId;

    private Integer tieid;

    private String discussContent;

    private String discussAuthor;

    private Date discussTime;

    public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }

    public Integer getTieid() {
        return tieid;
    }

    public void setTieid(Integer tieid) {
        this.tieid = tieid;
    }

    public String getDiscussContent() {
        return discussContent;
    }

    public void setDiscussContent(String discussContent) {
        this.discussContent = discussContent == null ? null : discussContent.trim();
    }

    public String getDiscussAuthor() {
        return discussAuthor;
    }

    public void setDiscussAuthor(String discussAuthor) {
        this.discussAuthor = discussAuthor == null ? null : discussAuthor.trim();
    }

    public Date getDiscussTime() {
        return discussTime;
    }

    public void setDiscussTime(Date discussTime) {
        this.discussTime = discussTime;
    }
}