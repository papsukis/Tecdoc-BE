package com.adMaroc.Tecdoc.BackOffice.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class SaveLogDTO {

    private String tableName;
    private long tableNumber;
    private Date startTime;
    private Date endTime;
    private long maxRows;
    private long savedRows;
    private String fileName;
}
