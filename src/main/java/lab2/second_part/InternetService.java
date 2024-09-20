package lab2.second_part;


public class InternetService extends Service {
    public InternetService(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void activateService() {
        System.out.println("Вы активировали мобильный сервис: " + this.getName());
    }
}
