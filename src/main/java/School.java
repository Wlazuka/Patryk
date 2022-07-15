import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class School {

    private static final String STUDENTS = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Pliki/uczniowie.txt";
    private static final String GRADES = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Pliki/oceny.txt";
    private List<Grade> listOfGrades;
    private List<Student> listOfAllStudents;
    private Map<String, List<Student>> classesInSchool;

    public void run() {
        listOfGrades = Utils.getListOfGrades(GRADES);
        listOfAllStudents = Utils.getListOfStudents(STUDENTS);
        classesInSchool = populateSchoolClasses();
        assignGradesToStudents();
    }

    public List<Student> getStudentsFromStreets(String... streets) {
        return listOfAllStudents.stream().filter(student -> Arrays.asList(streets).contains(student.getAddress().getStreet())).collect(Collectors.toList());
    }

    public Student getStudentByNameAndLastName(String name, String lastName) {
        return listOfAllStudents.stream().filter(student -> student.getName().equals(name) && student.getLastName().equals(lastName)).findFirst().get();
    }

    public List<Student> getListOfAllStudents() {
        return listOfAllStudents;
    }

    public List<Grade> getListOfGrades() {
        return listOfGrades;
    }

    public Map<String, List<Student>> getClassesInSchool() {
        return classesInSchool;
    }

    public List<Student> getStudentsFromSchoolClass(String idKlasy) {
        return classesInSchool.get(idKlasy);
    }

    private void assignGradesToStudents() {
        for (Grade ocena : listOfGrades) {
            Student student = listOfAllStudents.stream().filter(u -> u.getId() == ocena.getIdOfStudent()).findFirst().get();
            student.assignGrade(ocena);
        }
    }

    private Map<String, List<Student>> populateSchoolClasses() {
        return listOfAllStudents
                .stream()
                .collect(Collectors.groupingBy(Student::getSchoolClassId));
    }

    public Student getStudentWithHighestAverage(){
        Map<Integer, Double> gradesMap = getGradesMap();
        int id = Collections.max(gradesMap.entrySet(), Comparator.comparingDouble(Map.Entry::getValue)).getKey();
        return listOfAllStudents.stream().filter(student -> student.getId() == id).findFirst().get();
    }

    private Map<Integer, Double> getGradesMap() {
        Map<Integer, List<Grade>> gradesMap = listOfGrades.stream().collect(Collectors.groupingBy(Grade::getIdOfStudent));
        Map<Integer, Double> averageMap = new HashMap<>();
        for (Entry<Integer, List<Grade>> entry : gradesMap.entrySet()) {
            double average = entry.getValue().stream().map(Grade::getGrade).mapToDouble(d -> d).average().orElse(0.0);
            Double truncatedDouble = BigDecimal.valueOf(average)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            averageMap.put(entry.getKey(), truncatedDouble);
        }
        return averageMap;
    }

    public void task6() {
        List<Student> studentsFrom2c = new ArrayList<>();
        for (Student student : getListOfAllStudents()){
            if (student.getSchoolClassId().equals("2c")){
                studentsFrom2c.add(student);
            }
        }
        Set<Student> studentsFrom2cWith1Grade = new HashSet<>();
        for (Student student : studentsFrom2c){
            for (Subject subject : student.getListOfSubjects()){
                for (Grade grade : subject.getGrades()){
                    if (grade.getGrade() == 1){
                        if (grade.getDate().equals("2009")){
                            studentsFrom2cWith1Grade.add(student);
                        }
                    }
                }
            }
        }

        System.out.println("Utwórz zestawienie uporzadkowane alfabetycznie według nazwisk zawierające wykaz osób z klasy 2c, które w kwietniu 2009 roku otrzymały oceny niedostateczne (imię, nazwisko, przedmiot)");

        studentsFrom2cWith1Grade.forEach(System.out::println);
    }
}
