package lab3.second_part;

public class Historical implements Film, FilmObject {

    private String director = "Неизвестный режисер";
    private String  duration = "1 час 30 минут";
    private String audience = "Генеральный зал";
    private String historicalPeriod = "Средневековье";
    private String degreeOfConformity = "Высокая";

    public Historical(String director, String duration, String audience, String historicalPeriod, String degreeOfConformity) {
        this.director = director;
        this.duration = duration;
        this.audience = audience;
        this.historicalPeriod = historicalPeriod;
        this.degreeOfConformity = degreeOfConformity;
    }

    public Historical(String director, String historicalPeriod) {
        this.director = director;
        this.historicalPeriod = historicalPeriod;
    }

    public Historical() {
    }

    public String getHistoricalPeriod() {
        return historicalPeriod;
    }

    public void setHistoricalPeriod(String historicalPeriod) {
        this.historicalPeriod = historicalPeriod;
    }

    public String getDegreeOfConformity() {
        return degreeOfConformity;
    }

    public void setDegreeOfConformity(String degreeOfConformity) {
        this.degreeOfConformity = degreeOfConformity;
    }

    @Override
    public void description() {
        System.out.println("Режисер исторического фильма - " + director + " о " +
                historicalPeriod + " c " + degreeOfConformity + " степенью достоврености."
                + " Время продолжительности - " + duration);
    }

    @Override
    public void print() {
        System.out.println("Это исторический фильм");
    }
}
