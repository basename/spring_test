package com.basename.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("spring.datasource")
@Data
public class DatasourceConfiguration {

    private String userName;
    private String password;
}
