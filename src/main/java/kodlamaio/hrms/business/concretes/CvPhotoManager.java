package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvPhotoService;
import kodlamaio.hrms.core.utilities.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.CvPhotoDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.CvPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Map;

@Service
public class CvPhotoManager implements CvPhotoService {

    private CvPhotoDao cvPhotoDao;
    private CvDao cvDao;
    private ImageUploadService imageUploadService;


    @Autowired
    public CvPhotoManager(CvPhotoDao cvPhotoDao, CvDao cvDao, ImageUploadService imageUploadService) {
        this.cvPhotoDao = cvPhotoDao;
        this.cvDao = cvDao;
        this.imageUploadService = imageUploadService;
    }

    @Override
    public Result add(int cvId, CvPhoto cvPhoto) {
        Cv cv=cvDao.findById(cvId);
        if (cv==null){
            return new ErrorResult("Lütfen geçerli cv idsi giriniz");
        }
        cv.setCvPhoto(cvPhoto);
        cvPhoto.setCv(cv);
        cvPhoto.setUploadedDate(LocalDate.now());
        cvPhotoDao.save(cvPhoto);

        return new SuccessResult("Foto başarıyla eklendi");
    }

    @Override
    public Result photoAdd(int cvId,CvPhoto cvPhoto, MultipartFile file) {
        Map<String,String> result = (Map<String,String>) this.imageUploadService.save(file).getData();

        String url = result.get("url");

        cvPhoto.setPhotoLink(url);
        cvPhoto.setUploadedDate(LocalDate.now());

        return add(cvId,cvPhoto);
    }
}
