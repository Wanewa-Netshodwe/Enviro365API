package com.enviro.assessment.grad001.WanewaNetshodwe.Controllers;

import com.enviro.assessment.grad001.WanewaNetshodwe.DTOs.DisposalGuidelineData;
import com.enviro.assessment.grad001.WanewaNetshodwe.DTOs.RecyclingTipsData;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.DisposalGuidelines;
import com.enviro.assessment.grad001.WanewaNetshodwe.Models.RecyclingTip;
import com.enviro.assessment.grad001.WanewaNetshodwe.services.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recyclingTips")
public class RecyclingTipsController {
    @Autowired
    private WasteCategoryService wcs;
    @PostMapping("/create")
    public ResponseEntity addRecyclingTip(@Valid @RequestBody RecyclingTipsData rtd) {
         wcs.addRecyclingTip(rtd);
        return  ResponseEntity.status(HttpStatus.CREATED).body("RecyclingTip Added");

    }
    @GetMapping("all")
    public ResponseEntity<List<RecyclingTip>> getRecyclingTips(){
        return ResponseEntity.status(HttpStatus.FOUND).body(wcs.getAllRecyclingTips());
    }
    @GetMapping("get/{tip_id}")
    public ResponseEntity<RecyclingTip> getRecyclingTip(@PathVariable String tip_id){
        RecyclingTip tip = wcs.getRecyclingTip(tip_id);
        return  ResponseEntity.status(HttpStatus.OK).body(tip);

    }
    @DeleteMapping("del/{waste_id}/{id}")
    public ResponseEntity delCategory(@PathVariable String id,@PathVariable String waste_id){
        wcs.delRecyclingTip(waste_id,id);
        return  ResponseEntity.status(HttpStatus.OK).body("Deleted");

    }
    @PutMapping("update")
    public ResponseEntity updateRecyclingTip(@Valid @RequestBody RecyclingTipsData recyclingTipsData){
        wcs.updateRecyclingTip(recyclingTipsData);
        return  ResponseEntity.status(HttpStatus.OK).body("updated");

    }
}
