package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getActiveAdvertisement();

    DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize);
    Result add(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisement>>getActiveAndEmloyerId(int employerId);


}
