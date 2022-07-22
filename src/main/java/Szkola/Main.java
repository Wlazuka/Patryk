package Szkola;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        School school = new School();
        school.run();

//    Zadanie 1: Podaj ilość uczniów mieszkających poza szkołą. Na ulicach Sportowa i Wroncela
//        task1(school);

//    Zadanie 2: Wypisz oceny ucznia z przedmiotu: Jan Augustyniak, język polski
//        task2(school);

//    Zadanie 3: wypisz uczniów z klasy 3a
//        task3(school);

//    Zadanie 4: Oblicz ile dziewcząt i chłopców jest w poszczególnych klasach (Przedstaw wynik w postaci: id klasy, liczba dziewcząt, liczba chłopców)
//        task4(school);

//    Zadanie 5: Utwórz zestawienie dla klasy 2a zawierające zestawienie przedmiotów i średnie ocen klasy z tych przedmiotów (zaokrąglenie do dwóch miejsc po przecinku)
//               Zestawienie posortuj nierosnąco według średnich ocen.
//        task5(school);

//    Zadanie 6: Utwórz zestawienie uporzadkowane alfabetycznie według nazwisk zawierające wykaz osób z klasy 2c, które w kwietniu 2009 roku otrzymały oceny niedostateczne (imię, nazwisko, przedmiot)
        task6(school);

//    Zadanie 7: Podaj imię, nazwisko, klasę oraz średnią ocen osoby która osiągnęła nawyższą śrenią ocen w całej szkole (jest tylko jedna taka osoba)
//        task7(school);
}

    private static List<Student> task1(School school) {
        return school.getStudentsFromStreets("Sportowa", "Wroncela");
    }

    private static List<Grade> task2(School school) {
        Student uczen = school.getStudentByNameAndLastName("Jan", "Augustyniak");
        return uczen.getGradesFromSubject("polski");
    }

    private static List<Student> task3(School school) {
        return school.getStudentsFromSchoolClass("3a");
    }

    private static void task4(School school) {
        Map<String, List<Student>> classesInSchool = school.getClassesInSchool();
        for (List<Student> lista : classesInSchool.values()) {
            long sumOfBoys = lista.stream().filter(Student::isABoy).count();
            long sumOfGirls = lista.size() - sumOfBoys;
        }
    }

    private static void task5(School school) {
    }


    private static void task6(School school) {
        school.task6();
    }

    private static void task7(School school) {
        Student bestStudent = school.getStudentWithHighestAverage();
        String stringBuilder = "Imię: " + bestStudent.getName() + "\n" +
                "Nazwisko: " + bestStudent.getLastName() + "\n" +
                "Klasa: " + bestStudent.getSchoolClassId() + "\n" +
                "Średnia: " + bestStudent.calculateAverage();
        System.out.println(stringBuilder);
    }
}
