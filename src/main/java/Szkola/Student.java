package Szkola;

import java.util.List;

public class Student {

    private static final String SUBJECTS = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Szkola.Pliki/przedmioty.txt";
    private final int id;
    private final String lastName;
    private final String name;
    private final Address address;
    private final String schoolClassId;
    private final List<Subject> listOfSubjects;

    public Student(int id, String lastName, String name, Address address, String schoolClassId) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.address = address;
        this.schoolClassId = schoolClassId;
        this.listOfSubjects = Utils.getListOfSubjects(SUBJECTS);
    }

    public void assignGrade(Grade grade) {
        Subject subject = listOfSubjects.stream().filter(sub -> sub.getId() == grade.getIdOfSubject()).findFirst().get();
        subject.assignGrade(grade);
    }

    public List<Grade> getGradesFromSubject(String subjectName){
        Subject subject = listOfSubjects.stream().filter(sub -> sub.getName().equals(subjectName)).findFirst().get();
        return subject.getGrades();
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getSchoolClassId() {
        return schoolClassId;
    }

    public List<Subject> getListOfSubjects() {
        return listOfSubjects;
    }

    public boolean isABoy(){
        return !this.getName().endsWith("a");
    }

    public float calculateAverage() {
        return (float) listOfSubjects
                .stream()
                .map(Subject::getGrades)
                .flatMap(List::stream)
                .mapToDouble(Grade::getGrade)
                .average()
                .getAsDouble();
    }

    @Override
    public String toString() {

        String gender = this.isABoy() ? " boy " : " girl ";

        return "Szkola.Student {" +
                "id = " + id +
                ", last name = '" + lastName + '\'' +
                ", name = '" + name + '\'' +
                ", schoolClassId = '" + schoolClassId + '\'' +
                gender  + '\'' +
                '}';
    }
}
