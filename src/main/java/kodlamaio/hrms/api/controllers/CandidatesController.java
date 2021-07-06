package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll(){
        return new SuccessDataResult<List<Candidate>>(candidateService.getAll(),"Data başarıyla dönüldü");
    }
    @PostMapping("/register")
    public Result add(@RequestBody Candidate candidate) {
        return this.candidateService.register(candidate);
    }

}