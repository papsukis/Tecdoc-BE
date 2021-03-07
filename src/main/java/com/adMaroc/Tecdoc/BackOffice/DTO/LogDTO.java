package com.adMaroc.Tecdoc.BackOffice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO {

    private List<SaveLogDTO> logs;
    private long totalRows;
    private Date startTime;
    private Date endTime;
    private long manufacturerCode;
    private String manufacturerName;
}
