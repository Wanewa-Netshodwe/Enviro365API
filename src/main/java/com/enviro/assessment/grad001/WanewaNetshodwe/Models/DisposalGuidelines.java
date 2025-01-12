package com.enviro.assessment.grad001.WanewaNetshodwe.Models;

import jakarta.persistence.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity

public class DisposalGuidelines {

    @Id
    @NotEmpty
    private String id;

    @NotNull
    @NotEmpty
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Valid
    private List<InstructionMap> instructions;



    public String getWasteCategory_Id() {
        return wasteCategory_Id;
    }

    public void setWasteCategory_Id(String wasteCategory_Id) {
        this.wasteCategory_Id = wasteCategory_Id;
    }


    private String wasteCategory_Id;
    @Override
    public String toString() {
        return "id : "+ id +"Created At :"+ createdAt +" "+ instructions.toString();
    }
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<InstructionMap> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<InstructionMap> instructions) {
        this.instructions = instructions;
    }
}
