package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface  EmployerService {
     Result register(Employer employer);
     List<Employer> getAll();
}
