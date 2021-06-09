package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvPhotoDao extends JpaRepository<CvPhoto,Integer> {


}
