package com.adMaroc.Tecdoc.BackOffice.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.SearchStructureTree;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.SearchStructureDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TecdocSearchStructure;
import com.adMaroc.Tecdoc.BackOffice.Services.TecdocDataGetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(value="*")
@RequestMapping("/tecdoc")
public class TecdocGetController {

    @Autowired
    TecdocDataGetService tecdocService;

    @GetMapping("searchStructure")
    public ResponseEntity<List<SearchStructureTree>> getAll(){

        return ResponseEntity.ok(tecdocService.getAllSearchStructures());
    }
}
