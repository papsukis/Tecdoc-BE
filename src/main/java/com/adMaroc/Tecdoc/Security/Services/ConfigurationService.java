package com.adMaroc.Tecdoc.Security.Services;

import com.adMaroc.Tecdoc.Security.Models.Config;

public interface ConfigurationService {

    void saveConfiguration(Config configuration);


    Config getConfiguration(String name);
}
