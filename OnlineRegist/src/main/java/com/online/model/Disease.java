package com.online.model;

public class Disease {
    private Integer id;

    private Integer departmenId;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmenId() {
        return departmenId;
    }

    public void setDepartmenId(Integer departmenId) {
        this.departmenId = departmenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}