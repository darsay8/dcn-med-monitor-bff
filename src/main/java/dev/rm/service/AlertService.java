package dev.rm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.rm.model.Alert;

@Service
public class AlertService {

    @Value("${service.alert.url}")
    private String alertServiceUrl;

    private final RestTemplate restTemplate;

    public AlertService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Alert> getAlerts() {
        return restTemplate.getForObject(alertServiceUrl, List.class);
    }

}
