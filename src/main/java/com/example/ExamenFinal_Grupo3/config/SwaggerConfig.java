package com.example.ExamenFinal_Grupo3.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI colegioOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Colegio Carlos Medinaceli")
                        .description("Backend para la versión mejorada del sitio web del Colegio Carlos Medinaceli")
                        .version("1.0.0"));
    }
}