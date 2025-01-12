package com.enviro.assessment.grad001.WanewaNetshodwe.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;


@Entity
public class RecyclingTip {

    @Id
    @NotEmpty
    private String id;
    @NotEmpty
    private String  tip;

    private String wasteCategory_Id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Override
    public String toString() {
        return "id : "+id +" "+ tip.toString() + " createed at :"+createdAt;
    }

    public String getWasteCategory_Id() {
        return wasteCategory_Id;
    }

    public void setWasteCategory_Id(String wasteCategory_Id) {
        this.wasteCategory_Id = wasteCategory_Id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
