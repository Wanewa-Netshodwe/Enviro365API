package com.enviro.assessment.grad001.WanewaNetshodwe.Swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Enviro Assessment API")
                        .version("1.0.0")
                        .description("API documentation for the Enviro Assessment application.")
                        .contact(new Contact()
                                .name("Wanewa Netshodwe")
                                .email("waneexw@gmail.com")
                        ));

    }


}
