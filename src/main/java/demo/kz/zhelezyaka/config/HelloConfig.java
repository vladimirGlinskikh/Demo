package demo.kz.zhelezyaka.config;

import demo.kz.zhelezyaka.services.HelloSpringServiceEnglishImpl;
import demo.kz.zhelezyaka.services.HelloSpringServiceRussianImpl;
import demo.kz.zhelezyaka.services.HelloSpringService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class HelloConfig {
    @Bean
    @Profile("english")
    public HelloSpringService helloSpringServiceEnglish() {
        return new HelloSpringServiceEnglishImpl();
    }

    @Bean
    @Profile({"russian", "default"})
    public HelloSpringService helloSpringServiceRussian() {
        return new HelloSpringServiceRussianImpl();
    }
}
