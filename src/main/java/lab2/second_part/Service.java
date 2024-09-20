package lab2.second_part;

import java.util.Objects;

abstract public class Service{
    private String name;
    private double price;
    private String description;

    public abstract void activateService();

    public Service(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Услуга: " + name + "\n" +
                "стоимость: " + price + "\n" +
                "описание: " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Double.compare(price, service.price) == 0 && Objects.equals(name, service.name) && Objects.equals(description, service.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description);
    }
}
