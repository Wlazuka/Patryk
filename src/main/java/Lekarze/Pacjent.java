package Lekarze;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Pacjent {

    private final int id;
    private final String nazwisko;
    private final String imie;
    private final String pesel;
    private final LocalDate dataUrodzenia;
    private List<Wizyta> wizyty;

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

    public void setWizyty(){
        this.wizyty = Clinic.getWizyty().stream().filter(wizyta -> wizyta.getPacjent().getId() == this.id).collect(Collectors.toList());
    }

    public Set<Lekarz> getLekarzeUKtorychBylPacjent(){
       return this.wizyty.stream().map(Wizyta::getLekarz).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Pacjent{id:" + id + '}';
    }
//
//    @Override
//    public String toString() {
//        return "Pacjent{" +
//                "id=" + id + '\n' +
//                ", nazwisko='" + nazwisko + '\n' +
//                ", imie='" + imie + '\n' +
//                ", pesel='" + pesel + '\n' +
//                ", dataUrodzenia=" + dataUrodzenia +
//                '}';
//    }
}
