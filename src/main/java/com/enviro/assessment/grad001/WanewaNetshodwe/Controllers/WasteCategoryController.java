package com.enviro.assessment.grad001.WanewaNetshodwe.Controllers;

import com.enviro.assessment.grad001.WanewaNetshodwe.Models.WasteCategory;
import com.enviro.assessment.grad001.WanewaNetshodwe.services.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wasteCategory")
public class WasteCategoryController {
    @Autowired
    private WasteCategoryService wcs;

    @PostMapping ("create")
    public ResponseEntity<WasteCategory> addCategory(@Valid @RequestBody WasteCategory wcd) {
        WasteCategory saved = wcs.SaveCategory(wcd);
        return  ResponseEntity.status(HttpStatus.CREATED).body(saved);

}
@GetMapping("all")
public ResponseEntity<List<WasteCategory>> getCategories(){
    List<WasteCategory> categories = wcs.getCategories();
    return ResponseEntity.status(HttpStatus.FOUND).body(categories);
}
@GetMapping("get/{id}")
public ResponseEntity<WasteCategory> getCategory(@PathVariable String id){
    WasteCategory category = wcs.GetCategory(id);
    return  ResponseEntity.status(HttpStatus.OK).body(category);

}

    @DeleteMapping("del/{id}")
    public ResponseEntity delCategory(@PathVariable String id){
        wcs.delCategory(id);
        return  ResponseEntity.status(HttpStatus.OK).body("Deleted");

    }
    @PutMapping("update")
    public ResponseEntity<WasteCategory> updateCategory(@Valid @RequestBody WasteCategory category){
        WasteCategory res = wcs.updateCategory(category);
        return  ResponseEntity.status(HttpStatus.OK).body(res);

    }

}
