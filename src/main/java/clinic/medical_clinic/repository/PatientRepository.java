package clinic.medical_clinic.repository;

import clinic.medical_clinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("delete from Patient p where p.name = ?1 and p.surName = ?2")
    void deletePatientByNameAAndSurName(String patientName, String surname);

    @Query("select p from Patient p where p.name = ?1")
    Optional<Patient> findByName(String name);
}
