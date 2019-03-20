package clinic.medical_clinic.controller;
import clinic.medical_clinic.model.Patient;
import clinic.medical_clinic.repository.PatientRepository;
import clinic.medical_clinic.service.ServicePatient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {

    private PatientRepository patientRepository;
    private ServicePatient servicePatient;

    public PatientController(PatientRepository patientRepository, ServicePatient servicePatient) {
        this.patientRepository = patientRepository;
        this.servicePatient = servicePatient;
    }

    @PostMapping("/patient")
    public Patient addPatient(@RequestBody Patient patient) {
        return servicePatient.addPatient(patient);
    }

    @PostMapping("/patient/{patientName}")
    public void deletePatient(@PathVariable String patientName) {
        servicePatient.deletePatient(patientName);
    }


    @GetMapping("/patient")
    public List<Patient> getAllPatient() {
        return servicePatient.getPatientList();
    }


}
