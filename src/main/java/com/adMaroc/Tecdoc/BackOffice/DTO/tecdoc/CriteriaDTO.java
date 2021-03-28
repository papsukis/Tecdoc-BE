package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CriteriaTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryProjection;
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
    DescriptionDTO description;
    String value;
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
    DescriptionDTO abreviation;
    DescriptionDTO unit;
    boolean interval;
    boolean immediateDisplay;
    CriteriaDTO parentCriterion;
    List<CriteriaDTO> criterionChildren;
    @QueryProjection
    public CriteriaDTO(CriteriaTable criteriaTable,String value) {
        kritNr=criteriaTable.getId().getKritNr();
        description=new DescriptionDTO(criteriaTable.getLanguageDescriptions());
        this.value=value;
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
        abreviation=new DescriptionDTO(String.valueOf(criteriaTable.getBezNrAbk()));
        unit=new DescriptionDTO(String.valueOf(criteriaTable.getBezNrEinheit()));
        interval=criteriaTable.getIntervallCriterion()==1;
        parentCriterion=criteriaTable.getNachfolgeCriterion()!=0?new CriteriaDTO():null;
        if(parentCriterion!=null)
            parentCriterion.setKritNr(criteriaTable.getNachfolgeCriterion());
        criterionChildren=new ArrayList<>();
    }

    public CriteriaDTO(CriteriaTable criteriaTable) {
        kritNr=criteriaTable.getId().getKritNr();
        description=new DescriptionDTO(criteriaTable.getLanguageDescriptions());
        value="";
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
        abreviation=new DescriptionDTO(String.valueOf(criteriaTable.getBezNrAbk()));
        unit=new DescriptionDTO(String.valueOf(criteriaTable.getBezNrEinheit()));
        interval=criteriaTable.getIntervallCriterion()==1;
        parentCriterion=criteriaTable.getNachfolgeCriterion()!=0?new CriteriaDTO():null;
        if(parentCriterion!=null)
            parentCriterion.setKritNr(criteriaTable.getNachfolgeCriterion());
        criterionChildren=new ArrayList<>();
    }
}
