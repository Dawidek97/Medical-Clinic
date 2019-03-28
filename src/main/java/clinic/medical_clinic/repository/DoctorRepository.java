package clinic.medical_clinic.repository;

import clinic.medical_clinic.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query("select d from Doctor d where d.name = ?1")
    Optional<Doctor> findByName(String name);

}
