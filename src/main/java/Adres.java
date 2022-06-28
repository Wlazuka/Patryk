public class Adres {

    private String ulica;
    private int numerDomu;

    public Adres(String ulica, int numerDomu) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
    }

    public String getUlica() {
        return ulica;
    }

    public int getNumerDomu() {
        return numerDomu;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "ulica = '" + ulica + '\'' +
                ", numerDomu = " + numerDomu +
                '}';
    }
}
