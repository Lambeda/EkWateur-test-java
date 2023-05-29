package main.java;

import main.java.builder.FactureBuilder;
import main.java.format.client.IdEkWateur;
import main.java.format.facture.Facture;
import main.java.utils.Constants;
import main.java.utils.DataNotFoundException;
import main.java.utils.InvalidIdentifiantException;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ParseException, InvalidIdentifiantException, DataNotFoundException, FileNotFoundException {
        // Méthode de tests : on attend un identifiant ekWateur en entrée
        Scanner in = new Scanner(System.in);
        String id = in.next();
        // on attend une date de début au format dd-mm-yyyy
        Date dateDebut =  new SimpleDateFormat(Constants.dateFormat).parse(in.next());
        // on attend une date de début au format dd-mm-yyyy
        Date dateFin =  new SimpleDateFormat(Constants.dateFormat).parse(in.next());

        // On crée une facture correspondant à la consommation entre les dates
        IdEkWateur idClient = new IdEkWateur(id);
        Facture factureClient = FactureBuilder.createFacture(idClient, dateDebut, dateFin);

        // on imprime ce qui nous a été demandé : le montant à facturer au client
        System.out.println("Montant facturé : " + factureClient.getMontantTotal() + "€");

        in.close();
    }
}