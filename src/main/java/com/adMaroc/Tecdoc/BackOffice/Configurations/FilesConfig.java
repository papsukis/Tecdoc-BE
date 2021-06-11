package com.adMaroc.Tecdoc.BackOffice.Configurations;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties()
public class FilesConfig {

    @Value( "${file.excel-dir}" )
    String excelFullPath;
    @Value( "${file.img-dir}" )
    String imgFullPath;
    @Value("${x3.endPoint}")
    String x3EndPoint;
}
