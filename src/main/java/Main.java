import java.util.List;

public class Main {



    public static void main(String[] args) {
        Szkola szkola = new Szkola();
        szkola.uruchomSzkole();


        List<Uczen> uczniowieSpozaRejonu = szkola.pobierzUczniowZUlic("Sportowa");
        System.out.println(uczniowieSpozaRejonu.size());
        uczniowieSpozaRejonu.stream().map(Uczen::toString).forEach(System.out::println);

        List<Uczen> uczniowieZKlasy = szkola.pobierzUczniowZKlasy("3e");
        System.out.println(uczniowieZKlasy.size());
        uczniowieZKlasy.stream().map(Uczen::toString).forEach(System.out::println);


//        wyświetlOcenyUczniaZDanegoPrzedmiotu(imie, nazwisko, przedmiot);

        Uczen uczen = szkola.getUczenByNameAndLastName("Jan", "Augustyniak");
        List<Ocena> listaOcenZPolskliego = uczen.getListaOcenZPrzedmiotu("polski");
        listaOcenZPolskliego.forEach(System.out::println);
    }
}
