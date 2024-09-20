package lab3.first_part;

public abstract class Film {
    private String director = "Неизвестный режисер";
    private String  duration = "1 час 30 минут";
    private String audience = "Генеральный зал";

    public abstract void description();

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String  getDuration() {
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

    public Film(String director, String duration, String audience) {
        this.director = director;
        this.duration = duration;
        this.audience = audience;
    }



    public Film(String director) {
        this.director = director;
    }

    public Film() {
    }
}
