package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
     Result login(String email, String password);
     Result register(Candidate candidate);
     Result delete(Candidate candidate);
     List<Candidate> getAll();
     List<String> getAllEmails();
     List<String> getAllIdentificationNumber();
}
