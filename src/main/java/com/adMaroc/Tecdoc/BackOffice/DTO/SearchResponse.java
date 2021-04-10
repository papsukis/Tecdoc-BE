package com.adMaroc.Tecdoc.BackOffice.DTO;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.ArticleCDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {

    String searchType;
    int pageNr;
    int nrPerPage;
    long totalResults;
    List<ArticleDTO> response=new ArrayList<>();

    public SearchResponse(ArticleTable article) {
    }
}
