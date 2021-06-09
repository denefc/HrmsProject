package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvPhoto;
import org.springframework.web.multipart.MultipartFile;

public interface CvPhotoService {
    Result add(int cvId,CvPhoto cvPhoto);
    Result photoAdd(int cvId,CvPhoto cvPhoto, MultipartFile file);
}
