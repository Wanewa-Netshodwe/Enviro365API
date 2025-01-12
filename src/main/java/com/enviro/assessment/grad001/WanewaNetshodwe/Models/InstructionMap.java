package com.enviro.assessment.grad001.WanewaNetshodwe.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Map;

@Entity
public class InstructionMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @ElementCollection
    @CollectionTable(name = "instruction_detail")
    @MapKeyColumn(name = "step")
    private Map<Integer, String> instruction;



    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return instruction.toString();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Integer, String> getInstruction() {
        return instruction;
    }

    public void setInstruction(Map<Integer, String> entries) {
        this.instruction = entries;
    }
}
