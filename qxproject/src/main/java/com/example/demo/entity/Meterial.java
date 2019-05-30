package com.example.demo.entity;

import java.util.Date;

public class Meterial {
    private Integer meterialid;

    private String meterialitype;

    private String meterialname;

    private String meterdesc;

    private String meterialsize;

    private String author;

    private Date datetime;

    private String meterialurl;

    public Integer getMeterialid() {
        return meterialid;
    }

    public void setMeterialid(Integer meterialid) {
        this.meterialid = meterialid;
    }

    public String getMeterialitype() {
        return meterialitype;
    }

    public void setMeterialitype(String meterialitype) {
        this.meterialitype = meterialitype == null ? null : meterialitype.trim();
    }

    public String getMeterialname() {
        return meterialname;
    }

    public void setMeterialname(String meterialname) {
        this.meterialname = meterialname == null ? null : meterialname.trim();
    }

    public String getMeterdesc() {
        return meterdesc;
    }

    public void setMeterdesc(String meterdesc) {
        this.meterdesc = meterdesc == null ? null : meterdesc.trim();
    }

    public String getMeterialsize() {
        return meterialsize;
    }

    public void setMeterialsize(String meterialsize) {
        this.meterialsize = meterialsize;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getMeterialurl() {
        return meterialurl;
    }

    public void setMeterialurl(String meterialurl) {
        this.meterialurl = meterialurl == null ? null : meterialurl.trim();
    }
}