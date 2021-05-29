package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface  EmployerService {
     Result login(String email, String password);
     Result register(Employer employer);
     Result delete(Employer employer);

     List<Employer> getAll();
     List<String> getAllEmails();
}
