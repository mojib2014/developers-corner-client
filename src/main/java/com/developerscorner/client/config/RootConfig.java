package com.developerscorner.client.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		"com.developerscorner.client.service",
		"com.developerscorner.client.config",
		"com.developerscorner.client.security"
})
public class RootConfig {

}
