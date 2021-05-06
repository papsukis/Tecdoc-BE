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
public class Directory {

    private String name;
    private List<FileInfos> files;
    private List<Directory> subDir;
    String fullPath;
    private Directory parent;
    int level;
}
