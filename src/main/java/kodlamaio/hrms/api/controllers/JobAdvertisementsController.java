package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdverts")
@CrossOrigin

public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

   @PostMapping("/jobAdd")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll(){
        return jobAdvertisementService.getAll();
    }
    @GetMapping("/getAllSorted")
    public DataResult<List<JobAdvertisement>> getAllSorted(){
        return jobAdvertisementService.getAllSorted();
    }
    @GetMapping("/getByCompanyName")
    public DataResult<List<JobAdvertisement>> getAllThatCompany(@RequestParam String  companyName){
      return   jobAdvertisementService.getAllFromThatCompanyName(companyName);
    }

}
