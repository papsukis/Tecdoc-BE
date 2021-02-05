package com.adMaroc.Tecdoc.BackOffice.DTO;

import com.adMaroc.Tecdoc.BackOffice.Models.Directory;
import com.adMaroc.Tecdoc.BackOffice.Models.Tree;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FtpResponse {


    Directory dir;
    List<String> files;
    List<Directory> subDir;
}
