package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployerManager implements EmployerService{
    private EmployerDao employerDao;
    private EmailSendService emailSendService;

    public EmployerManager(EmployerDao employerDao, EmailSendService emailSendService) {
        this.employerDao = employerDao;
        this.emailSendService = emailSendService;
    }



    @Override
    public Result register(Employer employer) {
        Result result=new ErrorResult("Kayıt başarısız Daha önce kayıtlı email");
        if(!emailIsUsed(employer.getEmail())) {
            emailSendService.emailSend(employer.getEmail());
            employer.setVerificationStatus(false); //default
            this.employerDao.save(employer);
            result = new SuccessResult("Kayıt Başarılı!");
        }
        return result;
    }



    @Override
    public List<Employer> getAll() {
        return employerDao.findAll();
    }


    public boolean emailIsUsed(String email){
        //liste boş dönerse kullanılmamıştır
        List<Employer>employersEmails=employerDao.findByEmailEquals(email);
        if (employersEmails.size()==0){
            return false;
        }
        return true;
    }
}
