package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfCVToCVIDNumbersId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_538_allocation_of_cv_to_id_numbers")
public class AllocationOfCVToCVIDNumbers {


    @EmbeddedId
    AllocationOfCVToCVIDNumbersId id;
    long dLNr;
    long sA;


    @MapsId("nTypNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ntypnr",
                referencedColumnName = "ntypnr")
    private CVTypes cvTypes;
    @MapsId("herlDNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "herldnr",
                referencedColumnName = "herldnr")
    private CVProducerIDs cvProducerIDs;

    public AllocationOfCVToCVIDNumbers(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
    }

    public AllocationOfCVToCVIDNumbersId getId() {
        return id;
    }

    public void setId(AllocationOfCVToCVIDNumbersId id) {
        this.id = id;
    }

    public long getdLNr() {
        return dLNr;
    }

    public void setdLNr(long dLNr) {
        this.dLNr = dLNr;
    }

    public long getsA() {
        return sA;
    }

    public void setsA(long sA) {
        this.sA = sA;
    }

    public CVTypes getCvTypes() {
        return cvTypes;
    }

    public void setCvTypes(CVTypes cvTypes) {
        this.cvTypes = cvTypes;
    }

    public CVProducerIDs getCvProducerIDs() {
        return cvProducerIDs;
    }

    public void setCvProducerIDs(CVProducerIDs cvProducerIDs) {
        this.cvProducerIDs = cvProducerIDs;
    }

}
