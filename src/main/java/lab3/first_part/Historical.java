package lab3.first_part;

public class Historical extends Film{
    private String historicalPeriod = "Средневековье";
    private String degreeOfConformity = "Высокая";

    public Historical(String director, String duration, String audience, String historicalPeriod, String degreeOfConformity) {
        super(director, duration, audience);
        this.historicalPeriod = historicalPeriod;
        this.degreeOfConformity = degreeOfConformity;
    }

    public Historical(String director, String historicalPeriod) {
        super(director);
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
        System.out.println("Режисер исторического фильма - " + getDirector() + " о " +
                historicalPeriod + " c " + degreeOfConformity + " степенью достоврености."
                + " Время продолжительности - " + getDuration() + " .");
    }
}
