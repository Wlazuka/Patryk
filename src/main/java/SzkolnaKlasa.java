import java.util.List;

public class SzkolnaKlasa {

    private List<Uczen> listaUczniowWKlasie;

    public SzkolnaKlasa(List<Uczen> listaUczniowWKlasie) {
        this.listaUczniowWKlasie = listaUczniowWKlasie;
    }

    public List<Uczen> getListaUczniowWKlasie(){
        return listaUczniowWKlasie;
    }

    @Override
    public String toString() {
        return "SzkolnaKlasa{" +
                "listaUczniowWKlasie=" + listaUczniowWKlasie +
                '}';
    }
}
