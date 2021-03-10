package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CriteriaTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriteriaDTO {
    long kritNr;
    String description;
    String type;
    long maxLength;
    boolean article;
    KeyTableDTO keyTable;
    boolean personalCarCriterion;
    boolean commercialVehicleCriterion;
    boolean engineCriterion;
    boolean driverCabCriterion;
    boolean partsListCriterion;
    boolean accessoryListCriterion;
    boolean axleCriterion;
    boolean linkage;
    @JsonIgnore
    long abreviationId;
    String abreviation;
    @JsonIgnore
    long unitId;
    String unit;
    boolean interval;
    CriteriaDTO parentCriterion;
    List<CriteriaDTO> criterionChildren;

    public CriteriaDTO(CriteriaTable criteriaTable) {
        kritNr=criteriaTable.getId().getKritNr();
        description=criteriaTable.getLanguageDescriptions().getBez();
        type=criteriaTable.getTyp();
        maxLength=criteriaTable.getMaxLen();
        article=criteriaTable.getOkArtikel()==1;
        keyTable=criteriaTable.getTyp().contains("K")?new KeyTableDTO(criteriaTable.getTabNr()):null;
        personalCarCriterion=criteriaTable.getoKPKW()==1;
        commercialVehicleCriterion=criteriaTable.getoKNKW()==1;
        engineCriterion=criteriaTable.getoKMotor()==1;
        driverCabCriterion=criteriaTable.getoKFahrerhaus()==1;
        partsListCriterion=criteriaTable.getStucklistenCriterion()==1;
        accessoryListCriterion=criteriaTable.getZubehorCriterion()==1;
        axleCriterion=criteriaTable.getoKAchse()==1;
        linkage=criteriaTable.getMehrfachVerwendung()==1;
        abreviationId=criteriaTable.getBezNrAbk();
        abreviation="";
        unitId=criteriaTable.getBezNrEinheit();
        unit="";
        interval=criteriaTable.getIntervallCriterion()==1;
        parentCriterion=criteriaTable.getNachfolgeCriterion()!=0?new CriteriaDTO():null;
        if(parentCriterion!=null)
            parentCriterion.setKritNr(criteriaTable.getNachfolgeCriterion());
        criterionChildren=new ArrayList<>();
    }
}
