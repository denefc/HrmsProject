package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.abstracts.EmailCheckService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service

public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private EmailCheckService emailCheckService;
    private EmailSendService emailSendService;


    @Autowired
    public CandidateManager(EmailCheckService emailCheckService, CandidateDao candidateDao, EmailSendService emailSendService) {
        this.emailCheckService = emailCheckService;
        this.candidateDao = candidateDao;
        this.emailSendService = emailSendService;

    }


    @Override
    public Result register(Candidate candidate) {
        Result result=new ErrorResult("Kayıt Başarısız Lütfen emailinizi doğru formatta girdiğinize dikkat ediniz veya daha önce kayıt yapmış olabilirsinz");
        if (emailCheckService.emailCheck(candidate.getEmail())&&
                !emailIsUsed(candidate.getEmail())
                && !identificationNumberIsUsed(candidate.getIdentificationNumber())){
             emailSendService.emailSend(candidate.getEmail());
             this.candidateDao.save(candidate);
             result = new SuccessResult("Kayıt Başarılı.Mailinizi kontrol edin lütfen.");
        }
        return result;
    }

    @Override
    public List<Candidate> getAll() {
        return this.candidateDao.findAll();
    }


    public Boolean emailIsUsed(String email) {
        //liste boş dönerse kullanılmamıştır
        List<Candidate>candidatesEmails=candidateDao.findByEmailEquals(email);
        if (candidatesEmails.size()==0){
            return false;
        }
        return true;
    }

    public boolean identificationNumberIsUsed(String identificationNumber) {
        //liste boş dönerse kullanılmamıştır
        List<Candidate>candidatesIds=candidateDao.findByIdentificationNumberEquals(identificationNumber);
        if (candidatesIds.size()==0){
            return false;
        }
        return true;
    }

}