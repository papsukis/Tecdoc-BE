package com.adMaroc.Tecdoc.BackOffice.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class ExcelSheet {
    String SheetName;
    List<ExcelCell> cells;

    public ExcelSheet() {
        SheetName="Articles";
    }
}
