package demo.kz.zhelezyaka.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"default", "russian"})
public class HelloSpringRussianImpl implements HelloSpringService{
    @Override
    public String getGreeting() {
        return "Привет Спринг!";
    }
}
