package com.adMaroc.Tecdoc.BackOffice.Utils;

import com.adMaroc.Tecdoc.BackOffice.Models.FileStructure;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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
}

    public List<String> readFileOrder() throws IOException {
        {
            ClassLoader classLoader = getClass().getClassLoader();

            try (InputStream inputStream = classLoader.getResourceAsStream("utils/order.json")) {

                String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
                ObjectMapper mapper = new ObjectMapper();
                List<String> someClassObj = mapper.readValue(result, new TypeReference<List<String>>() {
                });
                return someClassObj;

            } catch (IOException e) {
                throw new InternalServerException(e.getMessage());
            }

        }
    }
}
