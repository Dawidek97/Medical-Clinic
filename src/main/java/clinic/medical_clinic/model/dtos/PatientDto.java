package clinic.medical_clinic.model.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private String name;
    private String surName;
    private int age;
    private int pesel;
    private String specialisation;

}
