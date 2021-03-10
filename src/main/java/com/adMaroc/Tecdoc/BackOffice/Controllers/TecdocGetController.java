package com.adMaroc.Tecdoc.BackOffice.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.SearchStructureTree;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TecdocSearchStructure;
import com.adMaroc.Tecdoc.BackOffice.Services.TecdocDataGetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(value="*")
@RequestMapping("/tecdoc")
public class TecdocGetController {

    @Autowired
    TecdocDataGetService tecdocService;

    @Cacheable("searchStructure")
    @GetMapping("searchStructure")
    public ResponseEntity<List<SearchStructureTree>> findAllSearchStructure(){

        return ResponseEntity.ok(tecdocService.getAllSearchStructures());
    }

    @Cacheable("manufacturers")
    @GetMapping("manufacturers")
    public ResponseEntity<List<ManufacturerDTO>> findAllManufacturers(){

        return ResponseEntity.ok(tecdocService.findAllManufacturers());
    }
    @Cacheable("genericArticles")
    @GetMapping("genericArticles")
    public ResponseEntity<List<GenericArticleDTO>> findAllGenericArticles(){

        return ResponseEntity.ok(tecdocService.findAllGenericArticle());
    }
    @GetMapping("criteria")
    public ResponseEntity<List<CriteriaDTO>> getAllCriteria(){
        return ResponseEntity.ok(tecdocService.findAllCriteria());
    }
    @GetMapping("vehicleModelSeries")
    public ResponseEntity<List<VehicleModelSerieDTO>> getAllVehicleModelSeries(){
        return ResponseEntity.ok(tecdocService.findAllVehicleModelSeries());
    }
    @GetMapping("vehicleTypes")
    public ResponseEntity<List<VehicleTypeDTO>> getAllVehicleTypes(){
        return ResponseEntity.ok(tecdocService.findAllVehicleTypes());
    }
}
