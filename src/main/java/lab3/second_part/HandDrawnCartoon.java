package lab3.second_part;

public class HandDrawnCartoon extends Cartoon{
    public HandDrawnCartoon(String director, String artist) {
        super(director, artist);
    }

    public HandDrawnCartoon(String director, String duration, String audience, String artist, String style) {
        super(director, duration, audience, artist, style);
    }

    public HandDrawnCartoon() {
    }

    @Override
    public void description() {
        System.out.println("Режисер мультика - " + getDirector() + ", художник - "
                + getArtist() + ", мультик в стиле - Рисованый");
    }

    @Override
    public void print() {
        System.out.println("Это рисованый мультфильм" + getDirector());
    }
}
