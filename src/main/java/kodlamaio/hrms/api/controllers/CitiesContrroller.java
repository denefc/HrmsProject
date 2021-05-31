package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesContrroller {

    private CityService cityService;

    @Autowired
    public CitiesContrroller(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public DataResult<List<City>> getAll(){
        return cityService.getAll();
    }


}
