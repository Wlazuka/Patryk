package Lekarze;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Clinic {

    private static final String LEKARZE = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Lekarze/Pliki/lekarze.txt";
    private static final String PACJENCI = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Lekarze/Pliki/pacjenci.txt";
    private static final String WIZYTY = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Lekarze/Pliki/wizyty.txt";
    private static List<Lekarz> listaLekarzy;
    private static List<Pacjent> listaPacjentow;
    private static List<Wizyta> wizyty;

    public Clinic(){
        listaLekarzy = Utils.getListOfDoctors(LEKARZE);
        listaPacjentow = Utils.getListOfPatients(PACJENCI);
        wizyty = Utils.createListOfVisits(WIZYTY, listaLekarzy, listaPacjentow);
    }

    public List<String> listOfMostPopularSpecialisations(){
        return new ArrayList<>(getMostPopularSpecialisations().keySet());
    }

    private Map<String, Integer> getMapOfSpecialisations() {
        Map<String, Integer> mapOfSpecialisations = new HashMap<>();
        List<String> listOfAllSpecialisationOccurrences = listaLekarzy
                .stream()
                .map(Lekarz::getSpecjalnosc)
                .collect(Collectors.toList());
        Set<String> distinct = new HashSet<>(listOfAllSpecialisationOccurrences);

        for (String specialisation: distinct) {
            Integer frequency = Collections.frequency(listOfAllSpecialisationOccurrences, specialisation);
            mapOfSpecialisations.put(specialisation, frequency);
        }
        return mapOfSpecialisations;
    }

    private Map<String, Integer> getMostPopularSpecialisations() {
        Map<String, Integer> mapOfSpecialisations = getMapOfSpecialisations();
        Integer highestOccurrence = mapOfSpecialisations.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        return mapOfSpecialisations.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(highestOccurrence))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
