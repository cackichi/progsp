package lab2.second_part;

public class MobileService extends Service {

    public MobileService(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void activateService() {
        System.out.println("Вы активировали мобильный сервис: " + this.getName());
    }
}
