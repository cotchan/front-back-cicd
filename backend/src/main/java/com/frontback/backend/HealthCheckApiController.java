package com.frontback.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/health")
@RestController
public class HealthCheckApiController {

    @Value("${current.profile}")
    private String profile;

    @GetMapping
    public String getSystemTimeMilli() {
        return String.format("active profile: %s, %d", profile, System.currentTimeMillis());
    }
}
