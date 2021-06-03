package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPosition> getAll() {
        return jobPositionDao.findAll();
    }

    @Override
    public Result add(JobPosition jobPosition) {
        Result result=new ErrorResult("Bu job pozisyonu daha önce eklenmiş lütfen başka pozisyon giriniz");
        if (!positionIsUsed(jobPosition.getTitle())){
            jobPositionDao.save(jobPosition);
            result=new SuccessResult("İş pozisyonu eklendi");
        }
        return result;
    }


    public boolean positionIsUsed(String positionName){
        List<JobPosition> positions=jobPositionDao.findByTitleEquals(positionName);
        if (positions.size()==0){
            return false;
        }
        return true;
    }
}
