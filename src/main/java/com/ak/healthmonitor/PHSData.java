package com.ak.healthmonitor;

import java.sql.Date;

public class PHSData
{
    private Integer patientId;
    private Integer id;
    private Integer appointment_id;
    private Integer patient_ID;
    private String name;
    private String gender;
    private Double bmi;
    private Double b_weight;
    private Double heart_rate;
    private Double blood_presure;
    private Double blood_gulcouse;
    private Date date;
    private Date dateModify;
    private Date dateDelete;
    private String status;
    private String doctorID;
    private String specialized;
    private Date schedule;

    public PHSData(Integer id, Integer appointment_id, Integer patient_ID, String name,
                         String gender, Double bmi, Double b_weight, Double blood_gulcouse, Double blood_presure,
                         String doctorID, String specialized ,
                         Date date , Date dateModify, Date dateDelete, String status, Date schedule)
    {
        this.id = id;
        this.appointment_id = appointment_id;
        this.patient_ID =patient_ID;
        this.name = name;
        this.gender =gender;
        this.bmi = bmi;
        this.b_weight = b_weight;
        this.blood_gulcouse = blood_gulcouse;
        this.blood_presure =blood_presure;
        this.doctorID = doctorID;
        this.specialized = specialized;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
        this.status = status;
        this.schedule = schedule;

    }

    public PHSData(int patient_ID, String name, String gender, double bmi, double b_weight,
                   double heart_rate, double blood_presure,
                   double blood_gulcouse, Date date, Date dateModify, Date dateDelete, String status, Date schedule)
    {
        this.patient_ID = patient_ID;
        this.name = name;
        this.gender = gender;
        this.bmi = bmi;
        this.b_weight =b_weight;
        this.blood_presure =blood_presure;
        this.heart_rate = heart_rate;
        this.blood_gulcouse = blood_gulcouse;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
        this.status = status;
        this.schedule = schedule;
    }


    public Integer getId(){
        return id;
    }

    public Integer getPatient_ID(){
        return patient_ID;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }

    public Double getBmi(){
        return bmi;
    }
    public Double getB_weight(){
        return b_weight;
    }
    public Double getHeart_rate(){
        return heart_rate;
    }
    public Double getBlood_presure(){
        return blood_presure;
    }
    public Double getBlood_gulcouse(){
        return blood_gulcouse;
    }
    public String getDoctorID() {
        return doctorID;
    }

    public String getSpecialized() {
        return specialized;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public Date getDateDelete() {
        return dateDelete;
    }

    public String getStatus() {
        return status;
    }

    public Date getSchedule() {
        return schedule;
    }

}
