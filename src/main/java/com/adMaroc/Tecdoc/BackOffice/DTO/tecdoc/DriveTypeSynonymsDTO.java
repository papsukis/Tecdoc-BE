package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.DriveTypeSynonyms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriveTypeSynonymsDTO {
    long antrArt;
    long kTypNr;
    KeyTableDTO driveType;//82
    DescriptionDTO description;

    public DriveTypeSynonymsDTO(DriveTypeSynonyms driveTypeSynonyms) {
        antrArt=driveTypeSynonyms.getId().getAntrArt();
        kTypNr=driveTypeSynonyms.getId().getkTypNr();
        driveType=new KeyTableDTO(82,antrArt);
        description=new DescriptionDTO(driveTypeSynonyms.getCountryAndLanguageDependentDescriptions());
    }
}
