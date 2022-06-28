import java.util.List;

public class Uczen {

    private static final String PRZEDMIOTY = "/Users/wlazuka/IdeaProjects/Patryk/src/main/java/Pliki/przedmioty.txt";
    private final int idUcznia;
    private final String nazwisko;
    private final String imie;
    private final Adres adres;
    private final String iDKlasy;
    public List<Przedmiot> listaPrzedmiotowUcznia;

    public Uczen(int idUcznia, String nazwisko, String imie, Adres adres, String iDKlasy) {
        this.idUcznia = idUcznia;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.adres = adres;
        this.iDKlasy = iDKlasy;
        this.listaPrzedmiotowUcznia = Utils.utworzListePrzedmiotow(PRZEDMIOTY);
    }

    public void wstawOcene(Ocena ocena) {
        Przedmiot przedmiot = listaPrzedmiotowUcznia.stream().filter(p -> p.getIdPrzedmiotu() == ocena.getIdPrzedmiotu()).findFirst().get();
        przedmiot.przypiszOcene(ocena);
    }

    public List<Ocena> getListaOcenZPrzedmiotu(String nazwaPrzedmiotu){
        Przedmiot przedmiot = listaPrzedmiotowUcznia.stream().filter(p -> p.getNazwaPrzedmiotu().equals(nazwaPrzedmiotu)).findFirst().get();
        return przedmiot.getListaOcen();
    }

    public int getIdUcznia() {
        return idUcznia;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public Adres getAdres() {
        return adres;
    }

    public String getiDKlasy() {
        return iDKlasy;
    }

    public boolean czyChlopak(Uczen uczen){
        return !uczen.getImie().endsWith("a");
    }

    @Override
    public String toString() {

        String plec = czyChlopak(this) ? " chłopak " : " dziewczyna ";
        return "Uczen {" +
                "idUcznia = " + idUcznia +
                ", nazwisko = '" + nazwisko + '\'' +
                ", imie = '" + imie + '\'' +
                ", iDKlasy = '" + iDKlasy + '\'' +
                plec  + '\'' +
                '}';
    }
}
