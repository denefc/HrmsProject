package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/systempersonnel")
@CrossOrigin
public class SystemPersonnelsController {

    private SystemPersonnelService systemPersonnelService;

    @Autowired
    public SystemPersonnelsController(SystemPersonnelService systemPersonnelService) {

        this.systemPersonnelService = systemPersonnelService;
    }

    @GetMapping("/getall")
    public DataResult<List<SystemPersonnel>> getAll(){
        return this.systemPersonnelService.getAll();
    }

    @PostMapping("/register")
    public Result add(@RequestBody SystemPersonnel systemPersonnel) {
        return this.systemPersonnelService.register(systemPersonnel);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody SystemPersonnel systemPersonnel) {
        return this.systemPersonnelService.delete(systemPersonnel);

    }
}
