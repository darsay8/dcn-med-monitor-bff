package dev.rm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rm.model.Alert;
import dev.rm.model.Patient;
import dev.rm.service.AlertService;
import dev.rm.service.PatientService;

@RestController
@RequestMapping("/api")
public class Controller {

    private final PatientService patientService;
    private final AlertService alertService;

    public Controller(PatientService patientService, AlertService alertService) {
        this.patientService = patientService;
        this.alertService = alertService;
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, world! From Server");
        return response;
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<Patient> getUserById(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("/alerts")
    public ResponseEntity<List<Alert>> getAlerts() {
        List<Alert> alerts = alertService.getAlerts();
        return new ResponseEntity<>(alerts, HttpStatus.OK);

    }
}