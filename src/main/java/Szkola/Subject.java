package Szkola;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private final int id;
    private final String name;
    private final String teacherLastName;
    private final String teacherName;
    private List<Grade> grades;

    Subject(int id, String name, String teacherLastName, String teacherName) {
        this.id = id;
        this.name = name;
        this.teacherLastName = teacherLastName;
        this.teacherName = teacherName;
        this.grades = new ArrayList<>();
    }

    public List<Grade> getGrades() {
        return this.grades;
    }

    public void assignGrade(Grade ocena) {
        this.grades.add(ocena);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "idPrzedmiotu=" + id +
                ", nazwaPrzedmiotu='" + name + '\'' +
                ", nazwiskoNauczyciela='" + teacherLastName + '\'' +
                ", imieNauczyciela='" + teacherName + '\'' +
                '}';
    }

}
