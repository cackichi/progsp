package lab3.first_part;

public class Cartoon extends Film{
    private String artist = "Неизвестный художник";
    private String style = "Стандартный стиль";

    public Cartoon(String director, String duration, String audience, String artist, String style) {
        super(director, duration, audience);
        this.artist = artist;
        this.style = style;
    }

    public Cartoon(String director, String artist) {
        super(director);
        this.artist = artist;
    }

    public Cartoon(){
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public void description() {
        System.out.println("Режисер мультика - " + getDirector() + ", художник - "
                + artist + ", мультик в стиле - " + style);
    }
}
