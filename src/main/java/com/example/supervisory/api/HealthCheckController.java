package com.example.supervisory.api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public String checkHealth() {
        boolean isAppUp = true;

        if (isAppUp) {
            return "Application is UP";
        } else {
            return "Application is DOWN";
        }
    }
}