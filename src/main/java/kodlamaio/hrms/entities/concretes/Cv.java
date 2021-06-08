package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "candidate_photo")
    private String candidatePhoto;

    @Column(name = "github_link")
    private String githubAddress;

    @Column(name = "linkedin_link")
    private String linkedinAddress;

    @Column(name = "technologies")
    private String technologies;

    @Column(name = "cover_letter")
    private String coverLetter;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "cv")
    @JsonIgnore
    private List<School> schools;

    @OneToMany(mappedBy = "cv")
    @JsonIgnore
    private List<Language> language;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    @JsonIgnore
    private Candidate candidate;

}
