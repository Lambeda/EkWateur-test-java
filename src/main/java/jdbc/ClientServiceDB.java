package main.java.jdbc;

import main.java.utils.Constants;
import main.java.format.client.*;
import main.java.utils.DataNotFoundException;
import main.java.utils.InvalidIdentifiantException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientServiceDB {

    public static Client findClientById(IdEkWateur id) throws InvalidIdentifiantException, DataNotFoundException, FileNotFoundException {
        Client res = null;
        Scanner scanner = new Scanner(new File(Constants.pathToClientDB));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] contents = ParseurDB.parseLine(line);
            if (id.getNumericId().equals(contents[0])) {
                if (contents[1].equals(TypeClient.PARTICULIER.toString())) {
                    res = findClientPartById(id);
                } else {
                    res = findClientProById(id);
                }
                break;
            }
        }
        scanner.close();

        if (null == res) {
            throw new DataNotFoundException("Client n°" + id.getIdEkWateur() + " non trouvé");
        }
        return res;
    }

    private static ClientPart findClientPartById(IdEkWateur id) throws DataNotFoundException, FileNotFoundException {
        ClientPart res = null;
        Scanner scanner = new Scanner(new File(Constants.pathToClientPartDB));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] contents = ParseurDB.parseLine(line);
            if (id.getNumericId().equals(contents[0])) {
                Civilite civilite = Civilite.valueOf(contents[1]);
                String nom = contents[2];
                String prenom = contents[3];
                res = new ClientPart(id, civilite, nom, prenom);
                break;
            }
        }
        scanner.close();

        if (null == res) {
            throw new DataNotFoundException("Client n°" + id.getIdEkWateur() + " non trouvé");
        }

        return res;
    }

    private static ClientPro findClientProById(IdEkWateur id) throws InvalidIdentifiantException, DataNotFoundException, FileNotFoundException {
        ClientPro res = null;
        Scanner scanner = new Scanner(new File(Constants.pathToClientProDB));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] contents = ParseurDB.parseLine(line);
            if (id.getNumericId().equals(contents[0])) {
                Siret siret = new Siret(contents[1]);
                String raisonSociale = contents[2];
                long ca = Long.parseLong(contents[3]);
                res = new ClientPro(id, siret, raisonSociale, ca);
                break;
            }
        }
        scanner.close();

        if (null == res) {
            throw new DataNotFoundException("Client n°" + id.getIdEkWateur() + " non trouvé");
        }

        return res;
    }
}
