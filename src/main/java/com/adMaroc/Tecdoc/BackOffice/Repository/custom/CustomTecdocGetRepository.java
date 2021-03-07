package com.adMaroc.Tecdoc.BackOffice.Repository.custom;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.KeyTableDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.SearchStructureDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomTecdocGetRepository {
    List<SearchStructureDTO> getAllSearchStructure();

    KeyTableDTO getKeyTableValue(long tabNr, String key);

    List<KeyTableDTO> getKeyTables(long tabNr);
}
