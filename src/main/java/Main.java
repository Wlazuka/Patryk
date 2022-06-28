import java.util.List;

public class Main {



    public static void main(String[] args) {
        Szkola szkola = new Szkola();
        szkola.uruchomSzkole();

        /**
         * Zadanie 1: Podaj ilość uczniów mieszkających poza szkołą. Na ulicach Sportowa i Wroncela
         */
        List<Uczen> uczniowieSpozaRejonu = szkola.pobierzUczniowZUlic("Sportowa", "Wroncela");
        System.out.println(uczniowieSpozaRejonu.size());


        /**
         * Zadanie 2: Wypisz oceny ucznia z przedmiotu: Jan Augustyniak, język polski
         */
        Uczen uczen = szkola.getUczenByNameAndLastName("Jan", "Augustyniak");
        List<Ocena> listaOcenZPolskliego = uczen.getListaOcenZPrzedmiotu("polski");
        listaOcenZPolskliego.forEach(System.out::println);

//        wypisz uczniów z klasy 3a


        List<Uczen> uczniowieWKlasie3a = szkola.getListaUczniowWKlasie("3a");
        uczniowieWKlasie3a.forEach(System.out::println);

//        /**
//         * Zadanie 3: Oblicz ile dziewcząt i chłopców jest w poszczególnych klasach
//         */
//
        List<SzkolnaKlasa> listaKlas = szkola.listaKlasWSzkole();
        listaKlas.forEach(k -> System.out.println());
//

    }
}
