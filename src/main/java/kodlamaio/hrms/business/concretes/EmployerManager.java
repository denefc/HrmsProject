package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployerManager implements EmployerService{
    private EmployerDao employerDao;
    private EmailSendService emailSendService;
    private List<String> emails = new ArrayList<>();

    public EmployerManager(EmployerDao employerDao, EmailSendService emailSendService) {
        this.employerDao = employerDao;
        this.emailSendService = emailSendService;
    }

    @Override
    public Result login(String email, String password) {
        Result result= new ErrorResult("Giriş Başarısız!");
        for (int i = 0; i < getAll().size(); i++) {
            if(getAll().get(i).getEmail().equals(email) && getAll().get(i).getPassword().equals(password)) {
                result = new SuccessResult("Giriş Başarılı!");
            }
        }
        return result;
    }

    @Override
    public Result register(Employer employer) {
        Result result=new Result(false);
        if(emailUsedCheck(employer.getEmail())) {
            emailSendService.emailSend(employer.getEmail());
            employer.setVerificationStatus(false); //default
            this.employerDao.save(employer);
            result = new SuccessResult("Kayıt Başarılı!");
        }
        return result;
    }

    @Override
    public Result delete(Employer employer) {
        return null;
    }

    @Override
    public List<Employer> getAll() {
        return employerDao.findAll();
    }

    @Override
    public List<String> getAllEmails() {
        for (int i = 0; i < getAll().size(); i++) {
            emails.add(getAll().get(i).getEmail());
        }
        return emails;
    }

    public boolean emailUsedCheck(String email){
      List<String>getEmails=getAllEmails();
      boolean resultFlag=true;
      for (String getEmail:getEmails){
          if (getEmail.equals(email)){
              resultFlag=false;
          }
      }
      return resultFlag;
    }
}
