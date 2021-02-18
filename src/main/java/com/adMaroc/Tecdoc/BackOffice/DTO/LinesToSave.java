package com.adMaroc.Tecdoc.BackOffice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinesToSave {
    private String fullPath;
    private List<String> lines;
    private String fileName;
    private int table;
}
