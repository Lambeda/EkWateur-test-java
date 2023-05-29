package main.java.format.facture;

import main.java.format.client.TypeClient;
import main.java.format.energie.TypeEnergie;

public class Tarif {
    private TypeEnergie typeEnergie;
    private TypeClient typeClient;
    private double prix;

    public Tarif(TypeEnergie typeEnergie, TypeClient typeClient, double prix) {
        this.typeEnergie = typeEnergie;
        this.typeClient = typeClient;
        this.prix = prix;
    }

    public TypeEnergie getTypeEnergie() {
        return typeEnergie;
    }

    public void setTypeEnergie(TypeEnergie typeEnergie) {
        this.typeEnergie = typeEnergie;
    }

    public TypeClient getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(TypeClient typeClient) {
        this.typeClient = typeClient;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
