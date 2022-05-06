package com.frontback.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/health")
@RestController
public class HealthCheckApiController {

    @Value("${current.profile}")
    private String profile;

    @Autowired
    private CustomConfig customConfig;

    @GetMapping
    public String getSystemTimeMilli() {
        return String.format("active profile: %s, %d", profile, System.currentTimeMillis());
    }

    @GetMapping("/v2")
    public String getSystemTimeMilli_v2() {
        return String.format("my-custom-value: %s, %d", customConfig.toString(), System.currentTimeMillis());
    }

    @GetMapping("/v3")
    public String getSystemTimeMilli_v3() {
        return String.format("currentTimeMillis: %d", System.currentTimeMillis());
    }
}
