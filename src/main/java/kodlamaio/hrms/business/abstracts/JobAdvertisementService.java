package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();
    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAllFromThatCompanyName(String companyName);
    DataResult<List<JobAdvertisement>> getAllSorted();
}
