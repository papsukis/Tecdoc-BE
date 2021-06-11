package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.Configurations.FilesConfig;
import com.adMaroc.Tecdoc.BackOffice.Models.x3Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class X3Service {

    @Autowired
    private FilesConfig filesConfig;

    public x3Article getArticle(String artNr){
        RestTemplate restTemplate = new RestTemplate();

        x3Article result = restTemplate.getForObject(filesConfig.getX3EndPoint()+correctArtNr(artNr), x3Article.class);

        return result;
    }

    private String correctArtNr(String artNr){
        return artNr
                .replace(".","")
                .replace(" ","")
                .replace("+","")
                .replace("=","");
    }
}
