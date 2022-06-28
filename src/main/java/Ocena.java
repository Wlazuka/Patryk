import java.util.Date;

public class Ocena {

    private final int idUcznia;
    private final int ocena;
    private final Date data;
    private final int idPrzedmiotu;

    public Ocena(int idUcznia, int ocena, Date data, int idPrzedmiotu) {
        this.idUcznia = idUcznia;
        this.ocena = ocena;
        this.data = data;
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public int getIdUcznia() {
        return idUcznia;
    }

    public int getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    @Override
    public String toString() {
        return "Ocena{" +
                "idUcznia=" + idUcznia +
                ", ocena=" + ocena +
                ", data=" + data +
                ", idPrzedmiotu=" + idPrzedmiotu +
                '}';
    }
}
