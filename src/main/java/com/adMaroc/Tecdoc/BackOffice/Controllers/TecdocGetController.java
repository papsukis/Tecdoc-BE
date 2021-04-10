package com.adMaroc.Tecdoc.BackOffice.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.ManufacturerList;
import com.adMaroc.Tecdoc.BackOffice.DTO.ManufacturerToSaveXlsx;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchStructureTree;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.ArticleCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.CVTypesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleModelSeriesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleTypeCDTO;
import com.adMaroc.Tecdoc.BackOffice.Services.ExcelConverter;
import com.adMaroc.Tecdoc.BackOffice.Services.TecdocDataGetService;
import com.adMaroc.Tecdoc.BackOffice.Services.WrapperTecdocDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@CrossOrigin(value="*")
@RequestMapping("/tecdoc")
public class TecdocGetController {

    @Autowired
    TecdocDataGetService tecdocService;
    @Autowired
    WrapperTecdocDataService tecdocDataService;
    @Autowired
    ExcelConverter excelConverter;
    @Cacheable("searchStructure")
    @GetMapping("searchStructure")
    public ResponseEntity<List<SearchStructureTree>> findAllSearchStructure(){

        return ResponseEntity.ok(tecdocService.getAllSearchStructures());
    }
    @Cacheable("manufacturers")
    @GetMapping("manufacturers")
    public ResponseEntity<List<ManufacturerList>> findAllManufacturers(){

        return ResponseEntity.ok(tecdocService.findAllManufacturers());
    }
    @GetMapping("savedManufacturers")
    public ResponseEntity<List<ManufacturerDTO>> findAllSavedManufacturers(){

        return ResponseEntity.ok(tecdocService.findAllSavedManufacturers());
    }

    @Cacheable("genericArticles")
    @GetMapping("genericArticles")
    public ResponseEntity<List<GenericArticleDTO>> findAllGenericArticles(){

        return ResponseEntity.ok(tecdocService.findAllGenericArticle());
    }

    @PostMapping("vehicleModelSeries")
    public ResponseEntity<List<VehicleModelSeriesCDTO>>getAllVehicleModelSeries(@RequestBody SearchDTO search){

        return ResponseEntity.ok(tecdocService.findVehicleModelSerieByHernr(search));
    }
    @PostMapping("getVehicleModelSerie")
    public ResponseEntity<VehicleModelSeriesCDTO> getVehicleModelSerie(@RequestBody SearchDTO search){

        return ResponseEntity.ok(tecdocService.findVehicleModelSerie(search));
    }
    @PostMapping("getVehicleType")
    public ResponseEntity<VehicleTypeCDTO> getVehicleType(@RequestBody SearchDTO search){

        return ResponseEntity.ok(tecdocService.findVehicleType(search));
    }
    @PostMapping("getCVType")
    public ResponseEntity<CVTypesCDTO> getCVType(@RequestBody SearchDTO search){

        return ResponseEntity.ok(tecdocService.findCVType(search));
    }
//    @PostMapping("vehicleTypes")
//    public ResponseEntity<List<VehicleTypeDTO>> getAllVehicleTypes(@RequestBody SearchDTO search){
//        return ResponseEntity.ok(tecdocService.findVehicleTypesByKmodNr(search));
//    }
//    @GetMapping("engines")
//    public ResponseEntity<List<EngineDTO>> getAllEngines(){
//        return ResponseEntity.ok(tecdocDataService.enginesRepository.findAll().stream().map(EngineDTO::new).collect(Collectors.toList()).subList(0,50));
//    }
    @PostMapping("test")
    public ResponseEntity<?> test(@RequestBody SearchDTO searchDTO){
        return ResponseEntity.ok(tecdocService.test(searchDTO));
    }
    @PostMapping("getArticle")
    public ResponseEntity<ArticleCDTO> getArticle(@RequestBody SearchDTO search){
        return ResponseEntity.ok(tecdocService.getArticle(search));
    }
    @PostMapping("saveArticlesToxlsx")
    public ResponseEntity<?> save(@RequestBody ManufacturerToSaveXlsx req){
        List<ArticleImageDTO> list=tecdocService.findAllArticles(req.getDlnr());
        log.info("articles loaded");
        excelConverter.contactListToExcelFile(list);
        return ResponseEntity.ok(list);
    }
}
