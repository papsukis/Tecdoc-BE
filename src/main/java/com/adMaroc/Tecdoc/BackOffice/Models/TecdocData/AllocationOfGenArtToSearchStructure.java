package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfGenArtToSearchStructureId;
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
@Table(name="allocation_of_genart_to_search_structure_302")
public class AllocationOfGenArtToSearchStructure {

    @EmbeddedId
    AllocationOfGenArtToSearchStructureId id;
    long dLNr;
    long sA;
    long sortNr;
    long loschFlag;

    @MapsId("nodeId")
    @ManyToOne
    @JoinColumn(name = "nodeId",
                referencedColumnName = "nodeId")
    private TecdocSearchStructure tecdocSearchStructure;
    @MapsId("genArtNr")
    @ManyToOne
    @JoinColumn(name = "genArtNr",
                referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;


    public AllocationOfGenArtToSearchStructure(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.sortNr = sortNr;
        this.loschFlag = loschFlag;
    }

    public AllocationOfGenArtToSearchStructureId getId() {
        return id;
    }

    public void setId(AllocationOfGenArtToSearchStructureId id) {
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

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public TecdocSearchStructure getTecdocSearchStructure() {
        return tecdocSearchStructure;
    }

    public void setTecdocSearchStructure(TecdocSearchStructure tecdocSearchStructure) {
        this.tecdocSearchStructure = tecdocSearchStructure;
    }

    public GenericArticles getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(GenericArticles genericArticles) {
        this.genericArticles = genericArticles;
    }
}
