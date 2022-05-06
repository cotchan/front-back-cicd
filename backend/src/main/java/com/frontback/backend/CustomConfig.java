package com.frontback.backend;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
@ConfigurationProperties(prefix = "my.custom.value")
public class CustomConfig {
    private String region;
    private String url;
    private String bucket;
    private String accessKey;
    private String secretKey;
    private String profile;
}
