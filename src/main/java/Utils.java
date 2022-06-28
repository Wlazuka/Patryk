import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    protected Utils() {
    }

    private static List<String> readTxtFile(String filePath) {
        List<String> allLines = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        allLines.remove(0);
        return allLines;
    }

    private static Uczen stworzUcznia(String linia) {
        String[] dane = linia.split(";");
        int idUcznia = Integer.parseInt(dane[0]);
        String nazwisko = dane[1];
        String imie = dane[2];
        String ulica = dane[3];
        int numerDomu = Integer.parseInt(dane[4]);
        Adres adres = new Adres(ulica, numerDomu);
        String iDKlasy = dane[5];
        return new Uczen(idUcznia, nazwisko, imie, adres, iDKlasy);
    }

    public static Uczen stworzUczniaRegex(String linia) {
        Pattern pattern = Pattern.compile("(\\d*).([A-Za-z]*).([a-zA-Z]*).([a-zA-Z]*).(\\d*).(\\d\\D)");
        Matcher matcher = pattern.matcher(linia);
        if (matcher.matches()) {
            int idUcznia = Integer.parseInt(matcher.group(1));
            String nazwisko = matcher.group(2);
            String imie = matcher.group(3);
            String ulica = matcher.group(4);
            int numerDomu = Integer.parseInt(matcher.group(5));
            Adres adres = new Adres(ulica, numerDomu);
            String iDKlasy = matcher.group(6);
            return new Uczen(idUcznia, nazwisko, imie, adres, iDKlasy);
        }
        return null;
    }

    public static List<Uczen> utworzListeUczniow(String filePath) {
        List<Uczen> listaUczniow = new ArrayList<>();
        for (String line : readTxtFile(filePath)) {
            Uczen uczen = stworzUcznia(line);
            listaUczniow.add(uczen);
        }
        return listaUczniow;
    }

    private static Przedmiot stworzPrzedmiot(String linia){
        String[] dane = linia.split(";");
        int idPrzedmiotu = Integer.parseInt(dane[0]);
        String nazwaPrzedmiotu = dane[1];
        String nazwiskoNauczyciela = dane[2];
        String imieNauczyciela = dane[3];
        return new Przedmiot(idPrzedmiotu, nazwaPrzedmiotu, nazwiskoNauczyciela, imieNauczyciela);
    }

    public static List<Przedmiot> utworzListePrzedmiotow(String filePath){
        List<Przedmiot> listaPrzedmiotow = new ArrayList<>();
        for (String line : readTxtFile(filePath)){
            Przedmiot przedmiot = stworzPrzedmiot(line);
            listaPrzedmiotow.add(przedmiot);
        }
        return listaPrzedmiotow;
    }

    private static Ocena stworzOcene(String linia) {
        String[] dane = linia.split(";");
        int idUcznia = Integer.parseInt(dane[0]);
        int ocena = Integer.parseInt(dane[1]);
        Date data = new Date();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            data = formatter.parse(dane[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int idPrzedmiotu = Integer.parseInt(dane[3]);
        return new Ocena(idUcznia, ocena, data, idPrzedmiotu);
    }

    public static List<Ocena> utworzListeOcen(String filePath) {
        List<Ocena> listaOcen = new ArrayList<>();
        for (String line : readTxtFile(filePath)) {
            Ocena ocena = stworzOcene(line);
            listaOcen.add(ocena);
        }
        return listaOcen;
    }
}
