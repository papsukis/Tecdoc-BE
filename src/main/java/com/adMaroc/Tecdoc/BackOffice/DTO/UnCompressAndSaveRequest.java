package com.adMaroc.Tecdoc.BackOffice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnCompressAndSaveRequest {

    private String fileName;
    private boolean selected;
    private String fullPath;
}
