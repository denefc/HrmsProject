package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
    private int candidateId;
    private String description;
    private String githubAddress;
    private String linkedinAddress;
    private String technologies;
    private String coverLetter;

}