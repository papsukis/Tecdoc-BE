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
public class FileStructure {

    private String tableName;
    private int tableNumber;
    private int length;
    private String contents;
    private String deltaKey;
    private String sorting;
    private String primaryKey;
    private String className;
    private List<Attributs> attr;
}
