package lab7;

public class Student {
    private long id;
    private String name;
    private String surname;
    private String faculty;
    private int yearOfStudy;
    private long groupNumber;

    public Student() {
    }

    public Student(long id, String name, String surname, String faculty, int yearOfStudy, long groupNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.groupNumber = groupNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public long getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(long groupNumber) {
        this.groupNumber = groupNumber;
    }
}
