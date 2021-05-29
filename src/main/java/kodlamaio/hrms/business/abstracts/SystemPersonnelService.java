package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

import java.util.List;

public interface SystemPersonnelService {
     DataResult<List<SystemPersonnel>> getAll();
     Result delete(SystemPersonnel systemPersonnel);
     Result register(SystemPersonnel systemPersonnel);
}
