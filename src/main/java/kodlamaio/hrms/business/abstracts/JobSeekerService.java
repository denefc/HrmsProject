package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {
     Result login(String email, String password);
     Result register(JobSeeker jobSeeker);
     Result delete(JobSeeker jobSeeker);
     List<JobSeeker> getAll();
     List<String> getAllEmails();
     List<String> getAllIdentificationNumber();
}
