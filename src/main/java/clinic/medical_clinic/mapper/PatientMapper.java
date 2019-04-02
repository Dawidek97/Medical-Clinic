package clinic.medical_clinic.mapper;

import clinic.medical_clinic.model.Patient;
import clinic.medical_clinic.model.dtos.PatientDto;

public class PatientMapper implements Mapper<PatientDto, Patient>{


    @Override
    public Patient map(PatientDto from) {
        return Patient.builder()
                .name(from.getName())
                .surName(from.getSurName())
                .pesel(from.getPesel())
                .age(from.getAge())
                .build();
    }

    @Override
    public PatientDto reverseMap(Patient to) {
        return PatientDto.builder()
                .name(to.getName())
                .surName(to.getSurName())
                .pesel(to.getPesel())
                .age(to.getAge())
                .build();
    }
}
