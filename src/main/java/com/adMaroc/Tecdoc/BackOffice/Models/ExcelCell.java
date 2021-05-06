package com.adMaroc.Tecdoc.BackOffice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelCell {
    String ColumnName;
    List<String> values=new ArrayList<>();

    public ExcelCell(String columnName) {
        ColumnName = columnName;
    }
}
