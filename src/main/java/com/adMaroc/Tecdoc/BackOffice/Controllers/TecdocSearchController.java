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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
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
    @PostMapping("OEReferenceNr")
    public ResponseEntity<?> findByEan(@RequestBody SearchDTO searchDTO){
        return ResponseEntity.ok(tecdocService.findByOEReferenceNumber(searchDTO));
    }
    @PostMapping("findArticleByVehicleType")
    public ResponseEntity<SearchResponse> findArticleByVehicleType(@RequestBody SearchDTO searchDTO){
        log.info(searchDTO.toString());
        return ResponseEntity.ok(tecdocService.findArticleByVehicleType(searchDTO));
    }
    @PostMapping("findArticleByCVType")
    public ResponseEntity<SearchResponse> findArticleByCVType(@RequestBody SearchDTO searchDTO){
        log.info(searchDTO.toString());
        return ResponseEntity.ok(tecdocService.findArticleByCVType(searchDTO));
    }
    @PostMapping("findArticleByGenArt")
    public ResponseEntity<SearchResponse> findArticleByGenArt(@RequestBody SearchDTO searchDTO){
        log.info(searchDTO.toString());
        return ResponseEntity.ok(tecdocService.findArticleByGenArt(searchDTO));
    }
    @PostMapping("convertToxlxs")
    public ResponseEntity<?> convertToxlxs(@RequestBody SearchDTO searchDTO, HttpServletResponse response) throws ParseException {
//        ByteArrayResource resource = tecdocService.convertToExcel(searchDTO);
//        new InputStreamResource(in)
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "articles.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(new InputStreamResource(tecdocService.convertToExcel(searchDTO)));
    }
}
