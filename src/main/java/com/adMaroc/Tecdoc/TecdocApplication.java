package com.adMaroc.Tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Configurations.FilesConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@SpringBootApplication
@EnableConfigurationProperties({
		FilesConfig.class
})
@Slf4j
public class TecdocApplication {

	public static void main(String[] args) {
		SpringApplication.run(TecdocApplication.class, args);
	}

	@Bean(name = "taskExecutor")
	public Executor taskExecutor() {
		log.debug("Creating Async Task Executor");
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("ftpSave-");
		executor.initialize();
		return executor;
	}
}
