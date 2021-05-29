package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employer")
public class EmployersController{

    @Autowired
    private EmployerService employerService;

    @GetMapping("/getall")
    public List<Employer> getAll(){
        return employerService.getAll();
    }

    @PostMapping("/register")
    public Result add(@RequestBody Employer employer){
        return employerService.register(employer);
    }
}
