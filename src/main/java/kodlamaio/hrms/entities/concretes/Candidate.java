package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@Table(name = "candidates")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "birth_year")
    private LocalDate birthYear;

    @OneToMany(mappedBy = "candidate")
    @JsonIgnore()
    private List<Cv> cvs;
}
