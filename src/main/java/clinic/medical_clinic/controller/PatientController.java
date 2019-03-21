package clinic.medical_clinic.controller;

import clinic.medical_clinic.model.Doctor;
import clinic.medical_clinic.model.Patient;
import clinic.medical_clinic.model.dtos.PatientDto;
import clinic.medical_clinic.repository.PatientRepository;
import clinic.medical_clinic.service.ServiceDoctor;
import clinic.medical_clinic.service.ServicePatient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private PatientRepository patientRepository;
    private ServicePatient servicePatient;
    private ServiceDoctor serviceDoctor;

    public PatientController(PatientRepository patientRepository, ServicePatient servicePatient, ServiceDoctor serviceDoctor) {
        this.patientRepository = patientRepository;
        this.servicePatient = servicePatient;
        this.serviceDoctor = serviceDoctor;
    }

    @PostMapping("/patient")
    public void addPatient(@RequestBody PatientDto patientDto) {

        List<Doctor> doctors = serviceDoctor.getDoctorList();
        Patient newPatient;

        for (Doctor d: doctors) {
           if(d.getSpecjalisation().getTitle().equals(patientDto.getSpecialisation())) {

               newPatient = Patient.builder()
                       .name(patientDto.getSurName())
                       .age(patientDto.getAge())
                       .pesel(patientDto.getPesel())
                       .surName(patientDto.getSurName())
                       .build();

               serviceDoctor.addPatientToDoctor(d, patientRepository.save(newPatient));

           }

        }

    }

    @PostMapping("/patient/{patientName}")
    public void deletePatient(@PathVariable String patientName, String surname) {
        servicePatient.deletePatient(patientName, surname);
    }

    @GetMapping("/patient")
    public List<Patient> getAllPatient() {
        return servicePatient.getPatientList();
    }
}
