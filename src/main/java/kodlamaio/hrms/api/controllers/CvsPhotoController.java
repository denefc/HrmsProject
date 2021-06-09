package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvPhotoService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/photos")
public class CvsPhotoController {

    private CvPhotoService cvPhotoService;

    @Autowired
    public CvsPhotoController(CvPhotoService cvPhotoService) {
        this.cvPhotoService = cvPhotoService;
    }

    @PostMapping("/add")
    public Result add(@RequestParam int cvId, @RequestBody MultipartFile file, @RequestBody CvPhoto cvPhoto){
        return cvPhotoService.photoAdd(cvId,cvPhoto,file);
    }
}
