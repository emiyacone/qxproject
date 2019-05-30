package com.example.demo.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menutree {
    private Integer id;

    private String pId; //父节点id

    private String text;

    private String state;

    private String url;

    private Boolean checked;

    private Map<String, Object> attributes = new HashMap<String, Object>(); // 添加到节点的自定义属性

    private String iconCls;

    private List<Menutree> children; //子节点数据

//    public String getChecked() {
//        return checked;
//    }
//
//    public void setChecked(String checked) {
//        this.checked = checked;
//    }


    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menutree> getChildren() {
        return children;
    }

    public void setChildren(List<Menutree> children) {
        this.children = children;
    }


    @Override
    public String toString() {
        return "Menutree{" +
                "id=" + id +
                ", pId='" + pId + '\'' +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", url='" + url + '\'' +
                ", attributes=" + attributes +
                ", children=" + children +
                '}';
    }
}
