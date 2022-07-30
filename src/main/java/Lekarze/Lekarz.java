package Lekarze;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lekarz {

    private final int id;
    private final String nazwisko;
    private final String imie;
    private final String specjalnosc;
    private final LocalDate dataUrodzenia;
    private final String nip;
    private final String pesel;
    private List<Wizyta> wizyty;

    public Lekarz(int id, String nazwisko, String imie, String specjalnosc, LocalDate dataUrodzenia, String nip, String pesel) {
        this.id = id;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.specjalnosc = specjalnosc;
        this.dataUrodzenia = dataUrodzenia;
        this.nip = nip;
        this.pesel = pesel;
    }

    public void setWizyty() {
        this.wizyty = Clinic.getWizyty().stream().filter(wizyta -> wizyta.getLekarz().getId() == this.id).collect(Collectors.toList());
    }

    public List<Wizyta> getWizyty() {
        return wizyty;
    }

    public List<Pacjent> getPatients(){
        return wizyty.stream().map(Wizyta::getPacjent).collect(Collectors.toList());
    }

    public Set<Pacjent> getUniquePatients(){
        return this.wizyty.stream().map(Wizyta::getPacjent).collect(Collectors.toSet());
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

    public String getSpecjalnosc() {
        return specjalnosc;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getNip() {
        return nip;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public String toString() {
        return "Lekarz{id: " + id + '}';
    }


//    @Override
//    public String toString() {
//        return "Lekarz{" +
//                "id=" + id  + '\n' +
//                ", nazwisko='" + nazwisko  + '\n' +
//                ", imie='" + imie + '\n' +
//                ", specjalnosc='" + specjalnosc + '\n' +
//                ", dataUrodzenia=" + dataUrodzenia + '\n' +
//                ", nip='" + nip + '\n' +
//                ", pesel='" + pesel + '\n' +
//                '}';
//    }
}
