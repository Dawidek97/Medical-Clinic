package clinic.medical_clinic.service;

import clinic.medical_clinic.model.Doctor;
import clinic.medical_clinic.model.Patient;
import clinic.medical_clinic.repository.DoctorRepository;
import clinic.medical_clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Doctor> getDoctorByName(String name) {
        return doctorRepository.findByName(name);
    }

    public void addPatientToDoctor(Doctor doctor, Patient patient) {
        doctor.getPatients().add(patient);
        doctorRepository.save(doctor);
    }
}
