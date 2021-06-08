package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "job_experiences")
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @OneToOne()
    @JoinColumn(name = "job_position_id")
    @NotNull
    @NotBlank
    private JobPosition jobPosition;

    @Column(name = "start_year")
    private LocalDate startYear;

    @Column(name = "finish_year")
    private String finishYear;

    @Column(name = "is_continue")
    private boolean isContinue;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    @JsonIgnore
    private Cv cv;

}
