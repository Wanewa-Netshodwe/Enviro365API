package com.enviro.assessment.grad001.WanewaNetshodwe.Controllers;

import com.enviro.assessment.grad001.WanewaNetshodwe.DTOs.DisposalGuidelineData;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.DisposalGuidelines;
import com.enviro.assessment.grad001.WanewaNetshodwe.services.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("disposalGuidelines")
public class DisposalGuidelinesController {
    @Autowired
    private WasteCategoryService wcs;
    @PostMapping("/create")
    public ResponseEntity addRecycling(@Valid @RequestBody DisposalGuidelineData dgd) {
         wcs.addDisposalGuidelines(dgd);
        return  ResponseEntity.status(HttpStatus.CREATED).body("GuideLine Added");

    }
    @GetMapping("all")
    public ResponseEntity<List<DisposalGuidelines>> getCategories(){
        return ResponseEntity.status(HttpStatus.FOUND).body(wcs.getAllDisposalGuidelines());
    }
    @GetMapping("get/{waste_id}/{guideline_id}")
    public ResponseEntity<DisposalGuidelines> getCategory(@PathVariable String guideline_id,@PathVariable String waste_id){
        DisposalGuidelines Guideline = wcs.getDisposalGuidelines(waste_id,guideline_id);
        return  ResponseEntity.status(HttpStatus.OK).body(Guideline);

    }
    @DeleteMapping("del/{guide_id}/{id}")
    public ResponseEntity delCategory(@PathVariable String id,@PathVariable String guide_id){
        wcs.delGuideline(guide_id,id);
        return  ResponseEntity.status(HttpStatus.OK).body("Deleted");

    }
    @PutMapping("update")
    public ResponseEntity<DisposalGuidelines> updateGuideLine(@Valid @RequestBody DisposalGuidelineData disposalGuidelineData){
        DisposalGuidelines res = wcs.updateGuideline(disposalGuidelineData);
        return  ResponseEntity.status(HttpStatus.OK).body(res);

    }
}
