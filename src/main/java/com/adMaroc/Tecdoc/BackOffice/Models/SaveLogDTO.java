package com.adMaroc.Tecdoc.BackOffice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveLogDTO {

    private String tableName;
    private long tableNumber;
    private Date startTime;
    private Date endTime;
    private long maxRows;
    private long savedRows;
    private String fileName;
}
