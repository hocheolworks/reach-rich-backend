package com.reachrich.backtester.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("월클 백테스터 Reach rich 의 API 문서")
                        .version("0.0.1")
                        .description("월클 백테스터 Reach rich 의 API 문서"));
    }
}