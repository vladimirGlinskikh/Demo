package demo.kz.zhelezyaka.controllers;

import demo.kz.zhelezyaka.services.HelloSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    private HelloSpringService helloSpringService;

    @Autowired
    public void setHelloSpringService(HelloSpringService helloSpringService) {
        this.helloSpringService = helloSpringService;
    }

    public String sayHello() {
        String greeting = helloSpringService.getGreeting();
        System.out.println(greeting);
        return greeting;
    }
}
