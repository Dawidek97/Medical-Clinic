package clinic.medical_clinic.service;

import clinic.medical_clinic.model.Patient;
import clinic.medical_clinic.repository.DoctorRepository;
import clinic.medical_clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePatient {

    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public ServicePatient(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatientList() {
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(String patientName){
        patientRepository.deletePatientByName(patientName);
    }
}
