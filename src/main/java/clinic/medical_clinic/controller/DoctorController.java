package clinic.medical_clinic.controller;

import clinic.medical_clinic.model.Doctor;
import clinic.medical_clinic.repository.DoctorRepository;
import clinic.medical_clinic.service.ServiceDoctor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {

    private DoctorRepository doctorRepository;
    private ServiceDoctor serviceDoctor;

    public DoctorController(DoctorRepository doctorRepository, ServiceDoctor serviceDoctor) {
        this.doctorRepository = doctorRepository;
        this.serviceDoctor = serviceDoctor;
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctor() {
        return serviceDoctor.getDoctorList();
    }
}