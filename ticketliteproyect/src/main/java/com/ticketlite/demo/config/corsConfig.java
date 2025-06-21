package com.ticketlite.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class corsConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") //Aplica a todas las rutas
                        .allowedOrigins("*") //Origen del frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //Metodos permitidos
                        .allowedHeaders("*") //Permite todos los headers
                        .allowCredentials(true); //Cambia a true si usas cookies/sesiones
            }
        };

    }
}
