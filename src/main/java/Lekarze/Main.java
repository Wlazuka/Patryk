package Lekarze;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String LEKARZE = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Lekarze/Pliki/lekarze.txt";
    private static final String PACJENCI = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Lekarze/Pliki/pacjenci.txt";
    private static final String WIZYTY = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Lekarze/Pliki/wizyty.txt";

    public static void main(String[] args) throws FileNotFoundException {

        List<Lekarz> listaLekarzy = Utils.getListOfDoctors(LEKARZE);
        listaLekarzy.subList(0,10).forEach(System.out::println);

        List<Pacjent> listaPacjentow = Utils.getListOfPatients(PACJENCI);
        listaPacjentow.subList(0,10).forEach(System.out::println);

        List<Wizyta> wizyty = Utils.createListOfVisits(WIZYTY, listaLekarzy, listaPacjentow);
        wizyty.subList(0,10).forEach(System.out::println);

//        String specjalizacja = listaLekarzy.get(0).getSpecjalnosc();
//
//        String szukanaSpecjalizacja = "neurolog";
//        List<Lekarz> neurolodzy = listaLekarzy.stream().filter(lekarz -> lekarz.getSpecjalnosc().equals(szukanaSpecjalizacja)).collect(Collectors.toList());

    }

//    Zadanie 1: Znajdź lekarza, który miał najwięcej wizyt
//        task1();

//    Zadanie 2: Która specjalizacja cieszy się największym powodzeniem?
//        task2();

//    Zadanie 3: Którego roku było najwięcej wizyt?
//        task3();

//    Zadanie 4: Wypisz top 5 najstarszych lekarzy
//        task4();

//    Zadanie 5: Zwróć pacjentów, którzy byli u minimum 5ciu różnych lekarzy
//        task5();

//    Zadanie 6: Zwrot lekarzy exclusive - czyli takich, którzy przyjmowali tylko jednego pacjenta
//        task6();

    private static void task1() {

    }

    private static void task2() {
    }

    private static void task3() {
    }

    private static void task4() {
    }

    private static void task5() {
    }


    private static void task6() {
    }

    private static void task7() {

    }
}
