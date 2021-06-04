package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.*;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.domain.Sort;
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
        return new SuccessDataResult<>(jobAdvertisementDao.findAll(),"İş ilanları listelendi");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
       jobAdvertisementDao.save(jobAdvertisement);
       return new SuccessResult("iş ilanı eklendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllFromThatCompanyName(String companyName) {
       DataResult<List<JobAdvertisement>> result=new ErrorDataResult<>("Aktif iş ilanı bulunamadı");
        List<JobAdvertisement> jobAdvertisementList=jobAdvertisementDao.findByIsActiveIsTrueAndEmployer_CompanyName(companyName);
        if (jobAdvertisementList.size()!=0){
            result=new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementList,"İş ilanları başarıyla listelendi");
        }
        return result;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(sort),"Oluşturma tarihine göre listelendi");
    }
}
