package clinic.medical_clinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialisation_id")
    private Specjalisation specjalisation;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(
            name = "doctor_patient",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private Set<Patient> patients = new HashSet<>();

}