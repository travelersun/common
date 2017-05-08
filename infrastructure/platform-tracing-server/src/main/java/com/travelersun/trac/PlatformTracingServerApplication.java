package com.travelersun.trac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class PlatformTracingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformTracingServerApplication.class, args);
	}
}
