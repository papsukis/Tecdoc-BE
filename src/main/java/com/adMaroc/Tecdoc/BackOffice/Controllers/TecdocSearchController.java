package com.adMaroc.Tecdoc.BackOffice.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchResponse;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchStructureTree;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.ArticleCDTO;
import com.adMaroc.Tecdoc.BackOffice.Services.TecdocDataGetService;
import com.adMaroc.Tecdoc.BackOffice.Services.TecdocDataSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@CrossOrigin(value="*")
@RequestMapping("/search")
public class TecdocSearchController {

    @Autowired
    TecdocDataSearchService tecdocService;

    @PostMapping("referenceNr")
    public ResponseEntity<SearchResponse> findByReferenceNumber(@RequestBody SearchDTO searchDTO){
        log.info(searchDTO.toString());
        return ResponseEntity.ok(tecdocService.findByReferenceNumber(searchDTO));
    }
    @PostMapping("ean")
    public ResponseEntity<?> findByEan(@RequestBody SearchDTO searchDTO){
        return ResponseEntity.ok(tecdocService.findByEan(searchDTO.getEan()));
    }
    @PostMapping("findArticleByVehicleType")
    public ResponseEntity<SearchResponse> findArticleByVehicleType(@RequestBody SearchDTO searchDTO){
        return ResponseEntity.ok(tecdocService.findArticleByVehicleType(searchDTO));
    }
    @PostMapping("findArticleByCVType")
    public ResponseEntity<SearchResponse> findArticleByCVType(@RequestBody SearchDTO searchDTO){
        return ResponseEntity.ok(tecdocService.findArticleByCVType(searchDTO));
    }
    @PostMapping("findArticleByGenArt")
    public ResponseEntity<SearchResponse> findArticleByGenArt(@RequestBody SearchDTO searchDTO){
        return ResponseEntity.ok(tecdocService.findArticleByCVType(searchDTO));
    }
}
