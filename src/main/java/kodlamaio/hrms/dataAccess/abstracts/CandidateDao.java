package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    List<Candidate> findByEmailEquals(String email);
    List<Candidate>findByIdentificationNumberEquals(String id);

    Candidate findById(int id);

}
