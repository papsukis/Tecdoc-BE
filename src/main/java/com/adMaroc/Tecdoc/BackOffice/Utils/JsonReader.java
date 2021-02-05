package com.adMaroc.Tecdoc.BackOffice.Utils;

import com.adMaroc.Tecdoc.BackOffice.Models.FileStructure;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class JsonReader {

    public FileStructure readFile(String filename) throws IOException {
        {
            ClassLoader classLoader = getClass().getClassLoader();
            try (InputStream inputStream = classLoader.getResourceAsStream("filestructure/"+filename+".json")) {

                String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
                ObjectMapper mapper = new ObjectMapper();
                FileStructure someClassObj = mapper.readValue(result, FileStructure.class);
                return someClassObj;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
}}


//    File file = new File(
//            String.valueOf(this.getClass().getClassLoader().getResourceAsStream(filename))
//    );
//    ObjectMapper mapper = new ObjectMapper();
//    FileStructure someClassObj = mapper.readValue(file, FileStructure.class);
//
//        return someClassObj;