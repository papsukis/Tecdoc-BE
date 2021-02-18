package com.adMaroc.Tecdoc.Security.Repository;

import com.adMaroc.Tecdoc.Security.Models.Config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends JpaRepository<Config,Long>,CustomConfigRepository {

    Config findByName(String name);
}
