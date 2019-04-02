package clinic.medical_clinic.model.dtos;

import clinic.medical_clinic.model.Doctor;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecjalisationDto {

    private String title;
    private Doctor doctor;
}
