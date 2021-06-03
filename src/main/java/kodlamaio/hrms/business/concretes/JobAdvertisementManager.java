package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.data.domain.Sort;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

   private JobAdvertisementDao jobAdvertisementDao;

   @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return null;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveAdvertisement() {
        return null;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        return null;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveAndEmloyerId(int employerId) {
        return null;
    }
}
