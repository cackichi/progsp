package lab3.second_part;

public class PuppetCartoon extends Cartoon{
    public PuppetCartoon(String director, String artist) {
        super(director, artist);
    }

    public PuppetCartoon(String director, String duration, String audience, String artist, String style) {
        super(director, duration, audience, artist, style);
    }

    public PuppetCartoon() {
    }

    @Override
    public void description() {
        System.out.println("Режисер мультика - " + getDirector() + ", художник - "
                + getArtist() + ", мультик в стиле - Куклы");
    }

    @Override
    public void print() {
        System.out.println("Это кукольный мультфильм");
    }
}
