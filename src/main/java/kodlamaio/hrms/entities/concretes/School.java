package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name ="name" )
    private String schoolName;

    @NotNull
    @NotBlank
    @Column(name ="department_name" )
    private String departmentName;

    @NotNull
    @NotBlank
    @Column(name ="start_date" )
    private LocalDate startSchoolDate;

    @Column(name ="finish_date" )
    private String finishSchoolDate;

    @Column(name ="is_continue" )
    private boolean isContinue;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    @JsonIgnore
    private Cv cv;

}
