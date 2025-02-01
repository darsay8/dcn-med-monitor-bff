package dev.rm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rm.model.Alert;
import dev.rm.model.Patient;
import dev.rm.model.VitalSign;
import dev.rm.service.AlertService;
import dev.rm.service.PatientService;
import dev.rm.service.VitalSignService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class Controller {

    private final PatientService patientService;
    private final AlertService alertService;
    private final VitalSignService vitalSignService;

    public Controller(PatientService patientService, AlertService alertService, VitalSignService vitalSignService) {
        this.patientService = patientService;
        this.alertService = alertService;
        this.vitalSignService = vitalSignService;
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

    @PostMapping("/vital-signs")
    public ResponseEntity<VitalSign> createVitalSign(@RequestBody VitalSign vitalSign) {
        VitalSign newVitalSign = vitalSignService.createVitalSign(vitalSign);
        return new ResponseEntity<>(newVitalSign, HttpStatus.CREATED);
    }

    @GetMapping("/vital-signs/patient/{patientId}")
    public ResponseEntity<List<VitalSign>> getVitalSignsByPatientId(@PathVariable Long patientId) {
        List<VitalSign> vitalSigns = vitalSignService.getVitalSignsByPatientId(patientId);
        return new ResponseEntity<>(vitalSigns, HttpStatus.OK);
    }

    @GetMapping("/vital-signs/{vitalSignId}")
    public ResponseEntity<VitalSign> getVitalSignById(@PathVariable Long vitalSignId) {
        VitalSign vitalSign = vitalSignService.getVitalSignById(vitalSignId);
        return new ResponseEntity<>(vitalSign, HttpStatus.OK);
    }

}