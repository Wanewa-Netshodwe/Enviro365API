package com.enviro.assessment.grad001.WanewaNetshodwe.DTOs;

import com.enviro.assessment.grad001.WanewaNetshodwe.Models.InstructionMap;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.RecyclingTip;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclingTipsData {
    @NotEmpty
    private String wasteCategory_Id;

    @NotEmpty
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Valid
    private List<RecyclingTip> recyclingTips = new ArrayList<>();

    public String getWasteCategory_Id() {
        return wasteCategory_Id;
    }

    public void setWasteCategory_Id(String wasteCategory_Id) {
        this.wasteCategory_Id = wasteCategory_Id;
    }

    public List<RecyclingTip> getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(List<RecyclingTip> recyclingTips) {
        this.recyclingTips = recyclingTips;
    }
}


