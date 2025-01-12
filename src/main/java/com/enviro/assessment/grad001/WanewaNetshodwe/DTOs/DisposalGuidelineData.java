package com.enviro.assessment.grad001.WanewaNetshodwe.DTOs;

import com.enviro.assessment.grad001.WanewaNetshodwe.Models.InstructionMap;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class DisposalGuidelineData {
    @NotEmpty
    private String wasteCategory_Id;

    @NotNull()
    @NotEmpty()
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Valid
    private List<InstructionMap> instructions;

    public String getWasteCategory_Id() {
        return wasteCategory_Id;
    }

    public void setWasteCategory_Id(String wasteCategory_Id) {
        this.wasteCategory_Id = wasteCategory_Id;
    }



    public List<InstructionMap> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<InstructionMap> instructions) {
        this.instructions = instructions;
    }
}
