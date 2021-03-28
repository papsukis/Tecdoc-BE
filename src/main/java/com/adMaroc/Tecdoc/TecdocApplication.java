package com.adMaroc.Tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Configurations.FilesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FilesConfig.class
})
public class TecdocApplication {

	public static void main(String[] args) {
		SpringApplication.run(TecdocApplication.class, args);
	}

}
