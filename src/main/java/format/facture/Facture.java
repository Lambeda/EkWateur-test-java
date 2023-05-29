package main.java.format.facture;

import main.java.format.client.Client;
import java.util.Date;
import java.util.List;

public class Facture {
    private Client client;
    private Date dateDebut;
    private Date dateFin;
    private double montantTotal;
    private List<FactureDetail> details;

    public Facture(Client client, Date dateDebut, Date dateFin, List<FactureDetail> details) {
        this.client = client;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.details = details;
        calculateMontantTotal();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public List<FactureDetail> getDetails() {
        return details;
    }

    public void setDetails(List<FactureDetail> details) {
        this.details = details;
        calculateMontantTotal();
    }

    private void calculateMontantTotal() {
        montantTotal = 0;
        for (FactureDetail detail : details) {
            montantTotal += detail.getMontantCalcule();
        }
    }

}
