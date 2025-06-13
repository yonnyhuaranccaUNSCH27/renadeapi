package ipd.renade.renadeapi.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dxakewqma",
                "api_key", "851135962893168",
                "api_secret", "ej-Hw2Qxtxl-90Df8mhmRZP9N-4"
        ));
    }
}
