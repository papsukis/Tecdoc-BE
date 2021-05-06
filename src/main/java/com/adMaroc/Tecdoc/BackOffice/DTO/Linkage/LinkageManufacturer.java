package com.adMaroc.Tecdoc.BackOffice.DTO.Linkage;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.LinkedArticlesCDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkageManufacturer {
    LinkageIdDTO linkageIdDTO;
    String herid;
    List<LinkageDetails> linkageDetails;

    public LinkageManufacturer(LinkedArticlesCDTO linked) {
        this.linkageIdDTO = new LinkageIdDTO(linked);
        this.herid = linked.getManufacturer().getHerid();
    }
}
