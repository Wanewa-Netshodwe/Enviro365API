package com.enviro.assessment.grad001.WanewaNetshodwe.services;


import com.enviro.assessment.grad001.WanewaNetshodwe.DTOs.DisposalGuidelineData;
import com.enviro.assessment.grad001.WanewaNetshodwe.DTOs.RecyclingTipsData;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.DisposalGuidelines;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.RecyclingTip;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.WasteCategory;
import com.enviro.assessment.grad001.WanewaNetshodwe.Repository.CustomQueries;
import com.enviro.assessment.grad001.WanewaNetshodwe.Repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wcr;

    @Autowired
    private CustomQueries cq;


@Transactional
    public WasteCategory SaveCategory(WasteCategory category) {
        Logger log = Logger.getGlobal();

        try {

            category.getDisposalGuidelines().setCreatedAt(new Date());
            category.getDisposalGuidelines().setWasteCategory_Id(category.getId());
            category.setCreatedAt(new Date());
            category.setRecyclingTips(
                    category.getRecyclingTips().stream()
                            .map(recyclingTip -> {
                                recyclingTip.setCreatedAt(new Date());
                                recyclingTip.setWasteCategory_Id(category.getId());
                                return recyclingTip;
                            })
                            .collect(Collectors.toList())
            );


            WasteCategory savedCategory = wcr.save(category);
            log.info("Saved category with name: " + savedCategory.getName());
            log.info("Saved category with id: " + savedCategory.getId());
            log.info("Saved category : " + savedCategory.toString());

            return savedCategory;

        }
        catch (Exception e) {
            log.severe("Unexpected error: " + e.getMessage());
            return null;
        }
    }
    @Transactional
    public List<WasteCategory> getCategories(){
    List<WasteCategory> categories = wcr.findAll();
    return categories;
}
    @Transactional
    public WasteCategory GetCategory(String id){
    Optional<WasteCategory> category = wcr.findById(id);
    return  category.get();
    }
    @Transactional
    public void delCategory(String id){
        wcr.deleteById(id);
    }

    public WasteCategory updateCategory(WasteCategory category){
        WasteCategory result = cq.updateCategory(category);
        return  result;
    }
    public void addDisposalGuidelines(DisposalGuidelineData disposalGuideline){
        cq.addGuidelines(disposalGuideline);
    }
    public List<DisposalGuidelines> getAllDisposalGuidelines(){
      return cq.getAllGuideLines(getCategories());
    }
    public DisposalGuidelines getDisposalGuidelines( String waste_id,String guideline_id){
        return cq.getGuideline(waste_id,guideline_id);
    }
    public  void delGuideline(String guide_id,String id){
    cq.delGuideline(guide_id,id);
    }
    public DisposalGuidelines updateGuideline(DisposalGuidelineData disposalGuidelineData){
        DisposalGuidelines dg = cq.updateDisposalGuideline(disposalGuidelineData.getWasteCategory_Id(),disposalGuidelineData.getInstructions());
        return dg;

    }
    public void addRecyclingTip(RecyclingTipsData recyclingTipsData){
        cq.addRecyclingTip(recyclingTipsData);
    }
    public List<RecyclingTip> getAllRecyclingTips(){
        return cq.getAllRecyclingTips(getCategories());
    }
    public RecyclingTip getRecyclingTip( String recyclingTip_id){
        return cq.getRecyclingTip(recyclingTip_id);
    }
    public  void delRecyclingTip(String waste_id,String id){
        cq.delRecyclingTip(waste_id,id);
    }
    public void updateRecyclingTip(RecyclingTipsData recyclingTipsData){
         cq.updateRecyclingTips(recyclingTipsData.getWasteCategory_Id(),recyclingTipsData.getRecyclingTips());


    }
}
