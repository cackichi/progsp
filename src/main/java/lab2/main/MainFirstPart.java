package lab2.main;


import lab2.Icecream;

import java.util.Arrays;

public class MainFirstPart {

    public static void main(String[] args) {
        Icecream[] icecreams = new Icecream[4];
        icecreams[0] = new Icecream();
        icecreams[1] = new Icecream("Ванильное");
        icecreams[2] = new Icecream("В рожке", 0.54);
        icecreams[3] = new Icecream("В стаканчике", false, 0.4d);

        Arrays.stream(icecreams).forEach(Icecream::showInfo);
        System.out.println("-------------------------------------------------");
        System.out.println("Средний процент жирности всего мороженого: " + Icecream.avgFatContent(icecreams) * 100 + "%");
        System.out.println("Количество мороженого с шоколадом: " + Icecream.amountOfChocolateIcecream(icecreams));
    }
}