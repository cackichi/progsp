package lab2;

import java.util.Arrays;

public class Icecream {
    private String name;
    private boolean isInStockedChocolate;
    private double percentFatContent;


    public Icecream(String name, boolean isInStockedChocolate, double percentFatContent) {
        this.name = name;
        this.isInStockedChocolate = isInStockedChocolate;
        this.percentFatContent = percentFatContent;
    }
    public Icecream(String name, double percentFatContent) {
        this.name = name;
        this.percentFatContent = percentFatContent;
        this.isInStockedChocolate = true;
    }

    public Icecream(String name) {
        this.name = name;
        this.percentFatContent = 0;
        this.isInStockedChocolate = true;
    }

    public Icecream(){
        this.name = "Пломбир";
        this.percentFatContent = 0;
        this.isInStockedChocolate = true;
    }



    @Override
    public String toString() {
        String s = (isInStockedChocolate)?"есть":"нет";
        return "Мороженное: " + name + "\n" +
                "Есть в наличии: " + s + "\n" +
                "Процент жирности: " + percentFatContent*100 + "%" + "\n";
    }

    public boolean isInStockedChocolate() {
        return isInStockedChocolate;
    }

    public double getPercentFatContent() {
        return percentFatContent;
    }

    public String getName() {
        return name;
    }

    public void showInfo(){
        System.out.println(this);
    }

    public static double avgFatContent(Icecream[] icecreams){
        double avg = Arrays.stream(icecreams).mapToDouble(Icecream::getPercentFatContent).sum();
        return avg/=icecreams.length;
    }

    public static int amountOfChocolateIcecream(Icecream[] icecreams){
        return (int) Arrays.stream(icecreams).filter(Icecream::isInStockedChocolate).count();
    }
}
