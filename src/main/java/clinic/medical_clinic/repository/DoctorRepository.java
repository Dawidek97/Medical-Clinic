package clinic.medical_clinic.repository;

import clinic.medical_clinic.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {


}
