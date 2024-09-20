package lab3.second_part;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class WriterInfo {
    private static List<Film> films = new ArrayList<>();

    static {
        films.add(new PuppetCartoon("Джон Лассетер", "1 час 30 минут", "Детский", "Том Хэнкс", "3D Анимация"));
        films.add(new PuppetCartoon());
        films.add(new HandDrawnCartoon("Тим Бёртон", "Джонни Депп"));
        films.add(new HandDrawnCartoon());


        films.add(new Musical("Стивен Спилберг", "2 часа 15 минут", "Для всех", "Пианино", 15));
        films.add(new Musical("Дэмьен Шазелл", "Барабаны"));

        films.add(new Historical("Ридли Скотт", "2 часа 30 минут", "Для взрослых", "Римская империя", "Высокая"));
        films.add(new Historical("Мел Гибсон",  "Средневековый период"));
    }
    public void showInfo(){
        films.forEach(film -> {
            if (film instanceof FilmObject) {
                ((FilmObject) film).print();
            }
        });
        films.forEach(Film::description);
    }
}
