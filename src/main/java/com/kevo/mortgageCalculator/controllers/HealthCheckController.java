package com.kevo.mortgageCalculator.controllers;

import com.kevo.mortgageCalculator.service.utilities.HealthCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthCheckController {
    public static final long startTime = System.currentTimeMillis();
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public HealthCheck healthCheck() {
        long uptime = (System.currentTimeMillis() - startTime)/1000;
        HealthCheck check = HealthCheck.builder()
                .message("Service Running ")
                .uptime(uptime)
                .build();
        log.info(check.toString());
        return check;
    }
}
