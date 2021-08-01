package demo.kz.zhelezyaka.controllers;

import demo.kz.zhelezyaka.services.HelloSpringService;

public class GreetingController {
    private HelloSpringService helloSpringService;
    private HelloSpringService helloSpringServiceRussian;
    private HelloSpringService helloSpringServiceEstonian;
    private HelloSpringService helloSpringServiceKazakhstan;
    private HelloSpringService helloSpringServiceEnglish;


    public void setHelloSpringService(HelloSpringService helloSpringService) {
        this.helloSpringService = helloSpringService;
    }

    public void setHelloSpringServiceRussian(HelloSpringService helloSpringServiceRussian) {
        this.helloSpringServiceRussian = helloSpringServiceRussian;
    }

    public void setHelloSpringServiceEstonian(HelloSpringService helloSpringServiceEstonian) {
        this.helloSpringServiceEstonian = helloSpringServiceEstonian;
    }

    public void setHelloSpringServiceKazakhstan(HelloSpringService helloSpringServiceKazakhstan){
        this.helloSpringServiceKazakhstan = helloSpringServiceKazakhstan;
    }

    public void setHelloSpringServiceEnglish(HelloSpringService helloSpringServiceEnglish){
        this.helloSpringServiceEnglish = helloSpringServiceEnglish;
    }

    public String sayHello() {
        String greeting = helloSpringService.getGreeting();
        System.out.println(greeting);
        System.out.println(helloSpringServiceRussian.getGreeting());
        System.out.println(helloSpringServiceEstonian.getGreeting());
        System.out.println(helloSpringServiceKazakhstan.getGreeting());
        System.out.println(helloSpringServiceEnglish.getGreeting());
        return greeting;
    }
}
