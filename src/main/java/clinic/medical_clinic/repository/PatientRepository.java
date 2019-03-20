package clinic.medical_clinic.repository;

import clinic.medical_clinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("delete from Patient p where p.name = ?1")
    void deletePatientByName(String patientName);
}
