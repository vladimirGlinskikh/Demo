package demo.kz.zhelezyaka.config;

import demo.kz.zhelezyaka.services.HelloSpringFactory;
import demo.kz.zhelezyaka.services.HelloSpringServiceEnglishImpl;
import demo.kz.zhelezyaka.services.HelloSpringServiceRussianImpl;
import demo.kz.zhelezyaka.services.HelloSpringService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class HelloConfig {
    @Bean
    public HelloSpringFactory helloSpringFactory() {
        return new HelloSpringFactory();
    }

    @Bean
    @Profile("english")
    public HelloSpringService helloSpringServiceEnglish(HelloSpringFactory factory) {
        return factory.createHelloSpringService("en");
    }

    @Bean
    @Profile({"russian", "default"})
    public HelloSpringService helloSpringServiceRussian(HelloSpringFactory factory) {
        return factory.createHelloSpringService("ru");
    }

    @Bean
    @Profile("estonian")
    public HelloSpringService helloSpringServiceEstonian(HelloSpringFactory factory) {
        return factory.createHelloSpringService("ee");
    }

    @Bean
    @Profile("kazakhstan")
    public HelloSpringService helloSpringServiceKazakhstan(HelloSpringFactory factory) {
        return factory.createHelloSpringService("kz");
    }
}
