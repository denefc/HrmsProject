package kodlamaio.hrms.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.utilities.ImageUploadService;
import kodlamaio.hrms.core.utilities.helpers.imageHelper.cloudinary.CloudinaryImageManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfiguration {

    public Environment environment;

    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dene",
                "api_key", "258779614355429",
                "api_secret", "NzXu7bjB7Oxn7MlraSJ9eejAmpo"));
    }

    @Bean
    public ImageUploadService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }
}
