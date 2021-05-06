package com.adMaroc.Tecdoc.BackOffice.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FtpFile {

    private String fullPath;
    private List<String> lines;
    private String fileName;
    private String folderName;
    private int table;
    private int maxRows;
    private String tableName;

}
