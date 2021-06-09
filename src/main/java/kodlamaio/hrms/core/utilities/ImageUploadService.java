package kodlamaio.hrms.core.utilities;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {
    DataResult<?> save(MultipartFile image);
}
