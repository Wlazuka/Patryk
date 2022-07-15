import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    protected Utils() {
    }

    private static List<String> readTxtFile(String filePath) {
        List<String> allLines = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        allLines.remove(0);
        return allLines;
    }

    private static Student createStudent(String line) {
        String[] data = line.split(";");
        int id = Integer.parseInt(data[0]);
        String lastName = data[1];
        String name = data[2];
        String street = data[3];
        int houseNumber = Integer.parseInt(data[4]);
        Address adres = new Address(street, houseNumber);
        String idSchoolClass = data[5];
        return new Student(id, lastName, name, adres, idSchoolClass);
    }

    public static Student createStudentRegex(String line) {
        Pattern pattern = Pattern.compile("(\\d*).([A-Za-z]*).([a-zA-Z]*).([a-zA-Z]*).(\\d*).(\\d\\D)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            int id = Integer.parseInt(matcher.group(1));
            String lastName = matcher.group(2);
            String name = matcher.group(3);
            String street = matcher.group(4);
            int houseNumber = Integer.parseInt(matcher.group(5));
            Address adres = new Address(street, houseNumber);
            String idSchoolClass = matcher.group(6);
            return new Student(id, lastName, name, adres, idSchoolClass);
        }
        return null;
    }

    public static List<Student> getListOfStudents(String filePath) {
        List<Student> subjects = new ArrayList<>();
        for (String line : readTxtFile(filePath)) {
            Student uczen = createStudent(line);
            subjects.add(uczen);
        }
        return subjects;
    }

    private static Subject createSubject(String line){
        String[] data = line.split(";");
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        String teacherLastName = data[2];
        String teacherName = data[3];
        return new Subject(id, name, teacherLastName, teacherName);
    }

    public static List<Subject> getListOfSubjects(String filePath){
        List<Subject> subjects = new ArrayList<>();
        for (String line : readTxtFile(filePath)){
            Subject subject = createSubject(line);
            subjects.add(subject);
        }
        return subjects;
    }

    private static Grade createGrade(String line) {
        String[] data = line.split(";");
        int idOfStudent = Integer.parseInt(data[0]);
        int grade = Integer.parseInt(data[1]);
        Date date = new Date();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            date = formatter.parse(data[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int idOfSubject = Integer.parseInt(data[3]);
        return new Grade(idOfStudent, grade, date, idOfSubject);
    }

    public static List<Grade> getListOfGrades(String filePath) {
        List<Grade> grades = new ArrayList<>();
        for (String line : readTxtFile(filePath)) {
            Grade ocena = createGrade(line);
            grades.add(ocena);
        }
        return grades;
    }
}
