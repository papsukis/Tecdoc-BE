package com.adMaroc.Tecdoc.BackOffice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileToGetDataDTO {

    String fileName;
    String fullpath;
}
