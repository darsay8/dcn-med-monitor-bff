package dev.rm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.rm.model.VitalSign;

@Service
public class VitalSignService {

    @Value("${service.vital-signs.url}")
    private String vitalSignsUrl;

    private final RestTemplate restTemplate;

    public VitalSignService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<VitalSign> getVitalSignsByPatientId(Long patientId) {
        String url = vitalSignsUrl + "/patient/" + patientId;
        return restTemplate.getForObject(url, List.class);
    }

    public VitalSign getVitalSignById(Long id) {
        String url = vitalSignsUrl + "/" + id;
        return restTemplate.getForObject(url, VitalSign.class);
    }

    public VitalSign createVitalSign(VitalSign vitalSign) {
        return restTemplate.postForObject(vitalSignsUrl, vitalSign, VitalSign.class);
    }

}
