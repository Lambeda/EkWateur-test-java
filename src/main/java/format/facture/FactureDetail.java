package main.java.format.facture;

import java.util.Date;

public class FactureDetail {
    private Tarif tarif;
    private Date dateDebutFacturation;
    private Date dateFinFacturation;
    private int consommation;
    private double montantCalcule;

    public FactureDetail(Tarif tarif, int consommation, Date dateDebutFacturation, Date dateFinFacturation) {
        this.tarif = tarif;
        this.dateDebutFacturation = dateDebutFacturation;
        this.dateFinFacturation = dateFinFacturation;
        this.consommation = consommation;
        calculateMontant();
    }

    public double getMontantCalcule() {
        return montantCalcule;
    }

    public int getConsommation() {
        return consommation;
    }

    public void setConsommation(int consommation) {
        this.consommation = consommation;
        calculateMontant();
    }

    public Tarif getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
        calculateMontant();
    }

    public Date getDateDebutFacturation() {
        return dateDebutFacturation;
    }

    public void setDateDebutFacturation(Date dateDebutFacturation) {
        this.dateDebutFacturation = dateDebutFacturation;
    }

    public Date getDateFinFacturation() {
        return dateFinFacturation;
    }

    public void setDateFinFacturation(Date dateFinFacturation) {
        this.dateFinFacturation = dateFinFacturation;
    }

    private void calculateMontant() {
        montantCalcule = (double) consommation * tarif.getPrix();
        // on arrondi à 2 décimals après la virgule
        montantCalcule = Math.round(montantCalcule * 100.0) / 100.0;
    }
}
