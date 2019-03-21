package clinic.medical_clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surName;
    @Column(name = "Age")
    private int age;
    @Column(name = "Pesel")
    private int pesel;

    @JsonIgnore
    @ManyToMany(mappedBy = "patients")
    private Set<Doctor> doctors = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getAge() == patient.getAge() &&
                getPesel() == patient.getPesel() &&
                getName().equals(patient.getName()) &&
                getSurName().equals(patient.getSurName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurName(), getAge(), getPesel());
    }
}