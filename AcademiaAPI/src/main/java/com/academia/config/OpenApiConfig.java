// src/main/java/com/academia/config/OpenApiConfig.java
package com.academia.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("API Gestão de Academia").version("v1").description("API para prova - gestão de alunos, planos, treinos e pagamentos"));
    }
}
