package com.travelersun.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class PlatformConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformConfigServerApplication.class, args);
	}
}
