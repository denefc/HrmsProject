package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @PostMapping("/add")
    public Result add(@RequestParam int cvId, @RequestBody JobExperience jobExperience){
        return jobExperienceService.add(cvId,jobExperience);
    }
}
