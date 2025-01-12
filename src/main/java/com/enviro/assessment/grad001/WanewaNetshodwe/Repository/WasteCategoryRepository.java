package com.enviro.assessment.grad001.WanewaNetshodwe.Repository;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface WasteCategoryRepository extends JpaRepository<WasteCategory, String> {
}
