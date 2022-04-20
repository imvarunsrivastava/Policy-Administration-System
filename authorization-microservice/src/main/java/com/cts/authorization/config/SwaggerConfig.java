package com.cts.authorization.config;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/auth/**"))
				.apis(RequestHandlerSelectors.basePackage("com.cts.authorization"))
				.build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Employee API Documentation",
				"Autherization API for swagger",
				"1.0", "Free to use",
				new springfox.documentation
				.service.Contact("Soemsh Kumar", "www.employee.com",
						"2010samkumar@gmail.com"),
				"API License", "employee.com", Collections.emptyList());

	}
}
