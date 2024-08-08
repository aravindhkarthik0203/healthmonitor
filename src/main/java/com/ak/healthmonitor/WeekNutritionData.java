package com.ak.healthmonitor;

import java.sql.Date;

public class WeekNutritionData
{
    private Integer id;
    private String day;
    private Double bmi;
    private Double b_weight;
    private Double heart_rate;
    private Double blood_presure;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String snack1;
    private String snack2;
    private String notes;


    public WeekNutritionData(Integer id, String day, Double bmi, Double b_weight, Double heart_rate
            ,Double blood_presure, String breakfast, String lunch, String dinner
            , String snack1, String snack2, String notes)
    {
        this.id = id;
        this.day = day;
        this.bmi = bmi;
        this.b_weight = b_weight;
        this.heart_rate = heart_rate;
        this.blood_presure = blood_presure;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.snack1 = snack1;
        this.snack2 = snack2;
        this.notes = notes;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getB_weight() {
        return b_weight;
    }

    public void setB_weight(Double b_weight) {
        this.b_weight = b_weight;
    }

    public Double getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(Double heart_rate) {
        this.heart_rate = heart_rate;
    }

    public Double getBlood_presure() {
        return blood_presure;
    }

    public void setBlood_presure(Double blood_presure) {
        this.blood_presure = blood_presure;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getSnack1() {
        return snack1;
    }

    public void setSnack1(String snack1) {
        this.snack1 = snack1;
    }

    public String getSnack2() {
        return snack2;
    }

    public void setSnack2(String snack2) {
        this.snack2 = snack2;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
