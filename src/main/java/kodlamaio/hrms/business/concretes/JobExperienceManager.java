package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;
    private CvDao cvDao;
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao, CvDao cvDao,JobPositionDao jobPositionDao) {
        this.jobExperienceDao = jobExperienceDao;
        this.cvDao = cvDao;
        this.jobPositionDao=jobPositionDao;
    }

    @Override
    public Result add(int cvId, JobExperience jobExperience) {
        Cv cv=cvDao.findById(cvId);
        if (cv==null){
            return new ErrorResult("Lütfen geçerli cv idsi girin");
        }
       JobPosition jobPosition=jobPositionDao.findById(jobExperience.getId());
        if (jobPosition==null){
            return new ErrorResult("Lütfen geçerli iş pozisyonu giriniz");
        }
        if (jobExperience.getFinishYear().equals("")){
            jobExperience.setContinue(true);
            jobExperience.setFinishYear("İşe devam ediyor");
        }else{
            jobExperience.setContinue(false);
        }
        cv.getJobExperiences().add(jobExperience);
        jobExperience.setCv(cv);
        jobExperienceDao.save(jobExperience);
        return new SuccessResult("Başarıyla iş tecrübesi eklendi");
    }
}
