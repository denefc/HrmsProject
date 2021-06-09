package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;

import java.util.List;

public interface CvService {

    Result add(int candidateId,Cv cv);

    DataResult<List<Cv>>getAllCvsByCandidateId(int candidateId);
}
