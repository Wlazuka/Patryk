package Lekarze;

import java.time.LocalDate;

public class Pacjent {

    private final int id;
    private final String nazwisko;
    private final String imie;
    private final String pesel;
    private final LocalDate dataUrodzenia;


    public Pacjent(int id, String nazwisko, String imie, String pesel, LocalDate dataUrodzenia) {
        this.id = id;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
    }

    public int getId() {
        return id;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    @Override
    public String toString() {
        return "Pacjent{" +
                "id=" + id +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                '}';
    }
}
