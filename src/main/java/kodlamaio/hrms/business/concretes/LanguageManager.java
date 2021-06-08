package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;
    private CvDao cvDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao, CvDao cvDao) {
        this.languageDao = languageDao;
        this.cvDao = cvDao;
    }

    @Override
    public Result add(int cvId, Language language) {
        Cv cv=cvDao.findById(cvId);
        if (cv==null){
            return new ErrorResult("Lütfen doğru bir cv idsi giriniz");
        }
        cv.getLanguage().add(language);
        language.setCv(cv);
        languageDao.save(language);
        return new SuccessResult("Başarıyla eklendi");

    }
}
