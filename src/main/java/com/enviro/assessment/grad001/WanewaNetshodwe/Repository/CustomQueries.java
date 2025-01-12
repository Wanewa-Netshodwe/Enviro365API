package com.enviro.assessment.grad001.WanewaNetshodwe.Repository;

import com.enviro.assessment.grad001.WanewaNetshodwe.DTOs.DisposalGuidelineData;
import com.enviro.assessment.grad001.WanewaNetshodwe.DTOs.RecyclingTipsData;
import com.enviro.assessment.grad001.WanewaNetshodwe.Execptions.NoCategoryException;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.DisposalGuidelines;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.InstructionMap;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.RecyclingTip;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.WasteCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomQueries {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public WasteCategory updateCategory(WasteCategory category) {
        WasteCategory existingCategory = em.find(WasteCategory.class, category.getId());
        if (existingCategory == null) {
            throw new IllegalArgumentException("WasteCategory with ID " + category.getId() + " not found");
        }
        existingCategory.setName(category.getName());
        existingCategory.setCreatedAt(category.getCreatedAt());
        existingCategory.setDisposalGuidelines(category.getDisposalGuidelines());
        existingCategory.setRecyclingTips(category.getRecyclingTips());
        em.merge(existingCategory);
        em.flush();
        return existingCategory;
    }
    @Transactional
    public void addGuidelines(DisposalGuidelineData disposalGuideline) {
        String cat_id = disposalGuideline.getWasteCategory_Id();
        WasteCategory existingCategory = em.find(WasteCategory.class, cat_id);
        if (existingCategory == null) {
            throw new NoCategoryException("Invalid Category Id");
        }

        List<InstructionMap> list = existingCategory.getDisposalGuidelines().getInstructions();
        disposalGuideline.getInstructions().forEach((instruction)->{
            list.add(instruction);
        });
        existingCategory.getDisposalGuidelines().setInstructions(list);
        em.merge(existingCategory);
        em.flush();


    }

    public List<DisposalGuidelines> getAllGuideLines(List<WasteCategory> categories) {
        List<DisposalGuidelines> guidelines = new ArrayList<>();
        categories.forEach((category)->{
        guidelines.add(category.getDisposalGuidelines());
            });
        return guidelines;

    }
    @Transactional
    public  DisposalGuidelines getGuideline(String waste_id,String guideline_id){
        DisposalGuidelines Guideline = em.find(DisposalGuidelines.class, guideline_id);
        if (Guideline == null) {
            throw new NoCategoryException("Invalid GuideLine Id");
        }
        return  Guideline;
    }
    @Transactional
    public  void delGuideline(String guide_id,String id ){
        DisposalGuidelines guidelines = em.find(DisposalGuidelines.class, guide_id);
        InstructionMap instruction = em.find(InstructionMap.class, id);
        guidelines.getInstructions().remove(instruction);
        em.flush();
//        Query query = em.createQuery(
//                "DELETE FROM DisposalGuidelines dg " +
//                        "WHERE dg.id = :id AND :instruction MEMBER OF dg.instructions"
//                ,DisposalGuidelines.class);
//        query.setParameter("instruction",instruction);
//        query.setParameter("id",guidelines.getId());
//        query.executeUpdate();


    }
    @Transactional
    public DisposalGuidelines updateDisposalGuideline(String id,List<InstructionMap> instructions) {
        WasteCategory existingCategory = em.find(WasteCategory.class,id);
        if (existingCategory == null) {
            throw new IllegalArgumentException("DisposalGuidelines with ID " + id + " not found");
        }
        DisposalGuidelines dg = existingCategory.getDisposalGuidelines();
        dg.setInstructions(instructions);
        existingCategory.setDisposalGuidelines(dg);
        em.merge(existingCategory);
        em.flush();
        return dg;
    }


    @Transactional
    public void addRecyclingTip(RecyclingTipsData recyclingTips) {
        String cat_id = recyclingTips.getWasteCategory_Id();
        WasteCategory existingCategory = em.find(WasteCategory.class, cat_id);
        if (existingCategory == null) {
            throw new NoCategoryException("Invalid Category Id");
        }

        List<RecyclingTip> list = existingCategory.getRecyclingTips();
        recyclingTips.getRecyclingTips().forEach((tip)->{
            tip.setWasteCategory_Id(cat_id);
            tip.setCreatedAt(new Date());
            list.add(tip);
        });
        existingCategory.setRecyclingTips(list);
        em.merge(existingCategory);
        em.flush();
    }

    public List<RecyclingTip> getAllRecyclingTips(List<WasteCategory> categories) {
        List<RecyclingTip> recyclingTips = new ArrayList<>();
        categories.forEach((category)->{
            category.getRecyclingTips().forEach((tip)->{
                recyclingTips.add(tip);
            });

        });
        return recyclingTips;

    }
    @Transactional
    public  RecyclingTip getRecyclingTip(String tip_id){
        RecyclingTip tip = em.find(RecyclingTip.class, tip_id);
        if (tip == null) {
            throw new NoCategoryException("Invalid RecycleTip  Id");
        }
        return  tip;
    }
    @Transactional
    public  void delRecyclingTip(String waste_id,String id ){
        WasteCategory wasteCat = em.find(WasteCategory.class, waste_id);
        RecyclingTip tip = em.find(RecyclingTip.class, id);
        wasteCat.getRecyclingTips().remove(tip);
        em.flush();

    }
    @Transactional
    public void updateRecyclingTips(String id,List<RecyclingTip> tips) {
        tips = tips.stream().map((tip)->{
            tip.setCreatedAt(new Date());
            tip.setWasteCategory_Id(id);
            return tip;
        }).collect(Collectors.toList());
        WasteCategory existingCategory = em.find(WasteCategory.class,id);
        if (existingCategory == null) {
            throw new IllegalArgumentException("DisposalGuidelines with ID " + id + " not found");
        }
        existingCategory.setRecyclingTips(tips);
        em.merge(existingCategory);
        em.flush();

    }

}