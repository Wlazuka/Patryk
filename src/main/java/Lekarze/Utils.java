package Lekarze;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;


public class Utils {

    protected Utils() {
    }

    public static List<Lekarz> getListOfDoctors(String filePath) {
        List<Lekarz> lekarze = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(filePath));
            input.useDelimiter("\t|\r\r|\n\n\n");
            while (input.hasNext()) {
                int id = Integer.parseInt(input.next());
                String lastName = input.next();
                String name = input.next();
                String specialty = input.next();
                String birthDateString = input.next();
                String[] birthDateData = birthDateString.split("-");
                LocalDate birthDate = LocalDate.of(Integer.parseInt(birthDateData[0]), Integer.parseInt(birthDateData[1]), Integer.parseInt(birthDateData[2]));
                String nip = input.next();
                String pesel = input.next();
                lekarze.add(new Lekarz(id, lastName, name, specialty, birthDate, nip, pesel));
            }
        } catch (FileNotFoundException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return lekarze;
    }

    public static List<Wizyta> createListOfVisits(String filePath, List<Lekarz> lekarze, List<Pacjent> pacjenci){
        List<Wizyta> wizyty = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(filePath));
            input.useDelimiter("\t|\r\r|\n\n\n");
            while (input.hasNext()) {
                int idLekarza = Integer.parseInt(input.next());
                int idPacjenta = Integer.parseInt(input.next());
                String dateString = input.next();
                String[] dateData = dateString.split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateData[0]), Integer.parseInt(dateData[1]), Integer.parseInt(dateData[2]));

                Lekarz szukanyLekarz = lekarze.stream().filter(lekarz -> lekarz.getId() == idLekarza).findFirst().get();
                Pacjent szukanyPacjent = pacjenci.stream().filter(pacjent -> pacjent.getId() == idPacjenta).findFirst().get();

                wizyty.add(new Wizyta(szukanyLekarz, szukanyPacjent, date));
            }
        } catch (FileNotFoundException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return wizyty;
    }


    public static List<Pacjent> getListOfPatients(String filePath) {
        List<Pacjent> pacjents = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(filePath));
            input.useDelimiter("\t|\r\r");
            while (input.hasNext()) {
                int id = Integer.parseInt(input.next());
                String lastName = input.next();
                String name = input.next();
                String pesel = input.next();
                String birthDateString = input.next();
                String[] birthDateData = birthDateString.split("-");
                LocalDate birthDate = LocalDate.of(Integer.parseInt(birthDateData[0]), Integer.parseInt(birthDateData[1]), Integer.parseInt(birthDateData[2]));
                pacjents.add(new Pacjent(id, lastName, name, pesel, birthDate));
            }
        } catch (FileNotFoundException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return pacjents;
    }

//    public static Pacjent stworzPacjenta3(String line) {
//        Pattern pattern = Pattern.compile("/([\\d]*)([\\s]*)([a-zA-Z]*)([\\s]*)([a-zA-Z]*)([\\s])([\\d]{11})([\\s])([\\d]{4}-[\\d]{1,2}-[\\d]{1,2})");
//        Matcher matcher = pattern.matcher(line);
//        if (matcher.matches()) {
//            int id = Integer.parseInt(matcher.group(1));
//            String lastName = matcher.group(3);
//            String name = matcher.group(5);
//            String pesel = matcher.group(7);
//            String birthDateString = matcher.group(9);
//            String[] birthDateData = birthDateString.split("-");
//            LocalDate birthDate = LocalDate.of(Integer.parseInt(birthDateData[0]), Integer.parseInt(birthDateData[1]), Integer.parseInt(birthDateData[2]));
//            return new Pacjent(id,  lastName,  name,  pesel, birthDate);
//        }
//        return null;
//    }
}
