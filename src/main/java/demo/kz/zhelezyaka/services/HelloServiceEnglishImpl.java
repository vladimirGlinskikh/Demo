package demo.kz.zhelezyaka.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("english")
public class HelloServiceEnglishImpl implements HelloSpringService {

    @Override
    public String getGreeting() {
        return "Hello Spring!";
    }
}
