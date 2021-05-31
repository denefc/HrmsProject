package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/jobseekers")
public class CandidateController {

    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public List<Candidate> getAll(){
        return this.candidateService.getAll();
    }
    @PostMapping("/register")
    public Result add(@RequestBody Candidate candidate) {
        return this.candidateService.register(candidate);
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestBody Candidate candidate) {
        return this.candidateService.delete(candidate);

    }
}