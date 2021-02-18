package com.adMaroc.Tecdoc.Security.Repository;

import com.adMaroc.Tecdoc.Security.Models.Config;

public interface CustomConfigRepository {
    Config getConfig(String name);
}
