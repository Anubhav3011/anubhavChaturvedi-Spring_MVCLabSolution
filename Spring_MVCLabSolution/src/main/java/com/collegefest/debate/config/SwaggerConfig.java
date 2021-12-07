package com.collegefest.debate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket studentApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("Student-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.collegefest.debate.controller")).build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Debate API")
				.description("Debate API for developers")
				.termsOfServiceUrl("https://debate.collegefest.com")
				.contact(new Contact("Debate API", "https://debate.collegefest.com", "debate.collegefest@gmail.com"))
				.license("Debate License")
				.licenseUrl("https://debate.collegefest.com")
				.version("1.0")
				.build();
	}
}
