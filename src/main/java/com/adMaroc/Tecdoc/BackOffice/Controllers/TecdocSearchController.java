package com.adMaroc.Tecdoc.BackOffice.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchStructureTree;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
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
    public ResponseEntity<?> findByReferenceNumber(@RequestBody SearchDTO searchDTO){
        return ResponseEntity.ok(tecdocService.findByReferenceNumber(searchDTO.getReferenceNumber()));
    }
    @PostMapping("ean")
    public ResponseEntity<?> findByEan(@RequestBody SearchDTO searchDTO){
        return ResponseEntity.ok(tecdocService.findByEan(searchDTO.getEan()));
    }
}
