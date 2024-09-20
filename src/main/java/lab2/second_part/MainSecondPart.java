package lab2.second_part;

import java.util.List;
import java.util.Scanner;

/* Построить иерархию объектов.
Показать использование и понимание принципов инкапсуляции, наследования, полиморфизма.
В классах должны быть поля, конструкторы, методы.
Обязательным   является переопределение методов класса Object  toString(), equals(), hashCode().
Использовать абстрактные классы и интерфейсы. Собрать коллекции объектов.
21.Услуги оператора связи (собрать пакет услуг)*/
public class MainSecondPart {


    public static void main(String[] args) {
        Client client = new Client("Fedor", 50);
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        List<Service> services = Menu.getServices();

        ServicePackage servicePackage = new ServicePackage();

        int index;

        while (true){
            menu.menu();
            switch (scanner.next()) {
                case "0" -> System.exit(0);
                case "1" -> menu.allServices();
                case "2" -> {
                    menu.showAllAddServices();
                    index = scanner.nextInt() - 1;
                    servicePackage.addService(services.get(index));
                }
                case "3" -> servicePackage.pay(client);
                case "4" -> client.showBalance();
                case "5" -> client.addBalance(scanner);
                case "6" -> servicePackage.showAddedService();
                default -> System.out.println("Вы неверно ввели значение [0-6]");
            }
        }

    }
}
