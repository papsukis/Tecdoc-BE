package com.adMaroc.Tecdoc.Security.Repository;

import com.adMaroc.Tecdoc.Security.Models.Config;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Config,Long> {

    Config findByName(String name);
}
