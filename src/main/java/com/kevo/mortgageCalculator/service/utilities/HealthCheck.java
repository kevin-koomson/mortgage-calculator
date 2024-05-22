package com.kevo.mortgageCalculator.service.utilities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HealthCheck {
    private String message;
    private Long uptime;
}
