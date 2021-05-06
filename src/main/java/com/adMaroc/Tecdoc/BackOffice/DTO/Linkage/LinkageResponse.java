package com.adMaroc.Tecdoc.BackOffice.DTO.Linkage;

import com.adMaroc.Tecdoc.BackOffice.DTO.Linkage.LinkedManufacturer;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.KeyTableDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkageResponse {
    KeyTableDTO linkageType;
    List<LinkedManufacturer> linked=new ArrayList<>();
}
