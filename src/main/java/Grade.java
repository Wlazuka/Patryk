import java.util.Date;

public class Grade {

    private final int idOfStudent;
    private final int grade;
    private final Date date;
    private final int idOfSubject;

    public Grade(int idOfStudent, int grade, Date date, int idOfSubject) {
        this.idOfStudent = idOfStudent;
        this.grade = grade;
        this.date = date;
        this.idOfSubject = idOfSubject;
    }

    public int getGrade() {
        return grade;
    }

    public String getDate() {
        return date.toString().split(" ")[5];
    }

    public int getIdOfStudent() {
        return idOfStudent;
    }

    public int getIdOfSubject() {
        return idOfSubject;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "idOfStudent=" + idOfStudent +
                ", grade=" + grade +
                ", date=" + date +
                ", idOfSubject=" + idOfSubject +
                '}';
    }
}
