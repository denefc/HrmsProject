package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "job_advertisement")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="job_description" )
    private String jobDescription;

    @Column(name ="min_salary" )
    private int minimumSalary;

    @Column(name ="max_salary" )
    private int maximumSalary;

    @Column(name ="open_positions" )
    private int openPositions;

    @Column(name ="application_deadline" )
    private LocalDateTime  applicationDeadline;

    @Column(name ="is_active" )
    private boolean isActive;

    @Column(name ="created_date" )
    private LocalDateTime createdDate;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

}
