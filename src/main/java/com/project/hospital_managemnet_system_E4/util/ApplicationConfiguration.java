package com.project.hospital_managemnet_system_E4.util;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ApplicationConfiguration {

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components())
                .info(new Info()
                        .title("Hospital Management System")
                        .description("The Hospital Management System is a comprehensive solution to manage and automate hospital operations. "
                                + "This system allows users to manage patient records, schedule appointments, track treatments, manage billing and invoicing, "
                                + "and more. It enhances the overall efficiency and organization of hospital operations.")
                        .version("1.0")
                        .contact(new Contact().name("Hospital IT Team").email("support@hospital.com"))
                        .license(new License().name("Open License").url("#")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("public")
                .packagesToScan("com.project.hospital_managemnet_system_E4") // Change this package to the actual package where your controllers are located
                .build();
    }
}
