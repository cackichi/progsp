package lab2.second_part;

import java.util.ArrayList;
import java.util.List;

public class ServicePackage implements Payment{
    private List<Service> services = new ArrayList<>();
    private double totalPrice = 0;

    @Override
    public void pay(Client client) {
        double balance = client.getBalance();
        if(balance >= totalPrice){
            client.setBalance(balance - totalPrice);
            services.forEach(Service::activateService);
            clearServices();
        } else System.out.println("У вас недостаточно средств, нужно - " + totalPrice + "; а у вас - " + balance);
    }

    public void addService(Service service){
        boolean isAnyMatch = false;
        if(services != null) {
            isAnyMatch = services.stream().anyMatch(a -> a.getClass().equals(service.getClass()));
        }

        if(!isAnyMatch) {
            services.add(service);
            totalPrice += service.getPrice();
        } else System.out.println("Вы больше не можете добавить услуну данного типа");
    }

    public void clearServices(){
        services.removeAll(this.getServices());
    }

    public void removeService(int index){
        services.remove(index);
    }

    public void showAddedService(){
        if (!services.isEmpty()) {
            services.forEach(System.out::println);
        } else {
            System.out.println("Вы ничего еще не добавили");
        }

    }

    public List<Service> getServices() {
        return services;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
