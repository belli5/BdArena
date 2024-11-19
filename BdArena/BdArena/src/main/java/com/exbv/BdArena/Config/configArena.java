//package com.exbv.BdArena.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class configArena implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // Aplica a todas as rotas
//                .allowedOrigins("http://localhost:3000") // Permite o frontend React
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
//                .allowedHeaders("*") // Permite qualquer cabeçalho
//                .allowCredentials(true); // Permite cookies, se necessário
//    }
//}

package com.exbv.BdArena.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class configArena implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")  // Permitir CORS para todas as rotas
                .allowedOrigins("http://localhost:4220")  // Permitir requisições do frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
                .allowedHeaders("");  // Permitir todos os cabeçalhos
    }

//        @Override
//        public void addFormatters(FormatterRegistry registry) {
//            registry.addFormatterForFieldType(LocalDate.class, new org.springframework.format.datetime.standard.DateTimeFormatterRegistrar().getFormatterForFieldType(LocalDate.class));
//            registry.addFormatterForFieldType(LocalTime.class, new org.springframework.format.datetime.standard.DateTimeFormatterRegistrar().getFormatterForFieldType(LocalTime.class));
//        }
    }