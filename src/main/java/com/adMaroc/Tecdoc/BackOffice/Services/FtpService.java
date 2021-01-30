package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.Models.FtpClient;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FtpService {

    FtpClient ftp;

    public FtpClient connect(String ipAddress,int port, String userName, String password) throws IOException {

        ftp=new FtpClient(ipAddress,port,userName,password);

        List<String> files=new ArrayList<>();

        try
        {
            ftp.open();
            ftp.enterPassiveMode();
            return ftp;
        }
        catch (Exception e)
        {
            throw new InternalServerException("Could not connect to ftp");
        }
    }
    public String CurrentDirectory() throws IOException {
        try {
            return ftp.currentDirectory();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

    }
}
