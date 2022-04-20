package com.cts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationPortalApplication.class, args);
	}
	@Bean
	public Docket newsApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cts.app"))
				.paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
		return docket;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Application-Portal")
				.description("Main Portal Application that interacts with the microservices")
				.version("1.0")
				.build();
	}

}
