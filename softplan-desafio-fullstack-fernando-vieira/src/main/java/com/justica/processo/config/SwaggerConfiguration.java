package com.justica.processo.config;

import com.google.common.collect.Lists;
import com.justica.processo.component.MensagemComponente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	private final MensagemComponente mensagemComponente;

	@Autowired
	public SwaggerConfiguration(MensagemComponente mensagemComponente) {
		this.mensagemComponente = mensagemComponente;
	}

	@Value("${app.build.version}")
	private String appBuildVersion;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.justica.processo"))
				.paths(PathSelectors.any()).build()
				.apiInfo(apiInfo())
				.securitySchemes(Lists.newArrayList(apiKey()));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(this.mensagemComponente.get("swagger.title"))
				.description(this.mensagemComponente.get("swagger.description"))
				.version(appBuildVersion)
				.build();
	}

	private ApiKey apiKey() {
		return new ApiKey("Authorization", "Authorization", "header");
	}

}
