package dev.rm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.rm.model.Patient;

@Service
public class PatientService {

    @Value("${service.patient.url}")
    private String patientServiceUrl;

    private final RestTemplate restTemplate;

    public PatientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Patient getPatientById(Long id) {
        String url = patientServiceUrl + "/" + id;
        return restTemplate.getForObject(url, Patient.class);
    }

    public List<Patient> getAllPatients() {
        return restTemplate.getForObject(patientServiceUrl, List.class);
    }

}
