package main.java.jdbc;

import main.java.utils.Constants;
import main.java.format.client.IdEkWateur;
import main.java.format.energie.TypeEnergie;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class ConsommationServiceDB {



    public static int getConsoClientByEnergyAndDate(IdEkWateur id,
                                                    TypeEnergie typeEnergie,
                                                    Date dateDebut,
                                                    Date dateFin) throws ParseException, FileNotFoundException {
        int res = 0;
        Scanner scanner = new Scanner(new File(Constants.pathToConsommationDB));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] contents = ParseurDB.parseLine(line);
            String currId = contents[0];
            TypeEnergie currTypeNRJ = TypeEnergie.valueOf(contents[1]);
            if (id.getNumericId().equals(currId) && typeEnergie.equals(currTypeNRJ)) {
                Date currDateDebut = new SimpleDateFormat(Constants.dateFormat).parse(contents[3]);
                Date currDateFin = new SimpleDateFormat(Constants.dateFormat).parse(contents[4]);
                if ((currDateDebut.after(dateDebut) || currDateDebut.equals(dateDebut)) &&
                    (currDateFin.before(dateFin) || currDateFin.equals(dateFin))) {
                    res += Integer.parseInt(contents[2]);
                }
            }
        }
        scanner.close();
        return res;
    }

    public static HashMap<TypeEnergie, Integer> getAllConsoClientBetweenDates(IdEkWateur id,
                                                                              Date dateDebut,
                                                                              Date dateFin) throws ParseException, FileNotFoundException {
        HashMap<TypeEnergie, Integer> res = new HashMap<TypeEnergie, Integer>();
        Scanner scanner = new Scanner(new File(Constants.pathToConsommationDB));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] contents = ParseurDB.parseLine(line);
            String currId = contents[0];
            TypeEnergie currTypeNRJ = TypeEnergie.valueOf(contents[1]);
            Date currDateDebut = new SimpleDateFormat(Constants.dateFormat).parse(contents[3]);
            Date currDateFin = new SimpleDateFormat(Constants.dateFormat).parse(contents[4]);
            if (id.getNumericId().equals(currId) &&
                    (currDateDebut.after(dateDebut) || currDateDebut.equals(dateDebut)) &&
                    (currDateFin.before(dateFin) || currDateFin.equals(dateFin))) {
                int conso = Integer.parseInt(contents[2]);
                res.merge(currTypeNRJ, conso, Integer::sum);
            }
        }
        scanner.close();
        return res;
    }
}
