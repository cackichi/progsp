package lab3.second_part;

public class Musical implements Film, FilmObject {

    private String director = "Неизвестный режисер";
    private String  duration = "1 час 30 минут";
    private String audience = "Генеральный зал";
    private String musicalInstrument = "Пианино";
    private int amountOfSongs = 10;

    public Musical(String director, String duration, String audience, String musicalInstrument, int amountOfSongs) {
        this.director = director;
        this.duration = duration;
        this.audience = audience;
        this.musicalInstrument = musicalInstrument;
        this.amountOfSongs = amountOfSongs;
    }

    public Musical(String director, String musicalInstrument) {
        this.director = director;
        this.musicalInstrument = musicalInstrument;
    }

    public Musical() {
    }

    public String getMusicalInstrument() {
        return musicalInstrument;
    }

    public void setMusicalInstrument(String musicalInstrument) {
        this.musicalInstrument = musicalInstrument;
    }

    public int getAmountOfSongs() {
        return amountOfSongs;
    }

    public void setAmountOfSongs(int amountOfSongs) {
        this.amountOfSongs = amountOfSongs;
    }

    @Override
    public void description() {
        System.out.println("Режисер мьюзикла - " + director + " c " + amountOfSongs +
                " песнями/песней, играя на " + musicalInstrument + ". "
                + " Время продолжительности - " + duration);

    }

    @Override
    public void print() {
        System.out.println("Это мьюзикл - " + director);
    }
}
