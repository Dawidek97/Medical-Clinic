package clinic.medical_clinic.service;

import clinic.medical_clinic.model.Doctor;
import clinic.medical_clinic.repository.DoctorRepository;
import clinic.medical_clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDoctor {

    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public ServiceDoctor(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public List<Doctor> getDoctorList() {
        return doctorRepository.findAll();
    }
}
