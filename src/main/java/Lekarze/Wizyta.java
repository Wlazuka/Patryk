package Lekarze;

import java.time.LocalDate;

public class Wizyta {

    private final Lekarz lekarz;
    private final Pacjent pacjent;
    private final LocalDate dataWizyty;

    public Wizyta(Lekarz szukanyLekarz, Pacjent szukanyPacjent, LocalDate date) {
        this.lekarz = szukanyLekarz;
        this.pacjent = szukanyPacjent;
        this.dataWizyty = date;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public LocalDate getDataWizyty() {
        return dataWizyty;
    }

    @Override
    public String toString() {
        return "Wizyta{" +
                "lekarz=" + lekarz + '\n' +
                ", pacjent=" + pacjent + '\n' +
                ", dataWizyty=" + dataWizyty + '\n' +
                '}';
    }
}
