package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
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
        Result result=new Result(false);
        if (positionUsed(jobPosition.getTitle())){
            jobPositionDao.save(jobPosition);
            result=new SuccessResult("İş pozisyonu eklendi");
        }
        return result;
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        jobPositionDao.delete(jobPosition);
        return new SuccessResult("İş pozisyonu silindi");
    }

    public boolean positionUsed(String positionName){
        boolean resultFlag=true;
        List<JobPosition> allUsed=getAll();
        for (JobPosition position:allUsed){
            if (position.getTitle().equals(positionName)){
                resultFlag=false;
            }
        }
        return resultFlag;
    }
}
