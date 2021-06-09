package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    @Override
    public DataResult<List<Cv>> getAllCvsByCandidateId(int candidateId) {
        Candidate candidate=candidateDao.findById(candidateId);
        if (candidate==null){
            return new ErrorDataResult<>("Bu idye sahip aday yok ! lütfen doğru bir id giriniz");
        }
       if (candidate.getCvs().size()==0){
           return new ErrorDataResult<>("Adayın cvsi yok");
       }
        return new SuccessDataResult<List<Cv>>(cvDao.findByCandidateId(candidateId),"bu cvye ait tüm datalar döndürüldü");
    }
}
