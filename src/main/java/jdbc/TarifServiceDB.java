package main.java.jdbc;

import main.java.utils.Constants;
import main.java.format.client.TypeClient;
import main.java.format.energie.TypeEnergie;
import main.java.format.facture.Tarif;
import main.java.utils.DataNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TarifServiceDB {

    public static Tarif getTarif(TypeEnergie typeEnergie, TypeClient typeClient) throws DataNotFoundException, FileNotFoundException {
        return new Tarif(typeEnergie, typeClient, getPrix(typeEnergie, typeClient));
    }

    public static double getPrix(TypeEnergie typeEnergie, TypeClient typeClient) throws DataNotFoundException, FileNotFoundException {
        double res = -1;
        Scanner scanner = new Scanner(new File(Constants.pathToTarifDB));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] contents = ParseurDB.parseLine(line);
            TypeClient currTypeClient = TypeClient.valueOf(contents[0]);
            TypeEnergie currTypeNRJ = TypeEnergie.valueOf(contents[1]);
            if (currTypeNRJ.equals(typeEnergie) && currTypeClient.equals(typeClient)) {
                res = Double.parseDouble(contents[2]);
                break;
            }
        }
        scanner.close();
        if (res < 0) {
            throw new DataNotFoundException("Prix " + typeEnergie.toString() + " non trouvé pour " + typeClient.toString());
        }
        return res;
    }
}
