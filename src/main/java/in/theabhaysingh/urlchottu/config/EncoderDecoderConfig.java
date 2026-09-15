package in.theabhaysingh.urlchottu.config;

import in.theabhaysingh.urlchottu.base62.Base62EncoderDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncoderDecoderConfig {

    @Bean
    public Base62EncoderDecoder getEncoderDecoder() {
        return new Base62EncoderDecoder();
    }
}
