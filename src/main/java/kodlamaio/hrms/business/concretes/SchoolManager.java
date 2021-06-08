package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;
    private CvDao cvDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao, CvDao cvDao) {
        this.schoolDao = schoolDao;
        this.cvDao = cvDao;
    }

    @Override
    public Result add(int cvId,School school) {
        if (school.getFinishSchoolDate().equals("")){
            school.setContinue(true);
            school.setFinishSchoolDate("Okuyor");
        }else{
            school.setContinue(false);
        }
        Cv cv= cvDao.findById(cvId);
        if (cv==null){
            return new ErrorResult("Lütfen doğru bir cv idsi giriniz");
        }
        cv.getSchools().add(school);
        school.setCv(cv);
        schoolDao.save(school);
        return new SuccessResult("Okul eklendi");
    }
}
