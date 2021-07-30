package demo;

import org.springframework.stereotype.Component;

@Component
public class InjectedByConstructorService {
    private HelloSpringService helloSpringService;

    public InjectedByConstructorService(HelloSpringService helloSpringService) {
        this.helloSpringService = helloSpringService;
    }

    public void getMessage() {
        helloSpringService.sayHello();
    }
}
