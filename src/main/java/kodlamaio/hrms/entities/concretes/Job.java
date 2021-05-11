package kodlamaio.hrms.entities.concretes;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "jobs_name")
    private String jobName;
}
