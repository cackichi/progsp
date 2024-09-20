package lab3.second_part;

public abstract class Cartoon implements Film, FilmObject {
    private String director = "Неизвестный режисер";
    private String  duration = "1 час 30 минут";
    private String audience = "Генеральный зал";
    private String artist = "Неизвестный художник";
    private String style = "Стандартный стиль";

    public Cartoon(String director, String artist) {
        this.director = director;
        this.artist = artist;
    }

    public Cartoon(String director, String duration, String audience, String artist, String style) {
        this.director = director;
        this.duration = duration;
        this.audience = audience;
        this.artist = artist;
        this.style = style;
    }

    public Cartoon(){
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
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
}
