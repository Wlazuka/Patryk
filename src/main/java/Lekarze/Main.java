package Lekarze;

import java.util.List;
import java.util.Set;

public class Main {

    private Clinic clinic;

    public static void main(String[] args) {

        Clinic clinic = new Clinic();

//        String specjalizacja = listaLekarzy.get(0).getSpecjalnosc();
//
//        String szukanaSpecjalizacja = "neurolog";
//        List<Lekarz> neurolodzy = listaLekarzy.stream().filter(lekarz -> lekarz.getSpecjalnosc().equals(szukanaSpecjalizacja)).collect(Collectors.toList());


//    Zadanie 1: Znajdź lekarza, który miał najwięcej wizyt
//        task1();

//    Zadanie 2: Która specjalizacja cieszy się największym powodzeniem?

//    Zadanie 3: Którego roku było najwięcej wizyt?
//        task3();

//    Zadanie 4: Wypisz top 5 najstarszych lekarzy
//        task4();

//    Zadanie 5: Zwróć pacjentów, którzy byli u minimum 5ciu różnych lekarzy
//        List<Pacjent> list = task5(clinic);
//        for (Pacjent pacjent : list){
//            System.out.println(pacjent + " " + pacjent.getLekarzeUKtorychBylPacjent());
//        }

//    Zadanie 6: Zwrot lekarzy exclusive - czyli takich, którzy przyjmowali tylko jednego pacjenta
//        List<Set<Pacjent>> list = clinic.getListaPacjentow();
//        for (Set<Pacjent> set : list){
//            System.out.println(set.toString());
//        }

        List<Lekarz> list2 = task6(clinic);
        for (Lekarz lekarz : list2) {
            System.out.println(lekarz + " " + lekarz.getUniquePatients());
        }
    }

    private static void task1() {

    }

    public static void task2() {

//        return clinic.listOfMostPopularSpecialisations();
    }

    private static void task3() {
    }

    private static void task4() {
    }

    private static List<Pacjent> task5(Clinic clinic) {
        return clinic.getPacjentsWithXVisits(3);
    }

    private static List<Lekarz> task6(Clinic clinic) {
        return clinic.getListOfDoctorsWithOnlyXPatients(4);
    }
}
