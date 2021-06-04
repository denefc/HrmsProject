package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
      List<JobAdvertisement>findByIsActiveIsTrueAndEmployer_CompanyName( String companyName);
}
