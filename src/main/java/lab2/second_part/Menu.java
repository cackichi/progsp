package lab2.second_part;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static List<Service> services = new ArrayList<>();

    static {
        services.add(new InternetService("100Мбит/c", 25, "Интернет со скоростью 100Мбит/c"));
        services.add(new MobileService("30 минут", 13, "30 минут во все сети"));
        services.add(new MobileService("60 минут", 25, "60 минут во все сети"));
        services.add(new TVService("Zala", 10, "Интернет со скоростью 100Мбит/c"));
        services.add(new InternetService("10Мбит/c", 5, "Интернет со скоростью 10Мбит/c"));
    }

    public static List<Service> getServices() {
        return services;
    }

    public void showAllAddServices(){
        services.forEach(a -> System.out.println((services.indexOf(a) + 1) + " - " + a));
        System.out.println("Выберите что именно хотите добавить");
    }

    public void menu(){
        System.out.println("1 - Список услуг\n2 - Добавить услугу\n" +
                "3 - Оплатить\n4 - Проверить баланс\n" +
                "5 - Пополнить баланс\n6 - Просмотреть добавленные услугу\n0 - Выход");
    }

    public void allServices(){
        services.forEach(System.out::println);
    }
}
