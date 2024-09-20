package lab2;

public class WriterInfo {
    public static void showFullInfoIcecream(Icecream icecream){
        System.out.println(icecream);
    }

    public static void showStokedInfoIcecream(Icecream icecream){
        String s = (icecream.isInStockedChocolate())?"есть":"нет";
        System.out.println("Мороженное " + icecream.getName() + " есть в наличии: " + s);
    }
}
