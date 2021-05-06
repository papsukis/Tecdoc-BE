package com.adMaroc.Tecdoc.BackOffice.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileInfos {
    String fileName;
    int brandNumber;
    String brandName;
}
