package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfCriteriaValuesToGAMandatoryCriteriaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="allocation_of_criteria_values_to_ga_mandatory_criteria_330")
public class AllocationOfCriteriaValuesToGAMandatoryCriteria {

    @EmbeddedId
    AllocationOfCriteriaValuesToGAMandatoryCriteriaId id;
    long dLNr;
    long sA;
    long sortNr;

    @MapsId("genArtNr")
    @ManyToOne
    @JoinColumn(name = "genArtNr",
                referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "allocationOfCriteriaValuesToGAMandatoryCriteria")
    private List<MandatoryCriteria> mandatoryCriteria;

    public AllocationOfCriteriaValuesToGAMandatoryCriteria(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.sortNr = sortNr;
    }

    public AllocationOfCriteriaValuesToGAMandatoryCriteriaId getId() {
        return id;
    }

    public void setId(AllocationOfCriteriaValuesToGAMandatoryCriteriaId id) {
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

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public GenericArticles getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(GenericArticles genericArticles) {
        this.genericArticles = genericArticles;
    }

    public List<MandatoryCriteria> getMandatoryCriteria() {
        return mandatoryCriteria;
    }

    public void setMandatoryCriteria(List<MandatoryCriteria> mandatoryCriteria) {
        this.mandatoryCriteria = mandatoryCriteria;
    }
}
