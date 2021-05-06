package com.adMaroc.Tecdoc.BackOffice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadRequest {
    private String ftpIp ;
    private int ftpPort;
    private String ftpUsername;
    private String ftpPassword;
    private List<UnCompressAndSaveRequest> files;
}
