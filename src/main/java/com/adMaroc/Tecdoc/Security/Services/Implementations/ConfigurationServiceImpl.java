package com.adMaroc.Tecdoc.Security.Services.Implementations;

import com.adMaroc.Tecdoc.Security.Models.Config;
import com.adMaroc.Tecdoc.Security.Repository.ConfigurationRepository;
import com.adMaroc.Tecdoc.Security.Services.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {


    @Autowired
    private ConfigurationRepository configurationRepository;

    @Override
    public void saveConfiguration(Config configuration){
        configurationRepository.save(configuration);
    }

    @Override
    public Config getConfiguration(String name){
        return configurationRepository.findByName(name);
    }
}
