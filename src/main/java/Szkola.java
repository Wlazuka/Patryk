import java.util.*;
import java.util.stream.Collectors;

public class Szkola {


    private static final String UCZNIOWIE = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Pliki/uczniowie.txt";
    private static final String OCENY = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Pliki/oceny.txt";
    private List<Ocena> listaOcen;
    private List<Uczen> listaWszystkichUczniow;
    private Map<String, List<Uczen>> klasyWSzkole;

    public void uruchomSzkole() {
        listaOcen = Utils.utworzListeOcen(OCENY);
        listaWszystkichUczniow = Utils.utworzListeUczniow(UCZNIOWIE);
        klasyWSzkole = utworzKlasy();
        wstawOceny();
    }

    public List<Uczen> pobierzUczniowZUlic(String... ulice){
        return listaWszystkichUczniow.stream().filter(uczen -> Arrays.asList(ulice).contains(uczen.getAdres().getUlica())).collect(Collectors.toList());
    }

    public List<Uczen> pobierzUczniowZKlasy(String idKlasy){
        return listaWszystkichUczniow.stream().filter(uczen -> uczen.getiDKlasy().equals(idKlasy)).collect(Collectors.toList());
    }

    public Uczen getUczenByNameAndLastName(String imie, String nazwisko){
        return listaWszystkichUczniow.stream().filter(uczen -> uczen.getImie().equals(imie) && uczen.getNazwisko().equals(nazwisko)).findFirst().get();
    }

    public List<Uczen> getListaWszystkichUczniow() {
        return listaWszystkichUczniow;
    }

    public List<Ocena> getListaOcen() {
        return listaOcen;
    }

    private void wstawOceny() {
        for (Ocena ocena : listaOcen){
            Uczen uczen = listaWszystkichUczniow.stream().filter(u -> u.getIdUcznia() == ocena.getIdUcznia()).findFirst().get();
            uczen.wstawOcene(ocena);
        }
    }

    private Map<String, List<Uczen>> utworzKlasy() {
        return listaWszystkichUczniow.stream().collect(Collectors.groupingBy(Uczen::getiDKlasy));
    }

    public List<Uczen> getListaUczniowWKlasie(String idKlasy){
        return klasyWSzkole.get(idKlasy);
    }

    public List<SzkolnaKlasa> listaKlasWSzkole(){
        return klasyWSzkole.values().stream().map(SzkolnaKlasa::new).collect(Collectors.toList());
    }
}
