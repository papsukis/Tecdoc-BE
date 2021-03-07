package com.adMaroc.Tecdoc.BackOffice.DTO;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.KeyTableDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.SearchStructureDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchStructureTree {

    List<SearchStructureDTO> tree;
    KeyTableDTO productSection;

    public SearchStructureTree(KeyTableDTO keytable) {
        productSection=keytable;
        tree=new ArrayList<>();
    }
}
