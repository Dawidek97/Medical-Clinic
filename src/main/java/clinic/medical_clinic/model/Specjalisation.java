package clinic.medical_clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Specjalisation")
public class Specjalisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specjalisation_id")
    private Integer id;
    @Column(name = "Name_Specjalisation")
    private String title;

    @JsonIgnore
    @OneToOne(mappedBy = "specjalisation", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Doctor doctor;

}
