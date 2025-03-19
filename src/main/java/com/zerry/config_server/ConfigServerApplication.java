package com.zerry.config_server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
	@Value("${GIT_USERNAME:NOT_SET}")
	private String gitUsername;

	@Value("${GIT_TOKEN:NOT_SET}")
	private String gitToken;

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
