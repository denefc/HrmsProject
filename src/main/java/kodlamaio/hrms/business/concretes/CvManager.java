package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;
    private CandidateDao candidateDao;

    @Autowired
    public CvManager(CvDao cvDao, CandidateDao candidateDao) {
        this.cvDao = cvDao;
        this.candidateDao = candidateDao;
    }


    @Override
    public Result add(int candidateId,Cv cv) {
        Candidate candidate=candidateDao.findById(candidateId);
        if (candidate==null){
            return new ErrorResult("Lütfen doğru bir aday idsi giriniz");
        }
        candidate.getCvs().add(cv);
        cv.setCandidate(candidate);
        cvDao.save(cv);
        return new SuccessResult("Başarıyla eklendi");
    }
}
