package lab2.second_part;

public class TVService extends Service{
    public TVService(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void activateService() {
        System.out.println("Вы активировали телевизионный сервис: " + this.getName());
    }
}
