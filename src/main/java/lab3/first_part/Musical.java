package lab3.first_part;

public class Musical extends Film {
    private String musicalInstrument = "Пианино";
    private int amountOfSongs = 10;

    public Musical(String director, String  duration, String audience, String musicalInstrument, int amountOfSongs) {
        super(director, duration, audience);
        this.musicalInstrument = musicalInstrument;
        this.amountOfSongs = amountOfSongs;
    }

    public Musical(String director, String musicalInstrument) {
        super(director);
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
        System.out.println("Режисер мьюзикла - " + getDirector() + " c " + amountOfSongs +
                " песнями/песней, играя на " + musicalInstrument + ". "
                + " Время продолжительности - " + getDuration());

    }
}
