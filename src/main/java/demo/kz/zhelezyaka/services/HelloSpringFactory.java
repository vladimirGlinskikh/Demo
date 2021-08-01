package demo.kz.zhelezyaka.services;

public class HelloSpringFactory {
    public HelloSpringService createHelloSpringService(String language) {
        HelloSpringService service = null;

        switch (language) {
            case "en":
                service = new HelloSpringServiceEnglishImpl();
                break;
            case "ru":
                service = new HelloSpringServiceRussianImpl();
                break;
            case "ee":
                service = new HelloSpringServiceEstonianImpl();
                break;
            case "kz":
                service = new HelloSpringServiceKazakhstanImpl();
                break;
            default:
                new HelloSpringServiceRussianImpl();
        }
        return service;
    }
}
