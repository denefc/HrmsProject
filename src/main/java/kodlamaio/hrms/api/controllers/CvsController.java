package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {

    private CvService cvService;

    @Autowired
    public CvsController(CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("/add")
    public Result add(@RequestParam int candidateId,@RequestBody Cv cv){
   return cvService.add(candidateId,cv);
    }

    @GetMapping("/getAllCvsFromCandidate")
    public DataResult<List<Cv>> add(@RequestParam int candidateId){ //burda sanırım cvdto dönmeliyim ileride değişirim
       return cvService.getAllCvsByCandidateId(candidateId);
    }
}
