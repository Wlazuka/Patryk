import java.util.ArrayList;
import java.util.List;

public class Przedmiot {

    private final int idPrzedmiotu;
    private final String nazwaPrzedmiotu;
    private final String nazwiskoNauczyciela;
    private final String imieNauczyciela;
    private List<Ocena> listaOcen;

    Przedmiot(int id, String nazwaPrzedmiotu, String nazwiskoNauczyciela, String imieNauczyciela) {
        this.idPrzedmiotu = id;
        this.nazwaPrzedmiotu = nazwaPrzedmiotu;
        this.nazwiskoNauczyciela = nazwiskoNauczyciela;
        this.imieNauczyciela = imieNauczyciela;
        this.listaOcen = new ArrayList<>();
    }

    public List<Ocena> getListaOcen() {
        return this.listaOcen;
    }

    public void przypiszOcene(Ocena ocena) {
        this.listaOcen.add(ocena);
    }

    public int getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    public String getNazwaPrzedmiotu() {
        return nazwaPrzedmiotu;
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "idPrzedmiotu=" + idPrzedmiotu +
                ", nazwaPrzedmiotu='" + nazwaPrzedmiotu + '\'' +
                ", nazwiskoNauczyciela='" + nazwiskoNauczyciela + '\'' +
                ", imieNauczyciela='" + imieNauczyciela + '\'' +
                '}';
    }

}
