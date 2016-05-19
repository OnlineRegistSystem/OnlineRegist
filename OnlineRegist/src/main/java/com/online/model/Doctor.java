package com.online.model;

public class Doctor {
    private Integer id;

    private Integer diseaseId;

    private String name;

    private String doctorDesc;

    private Integer doctorClass;

    private String doctorImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDoctorDesc() {
        return doctorDesc;
    }

    public void setDoctorDesc(String doctorDesc) {
        this.doctorDesc = doctorDesc == null ? null : doctorDesc.trim();
    }

    public Integer getDoctorClass() {
        return doctorClass;
    }

    public void setDoctorClass(Integer doctorClass) {
        this.doctorClass = doctorClass;
    }

    public String getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(String doctorImage) {
        this.doctorImage = doctorImage == null ? null : doctorImage.trim();
    }
}