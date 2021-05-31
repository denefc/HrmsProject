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

    private List<String> emails = new ArrayList<>();
    private List<String> identificationNumbers = new ArrayList<>();

    @Autowired
    public CandidateManager(EmailCheckService emailCheckService, CandidateDao candidateDao, EmailSendService emailSendService) {
        this.emailCheckService = emailCheckService;
        this.candidateDao = candidateDao;
        this.emailSendService = emailSendService;

    }

    @Override
    public Result login(String email, String password) {
        Result result = new ErrorResult("Giriş Başarısız!");
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).getEmail().equals(email) && getAll().get(i).getPassword().equals(password)) {
                result = new SuccessResult("Giriş Başarılı!");
            }
        }
        return result;
    }

    @Override
    public Result register(Candidate candidate) {
        Result result = new ErrorResult("Kayıt Başarısız!");
        if (emailCheckService.emailCheck(candidate.getEmail())
                && emailIsItUsed(candidate.getEmail())
                && identificationNumberIsItUsed(candidate.getIdentificationNumber())
                ) {
            emailSendService.emailSend(candidate.getEmail());
            this.candidateDao.save(candidate);
            result = new SuccessResult("Kayıt Başarılı.");
        }
        return result;
    }

    @Override
    public List<Candidate> getAll() {
        return this.candidateDao.findAll();
    }

    @Override
    public List<String> getAllEmails() {
        for (int i = 0; i < getAll().size(); i++) {
            emails.add(getAll().get(i).getEmail());
        }
        return emails;
    }

    @Override
    public List<String> getAllIdentificationNumber() {
        for (int i = 0; i < getAll().size(); i++) {
            identificationNumbers.add(getAll().get(i).getIdentificationNumber());
        }
        return identificationNumbers;
    }

    public boolean emailIsItUsed(String email) {
        boolean result = true;
        if (getAllEmails().contains(email)) {
            result = false;
        }
        return result;
    }

    public boolean identificationNumberIsItUsed(String identificationNumber) {
        boolean result = true;
        if (getAllIdentificationNumber().contains(identificationNumber)) {
            result = false;
        }
        return result;
    }

    @Override
    public Result delete(Candidate candidate) {
        this.candidateDao.delete(candidate);
        return new SuccessResult("Deletion is successful");
    }

}