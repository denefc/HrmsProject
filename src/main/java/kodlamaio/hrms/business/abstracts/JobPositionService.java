package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
     List<JobPosition> getAll();
     Result add(JobPosition jobPosition);
     Result delete(JobPosition jobPosition);
}