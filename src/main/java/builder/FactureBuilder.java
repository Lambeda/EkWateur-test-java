package main.java.builder;

import main.java.format.client.Client;
import main.java.format.client.IdEkWateur;
import main.java.format.energie.TypeEnergie;
import main.java.format.facture.Facture;
import main.java.format.facture.FactureDetail;
import main.java.format.facture.Tarif;
import main.java.jdbc.ClientServiceDB;
import main.java.jdbc.ConsommationServiceDB;
import main.java.jdbc.TarifServiceDB;
import main.java.utils.DataNotFoundException;
import main.java.utils.InvalidIdentifiantException;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FactureBuilder {

    public static Facture createFacture(IdEkWateur id, Date debut, Date fin)
            throws DataNotFoundException, InvalidIdentifiantException, ParseException, FileNotFoundException {
        Facture res = null;

        Client client = ClientServiceDB.findClientById(id);

        HashMap<TypeEnergie, Integer> allConso = ConsommationServiceDB.getAllConsoClientBetweenDates(id, debut, fin);
        ArrayList<FactureDetail> details = new ArrayList<FactureDetail>();
        for (Map.Entry<TypeEnergie, Integer> conso: allConso.entrySet()) {
            TypeEnergie typeNRJ = conso.getKey();
            Integer consoNRJ = conso.getValue();
            Tarif tarif = TarifServiceDB.getTarif(typeNRJ, client.getType());
            details.add(new FactureDetail(tarif, consoNRJ, debut, fin));
        }

        res = new Facture(client, debut, fin, details);

        return res;
    }
}
